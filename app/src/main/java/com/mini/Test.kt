package com.mini

import com.mini.Drink.Companion.MENU_AMERICANO
import com.mini.Drink.Companion.MENU_CHERRY_ADE
import com.mini.Drink.Companion.MENU_VANILLA_LATTE
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


/**
 * Channel : 코루틴 간에 데이터를 안전하게 전송하기 위한 도구 FIFO 큐형태
 * 생성자를 통해 큐의 크기를 설정할 수 있음
 * 큐의 크기를 설정하지 않으면 버퍼 용량이 없는 무한한 크기의 채널이 생성됨
 *
 * send() 함수를 사용하여 데이터를 큐에 추가 - 큐가 가득차면 블로킹
 * receive() 함수를 사용하여 큐에 데이터 추출 - 큐가 비어있으면 블로킹
 * close() 함수를 사용하여 Channel을 닫을 수 있음 - 추가적인 데이터를 보낼 수 없음
 **/
data class Order(val menu: String, val customerName: String)

val orderQueue = Channel<Order>(Channel.UNLIMITED)
val machineMutex = Mutex()

suspend fun makeDrink(order: Order) {
    machineMutex.withLock {
        val time:Long = when (order.menu) {
            MENU_AMERICANO -> 3000
            MENU_VANILLA_LATTE , MENU_CHERRY_ADE -> 5000
            else -> 1000 // 에스프레소
        }

        println("${order.customerName}님의 ${order.menu}를 제조 중...")
        delay(time)
        println("${order.customerName}님의 ${order.menu}가 준비되었습니다.")
    }
}

fun main() = runBlocking {
    val orders = listOf(
        Order(menu = "아메리카노", customerName = "손님 1"),
        Order(menu = "바닐라라떼", customerName = "손님 2"),
        Order(menu = "아메리카노", customerName = "손님 3"),
        Order(menu = "바닐라라떼", customerName = "손님 4"),
        Order(menu = "체리에이드", customerName = "손님 5"),
        Order(menu = "바닐라라떼", customerName = "손님 6"),
    )

    launch {
        for (order in orderQueue) {
            makeDrink(order)
        }
    }

    orders.forEachIndexed { index, order ->
        launch {
            delay(index * 2000L)
            orderQueue.send(order)
            println("${order.customerName}님의 ${order.menu} 주문을 받았습니다")
        }
    }

    delay(6000L)

    val newOrders = listOf(
        Order(menu = "에스프레소", customerName = "손님 7"),
        Order(menu = "바닐라라떼", customerName = "손님 8"),
        Order(menu = "아메리카노", customerName = "손님 9"),
    )

    newOrders.forEachIndexed { index, order ->
        launch {
            delay(index * 2000L)
            orderQueue.send(order)
            println("${order.customerName}님의 ${order.menu} 주문을 받았습니다")
        }
    }
}