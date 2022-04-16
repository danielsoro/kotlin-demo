package com.github.danielsoro.demo.resource.author

import java.util.UUID

data class AuthorItem(var id: UUID? = null,
                      val name: String) {
}
