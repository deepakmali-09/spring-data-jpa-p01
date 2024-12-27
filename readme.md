# Spring Data JPA Project - Student Management System  

This project demonstrates the use of **Spring Data JPA** for database operations in a **Student Management System**. It leverages the power of **JpaRepository** to perform all standard CRUD (Create, Read, Update, Delete) operations efficiently.  

The system manages student data with the following fields:  
- **id**: Unique identifier for the student.  
- **name**: Name of the student.  
- **age**: Age of the student.  
- **email**: Email address of the student.  

## **Features**  
1. Add a new student to the database.  
2. Retrieve all students or fetch a specific student by ID.  
3. Update student information based on their ID.  
4. Delete student records by ID.  

## **Technologies Used**  
- **Spring Boot** for application development.  
- **Spring Data JPA** for ORM and database interactions.  
- **MySQL** as the database (configurable in `application.properties`).  
- **Java** for backend logic. 

## **Endpoints**
**POST /api/std/save**

Description: Adds a new student to the database.
Request Body:
json
{  
    "name": "Ravi Kumar",  
    "age": 20,  
    "email": "ravikumar@example.com"  
}  
Response: The created student object.

**GET /api/std/all**

Description: Retrieves all students in the database.
Response: A list of all student objects.
json
[  
    { "id": 1, "name": "Ravi Kumar", "age": 20, "email": "ravikumar@example.com" },  
    { "id": 2, "name": "Priya Sharma", "age": 22, "email": "priyasharma@example.com" }  
]  

**GET /api/std/{id}**

Description: Retrieves a specific student by their ID.
Path Variable: id - The ID of the student to retrieve.
Response: The student object with the specified ID.
json
{ "id": 1, "name": "Ravi Kumar", "age": 20, "email": "ravikumar@example.com" }  

**GET /api/std**

Description: Retrieves a specific student by their ID using a query parameter.
Request Param: id - The ID of the student to retrieve.
Response: The student object with the specified ID.
json
{ "id": 1, "name": "Ravi Kumar", "age": 20, "email": "ravikumar@example.com" }  

**PUT /api/std/{id}**

Description: Updates an existing student by ID.
Path Variable: id - The ID of the student to update.
Request Body:
json
{  
    "name": "Ravi Updated",  
    "age": 21,  
    "email": "raviupdated@example.com"  
}  
Response: The updated student object.

**DELETE /api/std/{id}**

Description: Deletes a student by their ID.
Path Variable: id - The ID of the student to delete.
Response: The deleted student object (optional).

**PATCH /api/std/{id}**

Description: Partially updates a student by ID.
Path Variable: id - The ID of the student to partially update.
Request Body: The student fields to update (e.g., name, age, email).
Response: The updated student object.

## **How to Run**  
1. Clone the repository and navigate to the project directory.  
2. Build and run the application using Maven:  
   ```bash  
3. git clone https://github.com/deepakmali-09/spring-data-jpa-p01.git

4. mvn spring-boot:run  
