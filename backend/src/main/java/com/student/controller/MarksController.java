package com.student.controller;

import com.student.model.Marks;
import com.student.model.Student;
import com.student.model.Exam;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<Marks> getAllMarks() {
        return entityManager.createQuery("SELECT m FROM Marks m", Marks.class).getResultList();
    }

    @PostMapping
    @Transactional
    public Marks createMarks(@RequestBody Map<String, Object> payload) {
        Long studentId = Long.parseLong(payload.get("studentId").toString());
        Long examId = Long.parseLong(payload.get("examId").toString());
        String subject = payload.get("subject").toString();
        Integer marksObtained = Integer.parseInt(payload.get("marksObtained").toString());
        Integer totalMarks = Integer.parseInt(payload.get("totalMarks").toString());
        String grade = payload.get("grade").toString();

        Student student = entityManager.find(Student.class, studentId);
        Exam exam = entityManager.find(Exam.class, examId);

        Marks marks = new Marks();
        marks.setStudent(student);
        marks.setExam(exam);
        marks.setSubject(subject);
        marks.setMarksObtained(marksObtained);
        marks.setTotalMarks(totalMarks);
        marks.setGrade(grade);

        entityManager.persist(marks);
        return marks;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMarks(@PathVariable Long id) {
        Marks marks = entityManager.find(Marks.class, id);
        if (marks != null) {
            entityManager.remove(marks);
        }
    }
}