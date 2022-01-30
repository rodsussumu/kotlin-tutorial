package com.rodrigofirstapp.service

import com.rodrigofirstapp.event.PurchaseEvent
import com.rodrigofirstapp.model.PurchaseModel
import com.rodrigofirstapp.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPubliser: ApplicationEventPublisher
) {
    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        applicationEventPubliser.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
