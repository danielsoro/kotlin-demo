package com.github.danielsoro.demo.resources.author

import java.util.UUID

data class AuthorItem(var id: UUID? = null,
                      val name: String) {
}
