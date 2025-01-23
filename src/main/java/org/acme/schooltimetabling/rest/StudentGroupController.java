package org.acme.schooltimetabling.rest;

import org.acme.schooltimetabling.domain.StudentGroup;
import org.acme.schooltimetabling.persistence.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentgroups")
public class StudentGroupController {

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @GetMapping
    public List<StudentGroup> getAllTeachers() {
        return studentGroupRepository.findAll();
    }

    @PostMapping
    public StudentGroup createStudentGroup(@RequestBody StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }
}
