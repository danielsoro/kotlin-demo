package com.github.danielsoro.demo.services

import com.github.danielsoro.demo.repositories.BookRepository
import com.github.danielsoro.demo.resources.book.BookItem
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {
    fun findAll(): List<BookItem> = bookRepository.findAll()
        .stream()
        .map { BookItem(id = it.id, name = it.name) }
        .toList();
}
