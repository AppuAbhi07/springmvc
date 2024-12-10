package com.abhi.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.abhi.model.Student;

@Service
public class StudentService {

    private final Map<Integer, Student> studentMap = new HashMap<>();
    private int currentId = 1;

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public void addStudent(Student student) {
        student.setId(currentId++);
        studentMap.put(student.getId(), student);
    }

    public Student getStudentById(int id) {
        return studentMap.get(id);
    }

    public void updateStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void deleteStudent(int id) {
        studentMap.remove(id);
    }
}
