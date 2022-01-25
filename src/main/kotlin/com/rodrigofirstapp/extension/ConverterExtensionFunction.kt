package com.rodrigofirstapp.extension

import com.rodrigofirstapp.controller.request.PostBookRequest
import com.rodrigofirstapp.controller.request.PostCustomerRequest
import com.rodrigofirstapp.controller.request.PutBookRequest
import com.rodrigofirstapp.controller.request.PutCustomerRequest
import com.rodrigofirstapp.enums.BookStatus
import com.rodrigofirstapp.model.BookModel
import com.rodrigofirstapp.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email);
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id=id, name = this.name, email = this.email);
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