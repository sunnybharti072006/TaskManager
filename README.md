# 🚀 TaskManager Full-Stack Application

<div align="center">
<img width="1280" height="640" alt="image" src="https://github.com/user-attachments/assets/d540ccff-6a08-4403-85e4-51c2a16ff531" />

</div>

## 📖 Overview

The TaskManager is a comprehensive full-stack application designed to streamline personal and team task organization. It provides a user-friendly interface for managing tasks, tracking progress, and enhancing productivity. The application is built with a clear separation of concerns, featuring a powerful Java-based backend API and a modern web frontend.

This repository contains the complete codebase for both the backend service and the frontend application, enabling developers to easily set up, develop, and deploy a robust task management solution.

## ✨ Features

-   🎯 **Task Creation & Management:** Create, read, update, and delete tasks with ease.
-   📝 **Task Details:** Add descriptions, due dates, and other relevant information to tasks.
-   🚦 **Task Status Tracking:** Update task status (e.g., To Do, In Progress, Done) to monitor progress.
-   🔐 **User Authentication:** Secure user registration and login functionality for personalized task lists.
-   🌐 **RESTful API:** A well-structured backend API providing all necessary endpoints for task and user management.
-   📦 **Modular Project Structure:** Clear separation between frontend and backend components for maintainability and scalability.
-   🧪 **API Testing with Postman:** Includes a Postman collection for convenient testing and exploration of backend endpoints.


## 🛠️ Tech Stack

