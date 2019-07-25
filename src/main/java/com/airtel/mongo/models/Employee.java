package com.airtel.mongo.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    @NotBlank(message = "Name Can't be Empty")
    private String name;
    @NotBlank(message = "Department Can't be Empty")
    private String department;
    @NotBlank(message = "Designation Can't be Empty")
    private String designation;


    
    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
     StringBuilder str = new StringBuilder();
     str.append("Employee Id:- " + getId());
     str.append(" First Name:- " + getName());
     str.append(" Department:- " + getDepartment());
     str.append(" Designation:- " + getDesignation());
     return str.toString();
    }
}