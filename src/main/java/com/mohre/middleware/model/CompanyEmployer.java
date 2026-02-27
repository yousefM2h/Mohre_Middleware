package com.mohre.middleware.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Mohre_companyEmployer")
public class CompanyEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
    @Column(name = "Emirates_Id")
    private String emiratesID;

    @Column(name = "Person_Code")
    private String personCode;

    @Column(name = "Company_Code")
    private String companyCode;

    @Column(name = "License_No")
    private String licenseNO;

    @Column(name = "License_Place")
    private String licensePlace;

    @Column(name = "License_Place_Arabic")
    private String licensePlaceArabic;

    @Column(name = "Company_Name")
    private String companyName;

    @Column(name = "Company_Name_Arabic")
    private String companyNameArabic;

    @Column(name = "Owner_Name")
    private String ownerName;

    @Column(name = "Owner_Name_Arabic")
    private String ownerNameArabic;

    @Column(name = "Owner_Consent")
    private String ownerConsent;

    @Column(name = "Registering_Person_Name")
    private String registeringPersonName;

    @Column(name = "Registering_Person_Mobile")
    private String registeringPersonMobile;

    @Column(name = "Registering_Person_EIDA")
    private String registeringPersonEIDA;

    @Column(name = "Uab_Status")
    private String uabStatus;

    @Column(name = "Mohre_Status")
    private String mohreStatus;

    @Column(name = "Registration_No")
    private String registrationNo;

	
}