**Frontend:**
-   ![JavaScript](https://img.shields.io/badge/JavaScript-ES6+-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
-   ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
-   ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
- 

**Backend:**
-   ![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
-   ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
-   ![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

**Database:**
-   ![SQL](https://img.shields.io/badge/SQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) <!-- TODO: Specify actual database (e.g., PostgreSQL, MySQL, H2) based on 'application.properties' or Spring config -->

**Tools:**
-   ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) for API testing.
-   ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white) for development.

## 🚀 Quick Start

Follow these steps to get the TaskManager application up and running on your local machine.

### Prerequisites

Ensure you have the following installed:

-   **Java Development Kit (JDK)**: Version 17 or higher (recommended).
-   **Apache Maven**: Version 3.8.x or higher.
-   **Node.js**: Version 18.x or higher.
-   **npm** or **Yarn**: For frontend dependency management.
-   **A SQL Database**: Such as PostgreSQL, MySQL, or an embedded database like H2 for development. <!-- TODO: Specify recommended database based on Spring configuration -->

### Installation

1.  **Clone the repository**
    ```bash
    git clone https://github.com/sunnybharti072006/TaskManager.git
    cd TaskManager
    ```

2.  **Backend Setup**

    Navigate to the project root and build the Java backend:
    ```bash
    cd TaskManager
    mvn clean install
    ```

3.  **Database Configuration**

    The backend requires a database connection. Create an `application.properties` or `application.yml` file in `src/main/resources` (if not already present) and configure your database.

    **Example `src/main/resources/application.properties` (for H2 in-memory development database):**
    ```properties
    spring.datasource.url=jdbc:h2:mem:taskdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.h2.console.enabled=true
    spring.jpa.hibernate.ddl-auto=update # Use 'create' or 'create-drop' for fresh schemas, 'update' for existing
    ```

    **Example `src/main/resources/application.properties` (for PostgreSQL):**
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanagerdb
    spring.datasource.username=your_db_user
    spring.datasource.password=your_db_password
    spring.jpa.hibernate.ddl-auto=update # Consider 'validate' or 'none' for production
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```
    **TODO:** Add more specific database setup instructions or migration commands if detected in the backend code.

4.  **Frontend Setup**

    Navigate into the `frontend` directory, install dependencies, and start the development server.
    ```bash
    cd frontend
    npm install # or yarn install or pnpm install
    npm run dev # or npm start, or yarn dev/start
    ```
    The frontend application will typically run on `http://localhost:3000` (or another port depending on its configuration).

5.  **Start Backend Server**

    From the project root (where `pom.xml` is located), run the Spring Boot application:
    ```bash
    cd TaskManager
    mvn spring-boot:run
    ```
    The backend API will start on `http://localhost:8080` by default.

6.  **Open your browser**
    Visit `http://localhost:[detected frontend port, e.g., 3000]` to access the application.

## 📁 Project Structure

```
TaskManager/
├── .idea/                 # IntelliJ IDEA project files
├── frontend/              # Frontend application source code
│   ├── public/            # Static assets
│   ├── src/               # Frontend source (components, pages, styles, etc.)
│   ├── package.json       # Frontend dependencies and scripts
│   └── ...
├── src/                   # Backend Java source code
│   ├── main/
│   │   ├── java/            # Java application code (controllers, services, entities, etc.)
│   │   │   └── com/sunnybharti/taskmanager/ # Base package
│   │   └── resources/       # Application configuration, static assets, templates
│   │       └── application.properties # Spring Boot configuration
│   └── test/              # Java test code
├── target/                # Maven build output directory
├── pom.xml                # Maven build configuration for the backend
├── postman_collection.json # Postman collection for API testing
└── README.md              # Project README file
```

## ⚙️ Configuration

### Backend Environment Variables / `application.properties`

The backend application's configuration is primarily managed through `src/main/resources/application.properties` (or `application.yml`). Key properties include:

| Property                   | Description                                    | Default         | Required |
| :------------------------- | :--------------------------------------------- | :-------------- | :------- |
| `server.port`              | Port for the backend API server.               | `8080`          | No       |
| `spring.datasource.url`    | JDBC URL for the database connection.          | (Varies by DB)  | Yes      |
| `spring.datasource.username` | Database username.                           | `sa` (for H2)   | Yes      |
| `spring.datasource.password` | Database password.                           | (Empty for H2)  | Yes      |
| `spring.jpa.hibernate.ddl-auto` | Hibernate DDL generation strategy (`none`, `update`, `create`). | `update`        | No       |

### Frontend Environment Variables

The frontend application (if using a framework like React, Vue, or Angular) may use `.env` files for environment-specific variables.
**TODO:** Add specific frontend environment variables (e.g., `REACT_APP_API_URL`) if `frontend`'s `package.json` suggests a framework and corresponding `.env` usage.

## 🔧 Development

### Backend

-   **Build & Package**: `mvn clean install`
-   **Run Development Server**: `mvn spring-boot:run`
-   **Generate Site (Reports)**: `mvn site` (if Maven site plugin is configured)

### Frontend

**TODO:** Add frontend specific development commands based on `frontend/package.json` scripts.
Example:
| Command        | Description                                       |
| :------------- | :------------------------------------------------ |
| `npm install`  | Installs all project dependencies.                |
| `npm run dev`  | Starts the development server (with hot-reloading). |
| `npm run build` | Builds the application for production.            |

## 🧪 Testing

### Backend API Testing

A Postman collection (`postman_collection.json`) is included in the root directory. You can import this into Postman to test the backend API endpoints.

**To run API tests:**
1.  Ensure the backend server is running (`mvn spring-boot:run`).
2.  Open Postman.
3.  Import `postman_collection.json`.
4.  Execute requests defined in the collection.

**TODO:** If JUnit tests are found in `src/test/java`, add instructions for running them:
```bash
# Run all backend tests
mvn test
```

### Frontend Testing

**TODO:** If Jest/Cypress/Vitest/etc. tests are found in `frontend/src`, add instructions for running them:
```bash
cd frontend
# Run frontend unit/integration tests
npm test # or yarn test
```

## 🚀 Deployment

### Backend Production Build

To create an executable JAR file for the backend:
```bash
mvn clean install
```
The runnable JAR will be located in `target/taskmanager-[version].jar`.

### Deployment Options

-   **JAR Deployment**: The generated JAR can be run on any server with a JVM:
    ```bash
    java -jar target/taskmanager-[version].jar
    ```
-   **Docker**: <!-- TODO: If a Dockerfile is present, add Docker instructions -->
-   **Cloud Platforms**: (e.g., AWS EC2, Google Cloud Run, Heroku, Azure App Service)
    The JAR file can be deployed to various cloud providers that support Java applications.

### Frontend Production Build

To build the frontend for production:
```bash
cd frontend
npm run build # or yarn build
```
This will create a `build` or `dist` directory (depending on the framework) containing static assets ready for deployment.

### Frontend Deployment Options
-   **Static Hosting**: The `build` or `dist` directory can be deployed to static hosting services like Netlify, Vercel, GitHub Pages, or any web server.
-   **Bundled with Backend**: The frontend build output can also be served by the Spring Boot application by placing it in `src/main/resources/static`.

## 📚 API Reference

The backend exposes a RESTful API for managing tasks and users.

### Base URL
`http://localhost:8080/api` (or your configured backend URL)

### Authentication

Users can register and log in to obtain JWT tokens. This token must be included in the `Authorization` header for protected endpoints.

-   **`POST /api/auth/register`**: Register a new user.
    -   Body: `{ "username": "...", "password": "..." }`
-   **`POST /api/auth/login`**: Authenticate a user and receive a JWT.
    -   Body: `{ "username": "...", "password": "..." }`
    -   Response: `{ "token": "..." }`

### Endpoints

| Method | Endpoint         | Description                                     | Authentication |
| :----- | :--------------- | :---------------------------------------------- | :------------- |
| `GET`  | `/api/tasks`     | Retrieve all tasks for the authenticated user.  | Required       |
| `POST` | `/api/tasks`     | Create a new task.                              | Required       |
| `GET`  | `/api/tasks/{id}`| Retrieve a specific task by ID.                 | Required       |
| `PUT`  | `/api/tasks/{id}`| Update an existing task by ID.                  | Required       |
| `DELETE`| `/api/tasks/{id}`| Delete a task by ID.                           | Required       |

**Note:** For detailed request/response schemas, refer to the `postman_collection.json`.

## 🤝 Contributing

We welcome contributions to the TaskManager project! Please follow these steps to contribute:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/your-feature-name`).
3.  Make your changes and ensure tests pass.
4.  Commit your changes (`git commit -m 'feat: Add new feature'`).
5.  Push to the branch (`git push origin feature/your-feature-name`).
6.  Open a Pull Request.

### Development Setup for Contributors

Follow the **Quick Start** instructions to set up the development environment. Ensure all tests pass before submitting a pull request.

## 📄 License

This project is licensed under the [MIT License](LICENSE) - see the LICENSE file for details. <!-- TODO: Verify actual license file exists and update if necessary -->

## 🙏 Acknowledgments

-   **Spring Boot**: For building robust and scalable Java applications.
-   **Apache Maven**: For powerful project build automation.
-   **H2 Database**: For an easy-to-use in-memory database during development.
-   **Postman**: For simplifying API development and testing.
-   **[Frontend Framework Community]**: For providing a modern frontend development experience. <!-- TODO: Specify actual frontend framework community if detected -->

## 📞 Support & Contact

-   🐛 **Issues**: For bug reports and feature requests, please use [GitHub Issues](https://github.com/sunnybharti072006/TaskManager/issues).
-   📧 **Email**: [sunnybharti072006@example.com] <!-- TODO: Add actual contact email for the author -->
-   👤 **Author**: [Sunny Bharti](https://github.com/sunnybharti072006)

---

<div align="center">

**⭐ Star this repo if you find it helpful!**

Made with ❤️ by [Sunny Bharti](https://github.com/sunnybharti072006)

</div>
