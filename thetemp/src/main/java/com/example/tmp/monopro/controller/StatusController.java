package com.example.tmp.monopro.controller;



import com.example.tmp.monopro.entity.Status;
import com.example.tmp.monopro.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController

public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;


    @GetMapping("/getStatus")
    public List<Status> getStatus() {
        List<Status> status = null;
        status = statusService.getStatusList();
        return status;

    }


    @PostMapping
    public ModelAndView addStatus(
            @RequestParam("userid") String userid,
            @RequestParam("filename") String filename,
            @RequestParam("satname") String satname,
            @RequestParam("azconfig") String azconfig,
            @RequestParam("azdescription") String azdescription

    ) {

        Status status=new Status();
        status.setUserid(Integer.parseInt(userid));
        status.setFilename(filename);
        status.setProcessed(false);
        status.setMailsend(false);
        status.setSatname(satname);
        status.setAzconfig(azconfig);
        status.setProcessdate(LocalDateTime.now());
        status.setUpdatedate(LocalDateTime.now());
        status.setUpdatedate(null);
        status.setAzdescription(azdescription);


        statusService.saveStatus(status);

        return statusModelAndView();
    }


    private ModelAndView statusModelAndView(){
        ModelAndView modelAndView = new ModelAndView("status");
        List<Status> status = null;
        status = statusService.getOrderedStatusList(100);
        modelAndView.addObject("statuslist", status);

        return modelAndView;

    }

    @GetMapping("/showStatus")
    public ModelAndView redirection(
            ModelMap model,
            @ModelAttribute("testAttribute") Object flashAttribute) {

        model.addAttribute("testAttribute", flashAttribute);
        return new ModelAndView("/status", model);
    }


    @GetMapping("/status")
    public ModelAndView showStatus() {

        return statusModelAndView();
    }

    @GetMapping("/status/{id}")
    public Status showStatusById(@PathVariable("id") int id) {

        return statusService.getStatusByID(id).orElse(null);

    }

}




