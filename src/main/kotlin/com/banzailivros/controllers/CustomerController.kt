package com.banzailivros.controllers

import com.banzailivros.controllers.request.PostCustomerRequest
import com.banzailivros.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()
    var mId: Int = 0

    @GetMapping
    fun getCustomer(): List<CustomerModel> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        val foundCustomer = CustomerModel(id = mId++.toString(), customer.email, customer.name)
        customers.add(foundCustomer)
    }

}