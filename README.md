# Employee Management Full-Stack Application

The **Employee Management Full-Stack Application** is a modern, feature-rich system for managing employee and department data, built to demonstrate the power of combining traditional enterprise technologies with modern web frameworks. It leverages a responsive React frontend alongside a robust Spring Boot backend, delivering a seamless user experience with features such as CRUD operations, data visualization, authentication, and secure REST APIs. 
<p align="center">
  <a href="https://employee-management-fullstack-app.vercel.app" target="_blank">
    <img src="img/logo.png" alt="Employee Management Full-Stack Application Logo" style="border-radius: 10px" width="35%"/>
  </a>
</p>



### Request Lifecycle

```mermaid
sequenceDiagram
    participant U as User
    participant UI as React Component
    participant C as EmployeeController
    participant S as EmployeeService
    participant R as EmployeeRepository
    participant DB as MySQL
    U->>UI: Trigger "Add Employee"
    UI->>C: POST /api/employees
    C->>S: saveEmployee(employee)
    S->>R: save(employee)
    R->>DB: INSERT row
    DB-->>R: persisted entity
    R-->>S: Employee
    S-->>C: Employee
    C-->>UI: 201 Created + payload
```


> [!IMPORTANT]
> **Note:** The backend API may spin down due to inactivity, so you may need to wait for up to 2 minutes for the API to start up again. Feel free to test the API endpoints and explore the application. Or, you can run the backend locally and connect it to the frontend for a more seamless experience.
**Landing Page:**

<p align="center" style="cursor: pointer">
  <img src="img/landing.png" alt="Landing Page" style="border-radius: 10px" width="100%"/>
</p>

**Dashboard Page:**

<p align="center" style="cursor: pointer">
  <img src="img/dashboard.png" alt="Dashboard Page" style="border-radius: 10px" width="100%"/>
</p>

**Employee List Page:**

<p align="center" style="cursor: pointer">
  <img src="img/employees-page.png" alt="Employee List Page" style="border-radius: 10px" width="100%"/>
</p>

**Department List Page:**

<p align="center" style="cursor: pointer">
  <img src="img/departments-page.png" alt="Department List Page" style="border-radius: 10px" width="100%"/>
</p>

**Profile Page:**

<p align="center" style="cursor: pointer">
  <img src="img/profile.png" alt="Profile Page" style="border-radius: 10px" width="100%"/>
</p>

**Login Page:**

<p align="center" style="cursor: pointer">
  <img src="img/login.png" alt="Login Page" style="border-radius: 10px" width="100%"/>
</p>

**Register Page:**

<p align="center" style="cursor: pointer">
  <img src="img/register.png" alt="Register Page" style="border-radius: 10px" width="100%"/>
</p>

<p align="center">
 And many more features & pages to explore! Feel free to navigate through the application and test the various functionalities.
</p>

## API Endpoints

Here's a table listing all the RESTful API endpoints provided by this application:

| Endpoint                | Method | Description                         |
|-------------------------|--------|-------------------------------------|
| `/api/employees`        | GET    | Get all employees                   |
| `/api/employees/{id}`   | GET    | Get an employee by ID               |
| `/api/employees`        | POST   | Add a new employee                  |
| `/api/employees/{id}`   | PUT    | Update an employee by ID            |
| `/api/employees/{id}`   | DELETE | Delete an employee by ID            |
| `/api/departments`      | GET    | Get all departments                 |
| `/api/departments/{id}` | GET    | Get a department by ID              |
| `/api/departments`      | POST   | Add a new department                |
| `/api/departments/{id}` | PUT    | Update a department by ID           |
| `/api/departments/{id}` | DELETE | Delete a department by ID           |
| `/swagger-ui.html`      | GET    | Access the Swagger UI documentation |

## File Structure

```mermaid
%%{init: {'theme': 'base', 'themeVariables': {
  'background': '#ffffff',
  'primaryColor': '#f5f7ff',
  'primaryBorderColor': '#1E3C72',
  'primaryTextColor': '#0f172a',
  'secondaryColor': '#e0e7ff',
  'tertiaryColor': '#ffffff',
  'textColor': '#ffffff',
  'lineColor': '#1E3C72'
}}}%%
mindmap
  root((Employee-Management))
    ARCHITECTURE.md
    Jenkinsfile
    Makefile
    README.md
    docker-compose.yml
    openapi.yaml
    aws
      README.md
      terraform
        example.tfvars
        providers.tf
        locals.tf
        network.tf
        eks.tf
        rds.tf
        secrets.tf
        ecr.tf
        outputs.tf
        variables.tf
    backend
      Dockerfile
      pom.xml
      config.properties
      example_config.properties
      src
        main
          java/com/example/employeemanagement
            controller
            service
            repository
            model
            security
          resources/application.properties
        test/java/com/example/employeemanagement
    frontend
      Dockerfile
      package.json
      src/components
      src/services
    kubernetes
      backend-deployment.yaml
      backend-service.yaml
      configmap.yaml
      frontend-deployment.yaml
    terraform
      main.tf
      modules
        network
        eks
        rds
        ecr
      variables.tf
    scripts
      build-images.sh
      deploy-k8s.sh
      ...
    nginx
      Dockerfile
      nginx.conf
    img/*.png
    package.json
```

> [!TIP]
> Note: Generated directories such as `node_modules/`, `target/`, and `build/` are omitted for brevity.

## Architecture Reference

For a deeper dive into components, data flow, security posture, and recommended follow-up tasks, see [ARCHITECTURE.md](ARCHITECTURE.md). It cross-references the exact source files (controllers, services, repositories, configuration, tests, and infrastructure) described in this README.

