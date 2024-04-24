package com.main.services;

import java.util.List;

import com.main.entity.Person;

public interface IOTMServiceManagement 
{
      public void saveDataUsingParent();
      public void saveDataUsingChild();
      public void loadDataUsingParent();
      public void loadDataUsingChild();
      public String deleteByPerson(Integer personId);
      public String deleteAllPhoneNumbersOfAPerson(Integer pid);
      public String addNewChildToParentById(Integer id);
      public List<Person> getAllPersons();
      public List<Object[]> fetchDataUsingJoinsByParent();
      public List<Object[]> fetchDataUsingJoinByChild(String provider);
}
