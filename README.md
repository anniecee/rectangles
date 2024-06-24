
# Rectangle CRUD Application

## Description

This project involves creating a simple CRUD (Create, Read, Update, Delete) application for managing rectangles using the Java Spring framework. The application allows users to add, view, edit, and delete rectangles from a database.

## Technical Requirements

### Database

The application uses a database table called `Rectangle` to store information about rectangles. The table has the following attributes:

-   `name`: The name of the rectangle
-   `width`: The width of the rectangle
-   `height`: The height of the rectangle
-   `color`: The color of the rectangle in hexadecimal format

You may add other attributes to the `Rectangle` table as needed.


### Application Features

1.  **Add New Rectangles**: Users can add new rectangles with their attributes.
2.  **Delete Rectangles**: Users can delete any rectangle.
3.  **Display Rectangles**: The main page displays all rectangles currently in the database. Clicking on a rectangle's name navigates to a detailed page showing full information about the rectangle.
4.  **Edit Rectangle Attributes**: The detailed display page allows users to edit certain rectangle attributes.

## Workflow

### UI Mockup

Creating a UI mockup is recommended as a starting point to visualize the application's structure and user interactions. The mockup should include views/templates (pages) and their links.

#### Example UI Mockup:

1.  **Main Page**:
    
    -   Displays a list of rectangles with basic attributes (name, color).
    -   Includes a button to add a new rectangle.
    -   Each rectangle name is a link to the detailed view.
2.  **Detailed Page**:
    
    -   Displays full information about a rectangle (name, width, height, color, etc.).
    -   Allows editing of rectangle attributes.
    -   Includes a button to delete the rectangle.
3.  **Add Rectangle Page**:
    
    -   Form to input attributes for a new rectangle (name, width, height, color, etc.).
4.  **Edit Rectangle Page**:
    
    -   Form to edit attributes of an existing rectangle.

## Project Setup and Installation

1.  **Clone the Repository**:
     
    `git clone <repository-url>
    cd rectangle-crud-application` 
    
2.  **Set Up Database**:
    
    -   Create a database named `rectangle_db`.
    -   Configure database connection in `src/main/resources/application.properties`.
3.  **Run the Application**:
    
    `./mvnw spring-boot:run` 
    
4.  **Access the Application**:
    
    -   Open a web browser and navigate to `http://localhost:8080`.

## Technologies Used

-   Java Spring Framework
-   Spring Boot
-   Spring Data JPA
-   Thymeleaf (for templates)
-   H2 Database (or another database of your choice)
-   HTML/CSS

## Demo
![Demo rectangles](https://s6.ezgif.com/tmp/ezgif-6-a1d5e78273.gif)
