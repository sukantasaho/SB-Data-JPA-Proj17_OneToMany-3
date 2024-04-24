package com.main.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Person;
import com.main.entity.PhoneNumber;
import com.main.repository.IPersonRepository;
import com.main.repository.IPhoneNumberRepository;

@Service("otmService")
public class OTMServiceManagementImp implements IOTMServiceManagement 
{

	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public void saveDataUsingParent() 
	{
		 
           Person p1 = new Person("Sukanta","Kothar,Bhadrak");
           PhoneNumber number4 = new PhoneNumber(977882992l,"Airtel","Office");
           PhoneNumber number5 = new PhoneNumber(699882992l,"Jio","Business");
           PhoneNumber number6 = new PhoneNumber(8997882992l,"Voda","Personal");
           number4.setPerson_info(p1);
           number5.setPerson_info(p1);
           number6.setPerson_info(p1);
           p1.setContactDetails(Set.of(number4, number5, number6));
          
           
           personRepo.save(p1);
           System.out.println("Person and his associated object is saved(Parent to Child)");
	}

	@Override
	public void saveDataUsingChild() 
	{
		  Person person = new Person("Banalaxmi","Bhadrak");
		  
		 PhoneNumber number1 = new PhoneNumber(809990788l,"Airtel","Office");
		 PhoneNumber number2 = new PhoneNumber(788899990l,"Jio","Business");
		 person.setContactDetails(Set.of(number1, number2));
		 number1.setPerson_info(person);
		 number2.setPerson_info(person);
		 
		 phoneRepo.save(number1); 
		 phoneRepo.save(number2);
		 
		 System.out.println("Person and his associated object saved(Child to parent)");
		
	}

	@Override
	public void loadDataUsingParent()
	{
		List<Person> pList = personRepo.findAll();
		pList.forEach(per->{
			System.out.println(per);
			Set<PhoneNumber> phones =  per.getContactDetails();
			phones.forEach(ph->{
				System.out.println(ph);
			});
		});
		
	}

	@Override
	public void loadDataUsingChild() 
	{
		 List<PhoneNumber> pList = phoneRepo.findAll();
		 pList.forEach(ph->{
			 System.out.println(ph);
			 System.out.println(ph.getPerson_info());
		 });
		
	}

	@Override
	public String deleteByPerson(Integer personId)
	{
	        Optional<Person>  opt = personRepo.findById(personId);	 
	        if(opt.isPresent())
	        {
	            Person person = opt.get();
	            personRepo.delete(person);
	            
	            return "Person and his associated PhoneNumber object are deleted";
	        }
	        
	    else
		return "Person not found";
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(Integer pid) 
	{
		    Optional<Person> opt = personRepo.findById(pid);
		    if(opt.isPresent())
		    {
		    	Set<PhoneNumber> phones = opt.get().getContactDetails();
		    	phones.forEach(ph->{
		    		ph.setPerson_info(null);
		    	});
		    	phoneRepo.deleteAllInBatch(phones);
		    	
		    	return phones.size()+" PhoneNumbers of "+pid+" Person are deleted";
		    }
		    else
		    return "Person not found";
	}

	@Override
	public String addNewChildToParentById(Integer id) 
	{
		    Optional<Person> opt = personRepo.findById(id);
		    if(opt.isPresent())
		    {
		    	Person person = opt.get();
		    	Set<PhoneNumber> phoneNumber = person.getContactDetails();
		    	PhoneNumber number1 = new PhoneNumber(9000028882l,"Jio","Business");
		    	number1.setPerson_info(person);
		    	phoneNumber.add(number1);
		    	phoneRepo.save(number1);
		    	
		    	return "New child object added to the existing parent";
		    }
		    else
		return "Person not found";
	}

	@Override
	public List<Person> getAllPersons()
	{
		 
		return personRepo.findAll();
	}

	@Override
	public List<Object[]> fetchDataUsingJoinsByParent()
	{
		 
		return personRepo.fetchDataUsingJoinsByParent();
	}

	@Override
	public List<Object[]> fetchDataUsingJoinByChild(String provider) 
	{
		 
		return phoneRepo.fetchDataUsingJoinByChild(provider);
	}
 
	 

}
