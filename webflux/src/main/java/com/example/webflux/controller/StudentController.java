package com.example.webflux.controller;


import com.example.webflux.entity.Student;
import com.example.webflux.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentRepo studentRepository;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepository = studentRepo;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Mono<String> index() {
        return Mono.just("OK!");
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    private Mono<Student> getStudentById(@PathVariable String id) {
        return studentRepository.findStudentById(id);
    }


    @GetMapping(path = "/getAll")
    private Flux<Student> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @PostMapping("/update")
    private Mono<Student> updateStudent(@RequestBody Student student) {
        return studentRepository.updateStudent(student);
    }

}
