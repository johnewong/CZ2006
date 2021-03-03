package com.example.demo.controller;

import com.example.demo.pojo.Treatment;
import com.example.demo.pojo.User;
import com.example.demo.service.TreatmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Treatment management")
@RestController
@RequestMapping(value = "treatment")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;

    @ApiOperation(value = "api to get all treatment")
    @GetMapping("/")
    public List<Treatment> list() throws Exception {
        return treatmentService.list();
    }

}
