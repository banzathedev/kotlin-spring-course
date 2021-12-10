package com.banzailivros.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @GetMapping
    fun helloWorld(): String {
        return "hello world"
    }
}