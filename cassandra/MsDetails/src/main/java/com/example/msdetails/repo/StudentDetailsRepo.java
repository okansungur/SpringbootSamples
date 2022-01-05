package com.example.msdetails.repo;


import com.example.msdetails.entity.StudentDetails;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface  StudentDetailsRepo extends CassandraRepository<StudentDetails, UUID> {

}








