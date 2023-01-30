package com.dn.inventory.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "3. HealthCheck API")
class HealthCheckController {

    @GetMapping("/")
    fun healthCheck(): String {
        return "hello"
    }
}