package com.example.webflux.repo;

import com.example.webflux.entity.Student;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Repository
public class StudentRepo {
    public static final Student TAYLOR = new Student(1, "Taylor", "Mocha");
    public static final Student LILLY = new Student(2, "Lilyy", "Tea");
    public static final Student JOHN = new Student(3, "John", "Coffee");
    public static final Student SCARLET = new Student(4, "Scarlet", "Espresso");

    static Map<String, Student> studentList;

    static {
        studentList = new HashMap<>();
        studentList.put("1", TAYLOR);
        studentList.put("2", LILLY);
        studentList.put("3", JOHN);
        studentList.put("4", SCARLET);

    }


    public Mono<Student> findStudentById(String id) {
        return Mono.just(studentList.get(id));
    }

    public Flux<Student> findAllStudents() {
        return Flux.fromIterable(studentList.values());
    }

    public Mono<Student> updateStudent(Student student) {
        Student existingStudent = studentList.get(student.getId());
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
        }
        return Mono.just(existingStudent);
    }


}