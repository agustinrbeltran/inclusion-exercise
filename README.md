# Spring Boot Application README

This README file provides instructions on how to execute the Spring Boot application and consume its endpoints. The application contains a single controller named `RemainderController` and a corresponding DTO class named `RemainderParamsDTO`.

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) version 17 or later
- Postman application (Download and install from https://www.postman.com/downloads/)

## Running the Application

To run the Spring Boot application, follow these steps:

1. Clone the repository containing the application source code.
2. Open a terminal or command prompt and navigate to the project's root directory.
3. Build the application using the following command:

   ```shell
   ./gradlew clean build
   ```

4. After the build is successful, start the application by executing the following command:

   ```shell
   ./gradlew bootRun
   ```

   This command will start the Spring Boot embedded Tomcat server, and the application will be accessible at `http://localhost:8080`.

## Using the Postman Collection

The Postman collection named `Inclusion.postman_collection.json` is located in the root folder. This collection contains pre-configured requests to interact with the application's endpoints.

To use the Postman collection, follow these steps:

1. Open the Postman application.
2. Click on the **Import** button in the top-left corner.
3. In the **Import File** tab, select the `Inclusion.postman_collection.json` file from the project's root folder.
4. Click the **Open** button to import the collection into Postman.
5. The imported collection will appear in the left sidebar of the Postman application.
6. Expand the collection to see the available requests.
7. Click on a request to open it and modify any necessary parameters (e.g., request body, path variables).
8. Click the **Send** button to execute the request against the running Spring Boot application.
9. The response will be displayed in the Postman application.

You can execute the provided requests in the Postman collection to interact with the application's endpoints conveniently.

## Endpoints

The application provides the following endpoints that can be consumed:

### Create Remainders [POST]

- **Endpoint:** `/remainder`
- **Method:** `POST`
- **Request Body:** JSON array of `RemainderParamsDTO` objects
- **Response:** JSON array of `RemainderParamsDTO` objects

This endpoint allows you to create multiple remainders by providing a list of `RemainderParamsDTO` objects in the request body. The created remainders will be returned in the response.

### Get Remainder by ID [GET]

- **Endpoint:** `/remainder/{id}`
- **Method:** `GET`
- **Path Variable:** `id` (integer)
- **Response:** JSON representation of `RemainderParamsDTO` object

This endpoint retrieves a specific remainder by its ID. The ID should be provided as a path variable. If the remainder with the given ID is found, it will be returned in the response. Otherwise, a `404 Not Found` error will be returned.

## Example Usage

Here are some examples of how you can consume the application's endpoints using a tool like cURL or a REST client:

1. Creating Remainders:

   ```http
   POST /remainder HTTP/1.1
   Host: localhost:8080
   Content-Type: application/json

   [
     {
         "x": 7,
         "y": 5,
         "n": 12345,
     },
     {
         "x": 10,
         "y": 5,
         "n": 15,
     }
   ]
   ```

2. Getting Remainder by ID:

   ```http
   GET /remainder/1 HTTP/1.1
   Host: localhost:8080
   ```

   If the remainder with ID `1` exists, the response will contain the corresponding `RemainderParamsDTO` object.

## Error Handling

The application handles the scenario where a remainder with a given ID is not found by throwing a `RemainderNotFoundException` and returning a `404 Not Found` response.

## Conclusion

You have now learned how to execute the Spring Boot application and consume its endpoints. Feel free to explore and modify the application to suit your needs. If you have any further questions, please refer to the application's documentation or seek assistance from the project maintainers.
