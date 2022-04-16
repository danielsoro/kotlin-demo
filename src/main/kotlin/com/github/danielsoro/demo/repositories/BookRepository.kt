package com.github.danielsoro.demo.repositories

import com.github.danielsoro.demo.models.Book
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, UUID> {
    fun findByName(name: String): Book
    fun findByAuthorName(name: String): Set<Book>
}
