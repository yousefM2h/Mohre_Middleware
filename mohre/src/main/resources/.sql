CREATE TABLE IF NOT EXISTS Mohre_Company_Employer (

    Id INT AUTO_INCREMENT PRIMARY KEY,

    Emirates_Id VARCHAR(255),
    Person_Code VARCHAR(255),
    Company_Code VARCHAR(255),
    License_No VARCHAR(255),
    License_Place VARCHAR(255),
    License_Place_Arabic VARCHAR(255),
    Company_Name VARCHAR(255),
    Company_Name_Arabic VARCHAR(255),
    Owner_Name VARCHAR(255),
    Owner_Name_Arabic VARCHAR(255),
    Owner_Consent VARCHAR(255),
    Registering_Person_Name VARCHAR(255),
    Registering_Person_Mobile VARCHAR(255),
    Registering_Person_EIDA VARCHAR(255),
    Uab_Status VARCHAR(255),
    Mohre_Status VARCHAR(255),
    Registration_No VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS Mohre_Company_Employer_WF (

    Id INT AUTO_INCREMENT PRIMARY KEY,

    Emirates_Id VARCHAR(255),
    Person_Code VARCHAR(255),
    Company_Code VARCHAR(255),
    License_No VARCHAR(255),
    License_Place VARCHAR(255),
    License_Place_Arabic VARCHAR(255),
    Company_Name VARCHAR(255),
    Company_Name_Arabic VARCHAR(255),
    Owner_Name VARCHAR(255),
    Owner_Name_Arabic VARCHAR(255),
    Owner_Consent VARCHAR(255),
    Registering_Person_Name VARCHAR(255),
    Registering_Person_Mobile VARCHAR(255),
    Registering_Person_EIDA VARCHAR(255),
    Uab_Status VARCHAR(255),
    Mohre_Status VARCHAR(255),
    Registration_No VARCHAR(255),

    First_User_Action_Date TIMESTAMP NULL,
    Second_User_Action_Date TIMESTAMP NULL,
    First_Approver VARCHAR(255),
    Second_Approver VARCHAR(255),
    Is_Rejected VARCHAR(50)

);
