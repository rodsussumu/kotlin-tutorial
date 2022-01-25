package com.rodrigofirstapp.controller.response

import com.rodrigofirstapp.enums.BookStatus
import com.rodrigofirstapp.model.CustomerModel
import java.math.BigDecimal

data class BookResponse (
    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)
