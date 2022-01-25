package com.rodrigofirstapp.controller.response

import com.rodrigofirstapp.enums.CustomerStatus
import javax.persistence.*

data class CustomerResponse (
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
)
