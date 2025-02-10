How to Run the API in Postman
This project is a simple Spring Boot API that does not use a database (SQL). Instead, it uses an in-memory static list.

Getting Started
1️⃣ Prerequisites
Ensure you have the following installed:

Java 17+ (Check with java -version)
Maven (Check with mvn -version)
Postman 

git clone https://github.com/your-username/your-repo.git
cd your-repo

Run the Spring Boot Application
mv clean
mvn spring-boot:run

URL: GET http://localhost:8080/api/v2/books
[
    {
        "id": 1,
        "title": "The Hidden Truth",
        "author": "Andrew BlackRoth"
    },
    {
        "id": 2,
        "title": "The Secret of Saving Capital",
        "author": "Diana Johnlapison"
    }
]

URL: GET http://localhost:8080/api/v2/books/{id}
Example: GET http://localhost:8080/api/v2/books/1

{
    "id": 1,
    "title": "The Hidden Truth",
    "author": "Andrew BlackRoth"
}


URL: POST http://localhost:8080/api/v2/addbook
Content-Type: application/json
{
    "id": 123,
    "title": "The Richer",
    "author": "David Diamond"
}
{
    "id": 123,
    "title": "The Richer",
    "author": "David Diamond"
}

URL: Delete http://localhost:8080/api/v2/removebook/{id}
http://localhost:8080/api/v2/removebook/3


URL: Put http://localhost:8080/api/v2/modifybook/{id}
http://localhost:8080/api/v2/modifybook/2
