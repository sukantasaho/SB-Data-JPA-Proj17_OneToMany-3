package com.main.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_PHONENUMBER_TAB")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber
{
	@Id
	@SequenceGenerator(name = "gen2", sequenceName = "PHONENUMBER_SEQ1", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
     private Integer regNo;
     
     
	@NonNull
     private Long mobNo;
	@NonNull
     private String provider;
	@NonNull
     private String numberType;
     
	//CasecadeType change All to Merge due to add new child object to parent
     @ManyToOne(targetEntity = Person.class,  fetch = FetchType.EAGER, cascade = CascadeType.MERGE)    
     @JoinColumn(name="person_id", referencedColumnName = "pid")
     private Person person_info;
     
     public PhoneNumber()
     {
    	 System.out.println("PhoneNumber::0-param constructor");
     }

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobNo=" + mobNo + ", provider=" + provider + ", numberType="
				+ numberType + "]";
	}
     
}
