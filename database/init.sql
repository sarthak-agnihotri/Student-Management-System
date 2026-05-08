CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT IGNORE INTO students (name, email, course, age) VALUES
('Rahul Sharma', 'rahul@example.com', 'Computer Science', 22),
('Priya Patel', 'priya@example.com', 'Mathematics', 21),
('Amit Kumar', 'amit@example.com', 'Physics', 23);