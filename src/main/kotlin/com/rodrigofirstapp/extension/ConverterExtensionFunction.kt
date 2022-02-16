package com.rodrigofirstapp.extension

import com.rodrigofirstapp.controller.request.PostBookRequest
import com.rodrigofirstapp.controller.request.PostCustomerRequest
import com.rodrigofirstapp.controller.request.PutBookRequest
import com.rodrigofirstapp.controller.request.PutCustomerRequest
import com.rodrigofirstapp.controller.response.BookResponse
import com.rodrigofirstapp.controller.response.CustomerResponse
import com.rodrigofirstapp.controller.response.PageResponse
import com.rodrigofirstapp.enums.BookStatus
import com.rodrigofirstapp.enums.CustomerStatus
import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.model.CustomerModel
import org.springframework.data.domain.Page

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO,
        password = this.password
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id= previousValue.id,
        name = this.name ?: previousValue.name,
        email = this.email ?: previousValue.email,
        status = previousValue.status,
        password = previousValue.password
    );
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.name,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
        this.content,
        this.number,
        this.totalElements,
        this.totalPages
    )
}