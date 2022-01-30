package com.rodrigofirstapp.repository

import com.rodrigofirstapp.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<PurchaseModel, Int> {
}
