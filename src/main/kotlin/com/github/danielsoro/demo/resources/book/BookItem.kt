package com.github.danielsoro.demo.resources.book

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class BookItem(  @JsonProperty var id: UUID? = null,
                      @JsonProperty val name: String)
