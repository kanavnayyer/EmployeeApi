package com.kanav.kanav.repositories;

import com.kanav.kanav.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepository extends JpaRepository<EmployeeEntity,Long> {

}
