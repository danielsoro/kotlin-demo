package com.github.danielsoro.demo.repository

import com.github.danielsoro.demo.model.Author
import com.github.danielsoro.demo.model.Book
import javax.transaction.Transactional
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException

@SpringBootTest
class BookRepositoryTest(
    @Autowired val bookRepository: BookRepository,
    @Autowired val authorRepository: AuthorRepository
) {

    @Test
    @Transactional
    fun `should not create book with same name`() {
        val author = authorRepository.save(
            Author(name = "Daniel Cunha")
        )


        assertThrows<DataIntegrityViolationException> {
            bookRepository.save(
                Book(
                    name = "Book 1",
                    author = author
                )
            )

            bookRepository.save(
                Book(
                    name = "Book 1",
                    author = author
                )
            )

            bookRepository.flush()
        }
    }

    @Test
    @Transactional
    fun `should return book by name`() {
        val author = authorRepository.save(
            Author(name = "Daniel Cunha")
        )

        for (i in 1..20) {
            bookRepository.save(
                Book(
                    name = "Book $i",
                    author = author
                )
            )
        }

        val book4 = bookRepository.findByName("Book 10")
        assertNotNull(book4)
        assertNotNull(book4.name)
        assertNotNull(book4.author.id)
        assertNotNull(book4.author.name)
    }

    @Test
    @Transactional
    fun `should return books by author`() {
        val author = authorRepository.save(
            Author(name = "Daniel Cunha")
        )

        bookRepository.save(
            Book(
                name = "Book 1",
                author = author
            )
        )

        val booksByAuthor = bookRepository.findByAuthorName("Daniel Cunha")
        assertNotNull(booksByAuthor)
        assertTrue(booksByAuthor.size > 0)
    }

    @Test
    fun `should return EmptyResultDataAccessException when not found book`() {
        assertThrows<EmptyResultDataAccessException> {
            bookRepository.findByName("aloha")
        }
    }

    @Test
    fun `should return empty list when not found book by author`() {
        val books = bookRepository.findByAuthorName("aloha")
        assertNotNull(books)
        assertEquals(0, books.size)
    }
}
