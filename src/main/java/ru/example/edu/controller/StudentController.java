package ru.example.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.edu.model.Student;
import ru.example.edu.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;
    private long countId = 0;

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return repository.getStudentList();
    }

    @PostMapping("/student")
    public long saveStudent(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        countId = countId + 1;
        Student savedStudent = new Student(countId, name, email, age);
        return repository.save(savedStudent);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable long id) {
        return repository.getById(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id) {
        repository.deleteById(id);
    }
}
