package com.deep.JPA_Project01.service;

import com.deep.JPA_Project01.entity.Student;
import com.deep.JPA_Project01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudentData() {
        List<Student> list = studentRepo.findAll();
        return list;
    }

    public Student getStudentById(Integer id) {
        Optional<Student> byId = studentRepo.findById(id);
        Student student = byId.get();
        return student;
    }

    public Student updateStudent(Integer id, Student student) {

        Optional<Student> studentById = studentRepo.findById(id);
        Student stud = null;
        if(studentById.isPresent()) {
            Student dbStudentObject = studentById.get();
            dbStudentObject.setName(student.getName());
            dbStudentObject.setEmail(student.getEmail());
            dbStudentObject.setAge(student.getAge());
            stud = studentRepo.save(dbStudentObject);
        } else {
            System.out.println("Data not present in DB...");
        }
        return stud;
    }

    //Delete Mapping

//    public Student deleteStudentById(Integer id) {
//        Optional<Student> deleteById = studentRepo.findById(id);
//        Student student = deleteById.get();
//        return student = null;
//    }
    public Optional<Student> deleteStudentById(Integer id){
        Optional<Student> student = studentRepo.findById(id);

        if(student.isPresent()){
            studentRepo.deleteById(id);
        } else {
            System.out.println("Student not found!");
        }
        return student;
    }

    public Student patchStudent(Student student, Integer id){
        Optional<Student> studentById = studentRepo.findById(id);
        Student std = null;
        if(studentById.isPresent()){
            Student dbStudent = studentById.get();

            if(student.getName() != null)
                dbStudent.setName(student.getName());

            if(student.getAge() != 0)
                dbStudent.setAge(student.getAge());

            if(student.getEmail() != null)
                dbStudent.setEmail(student.getEmail());

            std = studentRepo.save(dbStudent);
        } else {
            System.out.println("Data not present in db");
        }
        return std;
    }
}
