package com.github.danielsoro.demo.repository

import com.github.danielsoro.demo.model.Author
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, UUID>
