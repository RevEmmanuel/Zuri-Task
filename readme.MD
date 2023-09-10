# Person Resource
This ia a Java Spring boot server application to handle CRUD operations for a Person resource.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Clone the Repository](#clone-the-repository)
    - [Database Configuration](#configure-the-database)
    - [Build and Run](#build-and-run-the-application)
- [Schemas and Diagrams](#erd-and-uml-diagrams)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)


### Features
* `Create Person`
* `Find person by name`
* `Find all persons`
* `Update person details`
* `Delete person`

### Technologies used:
* `Java`
* `Springboot`
* `PostgreSQL`
* `Swagger Docs`
* `JUnit`
* `Mockito`

### Prerequisites:
* `Java 8 or higher`
* `Maven`
* `PostgreSQL Database`
* `Port ${SERVER_PORT} open and free`

[![My Skills](https://skillicons.dev/icons?i=java,spring,mysql,postgresql,postman)](https://skillicons.dev)

# Getting Started
### Clone the Repository
```
git clone https://github.com/RevEmmanuel/Zuri-Task.git 
```

### Configure the database
Create a PostgreSQL database and update the database configuration in the `application-{profile}.properties` file. The default active profile is "dev"
```properties
SERVER_PORT=
db.host=
db.name=
db.username=
db.password=
db.port=
```

### Build and Run the Application
Navigate to the project directory and build the application using Maven:
```
cd url-shortener
mvn clean install
```
Run the application using Maven:
```
mvn spring-boot:run
```
The application will start running on `http://localhost:${SERVER_PORT}`.

## ERD and UML Diagrams
* [ERD Diagram](https://drive.google.com/file/d/1QzqS-Y3_q8tqU1gL8XMDUuH6isIo9Jyh/view?usp=sharing)
* [UML Diagram](https://drive.google.com/file/d/1T0UnHiEcgQoI18j2kNXrg1GkciuOIt57/view?usp=sharing)

## Api Endpoints
In this section, you'll find examples of how to interact with the API endpoints to perform various CRUD operations on person entities.
* ### Create a new Person
    To create a new person entity, send a `POST` request to the `/api` endpoint with the following JSON request body:
```json
{
  "name": "John Doe"
}
```
Example Response:
```json
{
    "id": 1,
    "name": "John Doe"
}
```

* ### Retrieve a peron by name
  To retrieve a person by name, send a `GET` request to the `/api` endpoint with the `name` in the request parameters.
Example Response:
```json
{
    "id": 1,
    "name": "John Doe"
}
```

* ### Retrieve all persons
  To retrieve all persons, send a `GET` request to the `/api/all` endpoint.

Example Response:
```json
[
  {
    "id": 1,
    "name": "John Doe"
  },
  {
    "id": 2,
    "name": "Jane Smith"
  }
]
```

* ### Update an existing Person
  To update a person's details by name, send a `PUT` request to the `/api` endpoint with a JSON request body containing the id and the updated details.

Example Response:
```json
{
  "id": 1,
  "name": "John Doe Jr."
}
```

* ### Delete a Person
  To delete a person by name, send a `DELETE` request to the `/api` endpoint with the id in the request body.
Example Response:
```text
SUCCESSFUL
```

## Testing
You can run automated tests for the API using the provided test scripts. Make sure you have followed the [Getting Started](#getting-started) steps before running the tests.
```
mvn test
```

## Documentation
The API documentation is available through Swagger UI. You can access it using the following link:
* [Swagger Docs](https://zuri-task-production.up.railway.app/swagger-ui.html)
* [Postman Documentation](https://documenter.getpostman.com/view/24879226/2s9YC1XF51)
* [Landing Page](https://zuri-task-production.up.railway.app/api/info)

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these guidelines:

* Fork the repository
* Create a new branch for your feature or bug fix
* Make your changes and submit a pull request
* Provide a clear description of your changes

## Developer & Engineer
Adeola Adekunle
* [GitHub (RevEmmanuel)](https://github.com/RevEmmanuel)
* [Twitter (@Adeola_Ade1)](https://twitter.com/Adeola_Ade1)
* [Instagram (@deolaaxo)](https://www.instagram.com/deolaaxo/)
* [LinkedIn (Adeola Adekunle)](https://www.linkedin.com/in/adeola-adekunle-emmanuel/)
* [Email(Adeola Adekunle)](mailto:adeolaae1@gmail.com)

## License
This project is licensed under the [MIT license](https://opensource.org/license/mit/)
