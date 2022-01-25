package com.rodrigofirstapp.service

import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save((book))
    }

}
