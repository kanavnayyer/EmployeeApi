package com.kanav.kanav.services;

import com.kanav.kanav.dto.Employe;
import com.kanav.kanav.entities.EmployeeEntity;
import com.kanav.kanav.repositories.Employeerepository;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeService {

    final ModelMapper modelMapper;
     final Employeerepository employeerepository;


    public EmployeService(ModelMapper modelMapper, Employeerepository employeerepository) {
        this.modelMapper = modelMapper;
        this.employeerepository = employeerepository;
    }

    public Employe getEmployebyId(Long id){
      EmployeeEntity entity= employeerepository.getById(id);
return modelMapper.map(entity,Employe.class);
    }

    public Employe createNewEmploy(Employe employedto) {

EmployeeEntity employeeEntity= modelMapper.map(employedto,EmployeeEntity.class);
return modelMapper.map( employeerepository.save(employeeEntity),Employe.class);
    }

    public List<Employe> getAllEmployees() {
      return  employeerepository.findAll().stream()
              .map(employeeEntity -> modelMapper.map(employeeEntity,Employe.class))
              .collect(Collectors.toList());
    }

    public boolean deleteEmploybyId(Long id) {
        boolean iispresent=employeerepository.existsById(id);
        if(!iispresent)return false;
        employeerepository.deleteById(id);
        return iispresent;

    }
}
