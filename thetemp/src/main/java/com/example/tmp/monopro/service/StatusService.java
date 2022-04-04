package com.example.tmp.monopro.service;



import com.example.tmp.monopro.entity.Status;

import java.util.List;
import java.util.Optional;


public interface StatusService  {

    List<Status> getStatusList();

    List<Status> getOrderedStatusList(int limit);




    String saveStatus(Status status);

    String deleteStatus(Status status);
    Optional<Status> getStatusByID(int statusid);
}