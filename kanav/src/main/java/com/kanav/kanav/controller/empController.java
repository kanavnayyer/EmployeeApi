package com.kanav.kanav.controller;
// get post delete

import com.kanav.kanav.dto.Employe;
import com.kanav.kanav.services.EmployeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping(path="/employees")
public class empController {

    private  final EmployeService service;

    public empController(EmployeService service) {
        this.service = service;
    }

@DeleteMapping(path = "/{id}")
public boolean deleteId(@PathVariable("id") Long id){
        return service.deleteEmploybyId(id);

}



    @GetMapping(path = "/{id}")
public Employe getEmployebyId(@PathVariable("id")Long Empid){
       return service.getEmployebyId(Empid);
    }

    
    @PostMapping
    public Employe CreateEmp(@RequestBody Employe employedto){

        return  service.createNewEmploy(employedto);
    }
    @GetMapping
    public List<Employe> getAllEmployees(){
       return service.getAllEmployees();
    }



}
