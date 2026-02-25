package com.mohre.middleware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohre.middleware.model.CompanyEmployer;
import com.mohre.middleware.model.CompanyEmployerWF;

public interface ComapnyEmployerWFRepository extends JpaRepository<CompanyEmployerWF, Integer> {

	CompanyEmployerWF getFirstByEmiratesID(String emiratesID);

}
