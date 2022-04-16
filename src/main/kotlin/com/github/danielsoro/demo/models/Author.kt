package com.github.danielsoro.demo.models

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "authors")
class Author(
    @Id
    @GeneratedValue
    var id: UUID? = null,
    val name: String,
    @OneToMany(mappedBy = "author")
    var books: Set<Book>? = null
)
