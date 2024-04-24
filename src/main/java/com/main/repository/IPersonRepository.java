package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> 
{
	  @Query("SELECT p.pid,p.pname,paddrs,ph.regNo,ph.mobNo,ph.provider,ph.numberType FROM Person p inner join p.contactDetails ph")
	  public List<Object[]> fetchDataUsingJoinsByParent();
	
	  
}
