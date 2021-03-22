package com.example.demo.controller;

import com.example.demo.pojo.Treatment;
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
    @GetMapping("")
    /**
     * This method gets all treatment.
     * @return all treatment.
     */
    public List<Treatment> getall() throws Exception {
        return treatmentService.list();
    }

    @ApiOperation(value = "api to get treatment by id")
    @GetMapping("/{treatmentid}")
    /**
     * This method gets treatment by treatment ID;
     * @param treatmentid treatment ID.
     * @return treatment.
     */
    public Treatment getByTreatmentID(@PathVariable("treatmentid") Integer treatmentid) throws Exception {
        return treatmentService.getByTreatmentID(treatmentid);
    }


}
