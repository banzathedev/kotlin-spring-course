package com.banzailivros.service

import com.banzailivros.controllers.request.PostCustomerRequest
import com.banzailivros.controllers.request.PutCustomerRequest
import com.banzailivros.model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()
    var mId: Int = 0

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun createCustomer(customer: PostCustomerRequest) {
        val foundCustomer = CustomerModel(id = mId++.toString(), customer.email, customer.name)
        customers.add(foundCustomer)
    }

    fun getCustomerById(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun updateCustomer(id: String, customer: PutCustomerRequest) {
        customers.filter { it.id == id }.first().let { foundCustomer ->
            foundCustomer.name = customer.name
            foundCustomer.email = customer.email
        }
    }

    fun deleteCustomerById(@PathVariable id: String) {
        customers.removeIf { it.id == id }
    }
}