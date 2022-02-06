package com.rodrigofirstapp.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin")
class AdminController() {

    @GetMapping("/report")
    fun report(): String {
        return "This is a report. Only admin can see this"
    }

}