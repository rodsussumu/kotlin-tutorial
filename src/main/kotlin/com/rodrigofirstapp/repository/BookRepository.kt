package com.rodrigofirstapp.repository

import com.rodrigofirstapp.enums.BookStatus
import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>
}