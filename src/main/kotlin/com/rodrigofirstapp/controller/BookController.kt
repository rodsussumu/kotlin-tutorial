package com.rodrigofirstapp.controller

import com.rodrigofirstapp.controller.request.PostBookRequest
import com.rodrigofirstapp.extension.toBookModel
import com.rodrigofirstapp.service.BookService
import com.rodrigofirstapp.service.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController (
    val customerService: CustomerService,
    val bookService: BookService
        ){

    @PostMapping
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }
}