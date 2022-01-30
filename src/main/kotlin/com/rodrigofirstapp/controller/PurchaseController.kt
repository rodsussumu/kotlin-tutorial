package com.rodrigofirstapp.controller

import com.rodrigofirstapp.controller.mapper.PurchaseMapper
import com.rodrigofirstapp.controller.request.PostPurchaseRequest
import com.rodrigofirstapp.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("purchase")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }
}