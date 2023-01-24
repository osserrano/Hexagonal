package org.xavrs.streaming.springboot3.application.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.xavrs.streaming.springboot3.application.adapter.ItemAdapter
import org.xavrs.streaming.springboot3.application.controller.model.ItemDTO

@Controller
@RequestMapping("/api")
class ItemController (private val itemAdapter: ItemAdapter){
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/item", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getItem(@RequestParam reference: String, @RequestParam color: String) : ResponseEntity<ItemDTO?> {
        return itemAdapter.getItemForController(reference,color)
    }
}