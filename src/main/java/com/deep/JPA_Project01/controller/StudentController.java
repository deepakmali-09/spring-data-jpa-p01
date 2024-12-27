package com.deep.JPA_Project01.controller;

import com.deep.JPA_Project01.entity.Student;
import com.deep.JPA_Project01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/std")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        List<Student> allStudentData = service.getAllStudentData();
        return allStudentData;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public Student getStudentByIdParam(@RequestParam Integer id) {
        return service.getStudentById(id);
    }

    //update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student updatedStudent = service.updateStudent(id, student);
        return updatedStudent;
    }

    //Delete
    @DeleteMapping("/{id}")
    public Optional<Student> deleteStudentById(@PathVariable Integer id){
        return service.deleteStudentById(id);
    }
//    public Student deleteStudent(@PathVariable Integer id) {
////        Student deleteStudent = service.deleteStudentById(id);
////        deleteStudent = null;
////        return "Student deleted";
//        System.out.println("Student delete");
//        return service.deleteStudentById(id);
//    }

    //Patch Mapping
    @PatchMapping("/{id}")
    public Student patchStudent(@RequestBody Student student, @PathVariable Integer id){
        return service.patchStudent(student, id);
    }
}