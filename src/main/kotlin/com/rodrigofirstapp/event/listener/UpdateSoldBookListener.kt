package com.rodrigofirstapp.event.listener

import com.rodrigofirstapp.event.PurchaseEvent
import com.rodrigofirstapp.service.BookService
import com.rodrigofirstapp.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}