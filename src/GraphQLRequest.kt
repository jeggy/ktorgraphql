package net.jebster

data class GraphQLRequest(
    val query: String?,
    val mutation: String?,
    val variables: Map<String, Any?>
)