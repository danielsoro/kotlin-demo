package com.github.danielsoro.demo.resource.book

import com.github.danielsoro.demo.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookResource(private val bookService: BookService) {

    @GetMapping
    fun getBooks(): List<BookItem> = bookService.findAll();

}
