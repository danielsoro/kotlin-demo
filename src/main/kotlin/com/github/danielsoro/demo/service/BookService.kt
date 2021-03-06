package com.github.danielsoro.demo.service

import com.github.danielsoro.demo.repository.BookRepository
import com.github.danielsoro.demo.resource.book.BookItem
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun findAll(): List<BookItem> = bookRepository.findAll()
        .map { BookItem(id = it.id, name = it.name) }
        .toList();
}
