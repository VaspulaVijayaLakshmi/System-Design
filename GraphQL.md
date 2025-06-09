GraphQL,  query language ,  allows clients to request exactly the data they need in a single request.


![image](https://github.com/user-attachments/assets/c4509243-24b5-47ed-8b58-203661ecdb46)




 ____________                                                                              


Drawbacks with REST :



-> Over-fetching: REST endpoints often return more data than needed, leading to inefficient network usage.
For example, if a user only needs a user’s name and email, but the API response includes additional fields like address, phone number, and metadata, it results in wasted bandwidth.


-> Under-fetching: If an API doesn’t return related data, the client may need to make multiple requests to retrieve all required information.
For example, to get user details and their posts, a client might have to make: (Given these apis are designed this way for  better separation of concerns)


GET /api/users/123 (fetch user)
GET /api/users/123/posts (fetch user’s posts)


-> Versioning issues: When APIs evolve, maintaining backward compatibility becomes difficult. REST APIs often require versioned URLs (/v1/users, /v2/users), adding maintenance overhead.

-> Rigid Response Structure: The server defines how data is returned, and clients must adapt to it—even if they only need a subset of the data.



_______________



GRAPHQL :



A single GraphQL endpoint (/graphql) replaces multiple REST endpoints, allowing clients to structure their own queries(Single request multiple resources).

GraphQL aggregates the data from multiple services and returns precisely the requested data.
It solves the problems of over-fetching (getting unnecessary data) and under-fetching (requiring multiple requests to retrieve related data).
It  enforces a strict schema that defines the shape of the data.
API Evolution Without Versioning: New fields can be added without breaking existing queries, avoiding REST-style /v1, /v2 versioning issues.
   


_____________


MICRONAUT IMPLEMENTATION:



-> Add the following dependency in build.gradle
  implementation("io.micronaut.graphql:micronaut-graphql")

  By default GraphQL endpoint /graphql is enabled.



-> Describe the schemas in
schema.graphqls in src/main/resources directory:



____________



GraphiQL :

GraphiQL is the GraphQL IDE for executing GraphQL queries.

Add this config in src/main/resources/application.properties
graphql.graphiql.enabled=true



![image](https://github.com/user-attachments/assets/d8d5bdc9-4f46-4dc8-a243-ff1af78afab7)





_________________

Instrumentation :

GraphQL APIs must be carefully optimized to prevent performance issues.
Unoptimized queries (e.g., deeply nested requests or complex queries) can lead to costly database scans.
If a poorly designed query is executed on a high-traffic service, it could bring down the entire database.
To mitigate this, GraphQL APIs require strict query rate limiting, depth restrictions.




// MaxQueryDepthInstrumentation to block deeply nested queries

@Singleton
class DepthLimitingInstrumentation : MaxQueryDepthInstrumentation(MAX_QUERY_DEPTH)


![image](https://github.com/user-attachments/assets/ca758a41-2e9e-4bad-b37f-c8d86d59a37c)



_______



//MaxQueryComplexityInstrumentation - Prevent queries that fetch too many fields


@Singleton
class ComplexityLimitingInstrumentation : MaxQueryComplexityInstrumentation(MAX_QUERY_COMPLEXITY)

![image](https://github.com/user-attachments/assets/1e08e0f3-c596-41c2-80d7-d0d6987a85fb)



____________

 
Compact Query :

Compact Queries are a way to store GraphQL queries on the server and allow clients to send a query ID instead of sending the full GraphQL query every time.
This reduces payload size, improves caching.





-> First Request : (Storing the Query)

{
  "id": "getBookById",
  "query": "query getBookById($id: String!) { bookById(id: $id) { name pageCount author firstName lastName } }"
}


![image](https://github.com/user-attachments/assets/26aad707-8846-4f39-9113-46b62058ac8a)



___________


The server stores the query and maps it to "getBookById".



-> Persistent HashMap : 

   "getBookById" to "query GetBookDetails(\$id: String!) { getBookById(id: \$id) { name author { firstName lastName } } }"


___________

-> Subsequent Query :


{
  "id": "getBookById",
  "variables": { "id": book-1 }
} 


![image](https://github.com/user-attachments/assets/d6e15662-9389-44c7-becd-2f13a8811ab7)




________________________





Introspection:

GraphQL introspection is a built-in feature that allows clients to discover the API schema dynamically by querying the types, fields, queries, mutations, and subscriptions exposed by the server.



Add this config in src/main/resources/application.properties
GRAPHQL_INTROSPECTION=true


![image](https://github.com/user-attachments/assets/4c11f6bb-79f4-4cd8-80f1-f5a1ddafc779)



_______________




Response Statuses :

GraphQL always returns a 200 OK response, even if there are errors, because of its query execution model.
It’s a Single Request with Multiple Resolvers
GraphQL allows clients to request multiple pieces of data at once.
Different parts of the query may succeed or fail independently.



When your query syntax is invalid or the request is malformed, it responds with 400 status code since the server couldn't even begin processing the query.
If the GraphQL server itself crashes or encounters a catastrophic error that prevents it from processing the request entirely, it responds with a 500 status code.



GraphQL responses always contain an errors field if something goes wrong.
Example response for a partial failure:


![image](https://github.com/user-attachments/assets/e2f64701-a7f5-4d00-ba7e-c402edcbc975)







__________________



GraphQL Injection :



1. Prevent deep recursion attacks by limiting query depth.
2. Restrict overly complex queries to prevent DoS attacks.
3.Enforce RateLimiting
Disable GQL introspection



