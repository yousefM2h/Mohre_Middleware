package com.mohre.middleware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohre.middleware.model.CompanyEmployer;
import com.mohre.middleware.model.response.RegisteredCompanyDetails;

public interface CompanyEmployerRepository extends JpaRepository<CompanyEmployer, Integer> {

	

	
//	public List<RegisteredCompanyDetails> getAllCompanies();

}
