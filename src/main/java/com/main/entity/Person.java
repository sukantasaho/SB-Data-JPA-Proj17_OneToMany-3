package com.main.entity;

 
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_PERSON_TAB")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Person 
{
	 @SequenceGenerator(name="gen1", sequenceName = "PERSON_SEQ1", initialValue = 1000, allocationSize = 1)
	 @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	 @Id
     private Integer pid;
	 
	 @NonNull
     private String pname;
	 
	 @NonNull
     private String paddrs;
	 
	 @OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "person_info")
     private Set<PhoneNumber> contactDetails;
	 
	 public Person()
	 {
		 System.out.println("Person::0-param constructor");
	 }

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	 
	 
}
