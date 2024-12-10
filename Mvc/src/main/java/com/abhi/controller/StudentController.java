package com.abhi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhi.model.Student;
import com.abhi.services.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {
	
	
	
	
	/*
	 * 
	 * www.chetu.com/students/edit
	 * 
	 * 
	 * 
	 * 
	 */

    @Autowired
    private StudentService studentService;

    // Display list of students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    // Show form to add a new student
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // Process the form to add a new student
    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student-form";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }

    // Show form to update an existing student
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        model.addAttribute("student", student);
        return "student-form";
    }

    // Process the form to update an existing student
    @GetMapping("/edit")
    public String editStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student-form";
        }
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}

