package com.rodrigofirstapp.enums

enum class Errors(val code: String, val message: String) {

    ML000("ML-000", "Unauthorized"),
    ML001("ML-0001", "Invalid request"),
    ML101("ML-101", "Book %s not exists"),
    ML102("ML-102", "Cannot update book with status %s"),
    ML201("ML-201", "Customer %s not exists")
}