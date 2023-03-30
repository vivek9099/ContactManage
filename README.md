# ContactManage
RestAPI for contact management using Springboot
This is a RESTful API built using Spring Boot that allows users to manage contacts.
It provides endpoints to create, read, update, and delete contacts.
The API also allows searching for contacts based on their first name, last name, or email. 
The API is secure and requires authentication for accessing the endpoints.

Technologies Used
Spring Boot
Spring Security
Spring Data JPA
H2 Database
Maven
OpenAPI
Getting Started
To get started with the API, follow these steps:
Clone this repository:
sh
Copy code
git clone https://github.com/<username>/contacts-api.git
Navigate to the project directory:
sh
Copy code
cd contacts-api
Build the project using maven:
sh
Copy code
mvn clean install
Run the project:
sh
Copy code
mvn spring-boot:run
The API will be available at:
sh
Copy code
http://localhost:8080/api/contacts/
Endpoints
The API provides the following endpoints for managing contacts:

Create a contact
http
Copy code
POST /api/v1/contacts
Request Body:

json
Copy code
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1-202-555-0123"
}
Response:

json
Copy code
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1-202-555-0123"
}
Read all contacts
http
Copy code
GET /api/contacts
Response:

json
Copy code
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "+1-202-555-0123"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com",
    "phoneNumber": "+1-202-555-4567"
  }
]
Read a contact by id
http
Copy code
GET /api/contacts/{id}
Response:

json
Copy code
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1-202-555-0123"
}
Update a contact
http
Copy code
PUT /api/contacts/{id}
Request Body:

json
Copy code
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1-202-555-0123"
}
Response:

json
Copy code
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1-202-555-0123"
}
Delete a contact
http
Copy code
DELETE /api/contacts/{id}
Response:

http
Copy code
204 No Content
Search contacts
http
Copy code
GET /api/contacts/search?firstName=John&lastName=Doe&email=john.doe@example.com
Response:

json
Copy code
[
  {
    "id": 1,
    "



