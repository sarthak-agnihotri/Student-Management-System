package com.student.controller;

import com.student.model.Exam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "*")
public class ExamController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<Exam> getAllExams() {
        return entityManager.createQuery("SELECT e FROM Exam e ORDER BY e.id DESC", Exam.class).getResultList();
    }

    @PostMapping
    @Transactional
    public Exam createExam(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        String examDateStr = (String) payload.get("examDate");
        String semester = (String) payload.get("semester");
        String academicYear = (String) payload.get("academicYear");
        
        LocalDate examDate = null;
        if (examDateStr != null && !examDateStr.isEmpty()) {
            examDate = LocalDate.parse(examDateStr);
        }
        
        Exam exam = new Exam();
        exam.setName(name);
        exam.setExamDate(examDate);
        exam.setSemester(semester);
        exam.setAcademicYear(academicYear);
        
        entityManager.persist(exam);
        return exam;
    }
}