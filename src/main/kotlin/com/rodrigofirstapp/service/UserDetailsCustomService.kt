package com.rodrigofirstapp.service

import com.rodrigofirstapp.exception.AuthenticationException
import com.rodrigofirstapp.repository.CustomerRepository
import com.rodrigofirstapp.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val customerRepository: CustomerRepository
): UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt()).orElseThrow{AuthenticationException("Usuario não encontrado", "999")}
        return UserCustomDetails(customer)
    }
}