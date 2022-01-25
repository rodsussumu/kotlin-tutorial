package com.rodrigofirstapp.repository

import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
}