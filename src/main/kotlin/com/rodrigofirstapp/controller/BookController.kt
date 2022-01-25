package com.rodrigofirstapp.controller

import com.rodrigofirstapp.controller.request.PostBookRequest
import com.rodrigofirstapp.controller.request.PutBookRequest
import com.rodrigofirstapp.extension.toBookModel
import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.service.BookService
import com.rodrigofirstapp.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
    val customerService: CustomerService,
    val bookService: BookService
        ){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun getAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun getActivies(): List<BookModel> {
        return bookService.findActivies()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        var bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}