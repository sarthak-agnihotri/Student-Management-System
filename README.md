# 🎓 Student Management System

[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

A **production-ready, containerized full-stack application** for managing students, exams, marks, and generating report cards. Built with **Spring Boot**, **MySQL**, **Docker**, and **Maven**.

> 🚀 **One command to run:** `docker-compose up --build`

---

## ✨ Features

### 📚 Student Management
- ✅ Add, Edit, Delete students
- ✅ Roll number and Class fields
- ✅ Parent details (Father, Mother, Parent Phone)
- ✅ Search by name, roll number, email, course
- ✅ Pagination (5/10/20/50 per page)
- ✅ Student status badges (Active🟢 / Inactive🔴 / Graduated🟠)
- ✅ Real-time student count by status
- ✅ Profile modal with complete details
- ✅ Sort by any column (ID, Name, Age, Status, etc.)

### 📝 Marks & Exams
- ✅ Add/Manage exams (with date, semester, academic year)
- ✅ Add subject-wise marks
- ✅ Automatic grade calculation (A+, A, B+, B, C+, C, F)
- ✅ View all marks with student and exam names

### 📊 Results
- ✅ Generate report cards for any exam
- ✅ Show all subjects with marks and grades
- ✅ Calculate total marks, percentage, overall grade
- ✅ Print report card
- ✅ Download report card as PDF

### 📥 Export Features
- ✅ Download student list as CSV
- ✅ Export student list as PDF
- ✅ Batch print student ID cards
- ✅ Print any page

### 🎨 UI Features
- ✅ Dark mode toggle (saves preference in localStorage)
- ✅ Responsive design (works on mobile, tablet, desktop)
- ✅ Real-time search filtering
- ✅ Beautiful gradient UI with smooth animations

---

## 🛠️ Tech Stack

| Category | Technology | Version |
|----------|------------|---------|
| **Backend** | Spring Boot | 2.7.0 |
| **Frontend** | HTML5, CSS3, JavaScript | - |
| **Database** | MySQL | 5.7 |
| **Build Tool** | Apache Maven | 3.8.4 |
| **Containerization** | Docker | Latest |
| **Orchestration** | Docker Compose | Latest |
| **Java** | OpenJDK | 11 |

---
## 🐳 Docker Architecture

```mermaid
flowchart TB
    subgraph Host [💻 User Computer]
        Browser[🌐 Web Browser<br/>localhost:3000]
    end

    subgraph Docker [🐳 Docker Compose]
        
        subgraph FrontendService [Frontend Service]
            Frontend[🖥️ Nginx Container<br/>Port: 3000]
        end

        subgraph BackendService [Backend Service]
            Backend[⚙️ Spring Boot Container<br/>Port: 8080]
        end

        subgraph DatabaseService [Database Service]
            MySQL[🗄️ MySQL Container<br/>Port: 3306]
            Volume[💾 Docker Volume<br/>mysql-data]
        end

    end

    Browser -->|1. Opens URL| Frontend
    Frontend -->|2. API Request| Backend
    Backend -->|3. SQL Query| MySQL
    MySQL -->|4. Read/Write| Volume
    MySQL -->|5. Return Data| Backend
    Backend -->|6. JSON Response| Frontend
    Frontend -->|7. Display Page| Browser
```
---
## 🚀 Quick Start

### Prerequisites

| Requirement | Download Link |
|-------------|---------------|
| Docker Desktop | [Download](https://www.docker.com/products/docker-desktop/) |
| Git (optional) | [Download](https://git-scm.com/) |

### Run the Project

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/StudentManagementSystem.git
cd StudentManagementSystem

# Build and run with Docker Compose
docker-compose up --build

⏱️ First time setup takes 2-3 minutes (downloading Docker images and dependencies)

Access the Application
Service	URL	Credentials
Frontend UI	http://localhost:3000	-
Backend API	http://localhost:8080/api/students	-
PHPMyAdmin	http://localhost:8081	root / root123
Stop the Application
bash
# Stop all containers
docker-compose down

# Stop and delete volumes (reset database)
docker-compose down -v
Built with ☕ using Spring Boot, Docker, and Maven
