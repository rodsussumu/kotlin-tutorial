package com.rodrigofirstapp.controller

import com.rodrigofirstapp.controller.request.PostBookRequest
import com.rodrigofirstapp.controller.request.PutBookRequest
import com.rodrigofirstapp.controller.response.BookResponse
import com.rodrigofirstapp.extension.toBookModel
import com.rodrigofirstapp.extension.toResponse
import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.service.BookService
import com.rodrigofirstapp.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
        val customer = customerService.findById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun getAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findAll(pageable).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun getActivies(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookModel> {
        return bookService.findActivies(pageable)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): BookResponse {
        return bookService.findById(id).toResponse()
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