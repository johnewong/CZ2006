package com.example.demo.controller;

import com.example.demo.pojo.Vet;
import com.example.demo.service.VetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Dashboard Vet management")
@RestController
@RequestMapping(value = "dashboradvet")
public class DashboardVetController {
    @Autowired
    VetService vetService;

    @ApiOperation(value = "api to get vet info")
    @GetMapping("/vet/{vetid}")

    /**
     * This method gets a vet information by vet ID.
     * @param vetid vet ID.
     * @return vet information.
     */
    public Vet getByVetID(@PathVariable("vetid") Integer vetid) throws Exception {
        Vet vet = vetService.getByVetID(vetid);
        return vet;
    }

    @ApiOperation(value = "api to edit vet profile")
    @PostMapping("/vet/profile")
    /**
     * This method edits vet profile.
     * @param vet updated vet information.
     * @return message "Vet profile updated successfully".
     */
    public Object editVetProfile(@RequestBody Vet vet) throws Exception {
        vetService.editVetProfile(vet);
        return new ResponseEntity("Vet profile updated successfully", HttpStatus.OK);
    }

}
