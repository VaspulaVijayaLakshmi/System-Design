An access token :  is utilized by the Client to access the Resource Owner’s data. 
The Authorization Server issues the access token to the Client after proper authentication and authorization. 
The Client uses the access token to request the Resource Server.




A refresh token:  replaces the previous access token when it expires without requiring the Resource Owner to re-authenticate.
The refresh token is usually issued along with the access token and employed when the access token becomes invalid.



Thats the reason - in insmnia we need to keep replacing Bearer token
Web Browser requests  we dont need to use Bearer token  because, it is replaced by refresh tojen.
