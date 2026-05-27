# Employee Management System

A sleek, lightweight microservices-based application built with **Spring Boot** and **Vanilla HTML/CSS/JS**. It provides a clean, glassmorphic UI to manage employees, track attendance, and dynamically generate payslips.

## 🚀 Architecture

The application is split into three independent Spring Boot microservices:

1. **Employee Service** (`localhost:8081`)
   - Manages employee records (ID, Name, Salary per day).
   - Exposes REST APIs for adding and fetching employees.

2. **Attendance Service** (`localhost:8082`)
   - Tracks how many days an employee was present.
   - Exposes REST APIs for adding and fetching attendance records.

3. **Payslip Service** (`localhost:8083`)
   - The main frontend and API gateway.
   - Communicates with both the Employee and Attendance services to dynamically calculate total salary and generate a payslip.

## 💻 Tech Stack

- **Backend**: Java 21, Spring Boot 3.5, Spring Web
- **Frontend**: HTML5, Vanilla JavaScript, CSS3
- **Build Tool**: Maven
- **Design System**: Custom CSS Glassmorphism
- **Data Storage**: In-Memory (Java Collections)

## 🛠️ How to Run

1. Open a terminal in each of the three service directories (`employee-service`, `attendance-service`, and `payslip-service`).
2. Run the following command in each terminal to start the Spring Boot applications:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Once all three services are running, open your web browser and navigate to:
   **http://localhost:8083/**

## ✨ Features
- **Glassmorphic UI**: Beautiful, modern styling across all pages.
- **In-Memory Storage**: Uses Java HashMaps for instant, zero-setup data storage.
- **REST APIs**: Clean backend endpoints utilizing JSON payloads.
- **Microservices Communication**: Services securely talk to each other using Spring's `RestTemplate`.
