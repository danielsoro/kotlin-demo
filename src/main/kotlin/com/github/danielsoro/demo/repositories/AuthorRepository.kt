package com.github.danielsoro.demo.repositories

import com.github.danielsoro.demo.models.Author
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, UUID>
