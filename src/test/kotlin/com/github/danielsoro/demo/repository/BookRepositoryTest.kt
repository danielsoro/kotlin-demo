package com.github.danielsoro.demo.repository

import com.github.danielsoro.demo.model.Author
import com.github.danielsoro.demo.model.Book
import java.util.UUID
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
@DirtiesContext
class BookRepositoryTest {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Test
    fun `should not create book with same name`() {
        val author = authorRepository.save(
            Author(null, "Daniel Cunha", null)
        )


        assertThrows<DataIntegrityViolationException> {
            bookRepository.save(
                Book(
                    null,
                    "Book 1",
                    author
                )
            )

            bookRepository.save(
                Book(
                    null,
                    "Book 1",
                    author
                )
            )
        }
    }

    @Test
    fun `should return book by name`() {
        val author = authorRepository.save(
            Author(null, "Author ${UUID.randomUUID()}", null)
        )

        for (i in 10..20) {
            bookRepository.save(
                Book(
                    null,
                    "Book $i",
                    author
                )
            )
        }

        val book4 = bookRepository.findByName("Book 10")
        assertNotNull(book4)
        assertNotNull(book4.id)
        assertNotNull(book4.name)
        assertNotNull(book4.author.id)
        assertNotNull(book4.author.name)
    }

    @Test
    fun `should return books by author`() {
        val booksByAuthor = bookRepository.findByAuthorName("Daniel Cunha")
        assertNotNull(booksByAuthor);
        assertTrue(booksByAuthor.size > 0)
    }
}
