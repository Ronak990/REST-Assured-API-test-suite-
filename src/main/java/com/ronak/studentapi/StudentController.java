package com.ronak.studentapi;

import com.ronak.studentapi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired  //Spring automatically injects the repository
    private StudentRepository studentRepository;

    //Get all Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Get Students by id
    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Student not found!"));

    }

    //Post - add new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //Delete - delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }

    //Put - update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student  updated){
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        existing.setName(updated.getName());
        existing.setAge(updated.getAge());
        existing.setGrade(updated.getGrade());
        return studentRepository.save(existing);
    }
}
