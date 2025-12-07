# Spring Boot Demo Application - A Course for 2nd Year CS Students

Welcome to the Spring Demo project! This project is designed to introduce you to modern software development practices using Java, Spring Boot, Docker, and GitHub Actions. Think of this as a mini-course to get you familiar with tools and concepts used in the industry.

## 1. Introduction: What is this project?

This is a simple "Hello, World" web application built using the Spring Boot framework. While it's a basic example, it serves as a foundation to understand several key concepts:

- **Backend Development:** How to create a web server that can respond to requests.
- **Dependency Management:** How to manage project libraries using Maven.
- **Containerization:** How to package an application into a portable Docker container.
- **CI/CD:** How to automate the building, testing, and deployment of your application.

## 2. What is Spring Boot?

In Java, building web applications from scratch can be complex. You need to configure a web server, manage libraries (dependencies), and write a lot of boilerplate code.

**Spring Boot** is a popular framework that makes it incredibly easy to create stand-alone, production-grade Spring-based Applications that you can "just run". It simplifies the setup process by:

- Providing sensible default configurations.
- Including an embedded web server (like Tomcat) so you don't have to install one separately.
- Making it easy to manage dependencies with "starters".

Essentially, Spring Boot lets you focus more on writing the code that matters for your application's features.

## 3. Prerequisites

Before you begin, make sure you have the following software installed on your computer:

- **Java Development Kit (JDK):** Version 11 or higher.
- **Docker:** The platform for building and running containers.
- **An IDE (Optional but Recommended):** IntelliJ IDEA Community/Ultimate or Visual Studio Code with Java extensions.

## 4. Running the Application Locally

This project uses the **Maven Wrapper** (`mvnw` or `mvnw.cmd`). This is a small script included in the project that automatically downloads the correct version of Maven (our build tool) and runs it. This means you don't need to install Maven yourself!

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd spring-demo
    ```

2.  **Run the application:**
    - On macOS/Linux:
      ```bash
      ./mvnw spring-boot:run
      ```
    - On Windows:
      ```bash
      .\mvnw.cmd spring-boot:run
      ```

You should see a lot of output, and near the end, you'll see a line like `Tomcat started on port(s): 8080 (http)`. This means your server is running!

3.  **Verify it's working:**
    Open your web browser and go to `http://localhost:8080`. You should see a response from your application (e.g., "Hello, World!").

## 5. Containerization with Docker

### What is Docker?

Imagine you build an application on your machine. It works perfectly. But when your friend tries to run it, it fails because they have a different operating system, a different Java version, or a missing library. This is the "it works on my machine" problem.

**Docker** solves this by allowing you to package your application, along with all its dependencies (like the JDK and libraries), into a single, isolated unit called a **container**. This container can run on any machine that has Docker installed, guaranteeing consistency.

### Building the Docker Image

A `Dockerfile` is a recipe for creating a Docker image. Our project has one. To build the image:

```bash
# The -t flag "tags" the image with a name (e.g., myapp/demo)
docker build -t myapp/demo .
```

### Running the Docker Container

Once the image is built, you can run it as a container:

```bash
# -p 8080:8080 maps port 8080 on your machine to port 8080 inside the container
docker run -p 8080:8080 myapp/demo
```

Now, if you visit `http://localhost:8080` in your browser, you are talking to the application running inside the Docker container!

## 6. Continuous Integration & Continuous Deployment (CI/CD)

### What is CI/CD?

CI/CD is a practice that automates the software development lifecycle.

- **Continuous Integration (CI):** Automatically building and testing your code every time a developer pushes a change to a shared repository (like GitHub). This helps catch bugs early.
- **Continuous Deployment (CD):** Automatically deploying the application to a server after it passes the CI stage.

### Our CI/CD Pipeline

This project uses **GitHub Actions** for CI/CD. The configuration is in the file `.github/workflows/build-and-deploy.yml`. Let's break down what it does every time you `push` code to the `main` branch:

1.  **`runs-on: self-hosted`**: This tells GitHub to run the job on a specific server (runner) that we have set up, instead of one provided by GitHub.

2.  **`actions/checkout@v3`**: This step checks out your source code onto the runner.

3.  **`Login to Registry`**: This logs into a **Docker Registry** (in this case, one named Harbor running on `localhost:6081`). A registry is a storage system for your Docker images.

4.  **`Build Docker image`**: This step runs the `docker build` command, just like you did locally. It tags the image with a unique identifier (`github.sha` - the commit hash) and also with `latest`.

5.  **`Push to Registry`**: The newly built Docker images are pushed to the Harbor registry. Now, your images are stored and versioned.

6.  **`Deploy`**: This is a placeholder step. In a real-world scenario, this step would contain a script to pull the new `latest` image from the registry onto a production server and run it, updating the live application.

## 7. Next Steps

Congratulations! You've gone through the fundamentals of a modern Java application workflow. Here are some things you could try next:

- **Create a new endpoint:** Modify the Java code to handle another URL (e.g., `/greeting`).
- **Add a test:** Write a simple unit test for your code.
- **Explore the `pom.xml`:** This file is the heart of a Maven project. See how dependencies are declared.
- **Learn more about Docker commands:** Try `docker ps`, `docker images`, `docker stop`.

Happy coding!