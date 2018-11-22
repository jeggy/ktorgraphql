package net.jebster.graphql

import com.github.pgutkowski.kgraphql.KGraphQL

val schema = KGraphQL.schema {
    configure {
        useDefaultPrettyPrinter = true
    }

    query("test") {
        resolver { -> "Hello World" }
    }
    mutation("test") {
        resolver { -> "Hello World" }
    }

    query("me") {
        resolver { name: String -> MyType(1, name) }
    }

    type<MyType>() {
        property<String>("extra") {
            resolver { "Hello, ${it.name}!" }
        }
    }
}

data class MyType(
    val id: Int,
    val name: String
)
