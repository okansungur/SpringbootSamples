package com.example.msdetails.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.msdetails.entity.StudentDetails;
import com.example.msdetails.repo.StudentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class StudentDetailController {

    @Autowired
    StudentDetailsRepo studentDetailsRepository;
    @GetMapping("/studentDetails")
    public List<StudentDetails>  getAllDetails() {

            List<StudentDetails> details = new ArrayList<StudentDetails>();
            studentDetailsRepository.findAll().forEach(details::add);
        return details;

    }

    @GetMapping("/studentDetails/{id}")
    public ResponseEntity<StudentDetails> getDetailById(@PathVariable("id") UUID id) {
        Optional<StudentDetails> details = studentDetailsRepository.findById(id);

        if (details.isPresent()) {
            return new ResponseEntity<>(details.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/addStudentDetail")
    public ResponseEntity<StudentDetails> createDetail() {

        String[] dataArray = {"Extraversion  Don't talk a lot and don't like to draw attention to himself ", "Neuroticism Get stressed out easily worry about things can get upset easily",
                "Agreeableness Interested in people sympathize with others' feelings take time out for others"};
        Random r = new Random();
        Long number = new Random().nextLong();
        int randomNumber = r.nextInt(dataArray.length);
        StudentDetails std = new StudentDetails(Uuids.timeBased(), number, dataArray[randomNumber] + "");
        studentDetailsRepository.save(std);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }


}
