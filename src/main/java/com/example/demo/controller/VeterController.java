package com.example.demo.controller;

import com.example.demo.pojo.Vet;
import com.example.demo.service.VetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Vet management")
@RestController
@RequestMapping(value = "vet")
public class VeterController {
    @Autowired
    VetService vetService;

    @ApiOperation(value = "api to get a vet by vetid", notes = "", response = Vet.class)
    @GetMapping("/{vetid}")
    /**
     * This method gets a vet information by vet ID.
     * @param vetid veter ID.
     * @return vet information.
     */
    public Vet getByID(@PathVariable("vetid") Integer vetid) throws Exception {
        Vet vet = vetService.getByVetID(vetid);
        return vet;
    }


}
