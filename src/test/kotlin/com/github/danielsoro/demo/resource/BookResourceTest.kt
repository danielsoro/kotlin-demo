package com.github.danielsoro.demo.resource

import javax.transaction.Transactional
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookResourceTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    @Transactional
    fun `should return empty`() {
        val response = restTemplate.getForEntity("/books", List::class.java)
        assertEquals(HttpStatus.OK, response?.statusCode)
        assertEquals(0, response.body?.size)
    }
}
