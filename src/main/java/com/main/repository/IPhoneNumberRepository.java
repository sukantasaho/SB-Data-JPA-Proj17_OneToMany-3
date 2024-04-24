package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> 
{
	  @Query("SELECT p.pid,p.pname,paddrs,ph.regNo,ph.mobNo,ph.provider,ph.numberType FROM PhoneNumber ph join ph.person_info p where ph.provider=:provider")
      public List<Object[]> fetchDataUsingJoinByChild(String provider);
}
