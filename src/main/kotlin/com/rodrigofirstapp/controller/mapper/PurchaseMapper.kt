package com.rodrigofirstapp.controller.mapper

import com.rodrigofirstapp.controller.request.PostPurchaseRequest
import com.rodrigofirstapp.model.PurchaseModel
import com.rodrigofirstapp.service.BookService
import com.rodrigofirstapp.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {
    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)
        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}