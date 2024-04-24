package com.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.entity.Person;
import com.main.services.IOTMServiceManagement;

@SpringBootApplication
public class SbDataJpaProj17OneToMany3Application 
{

	public static void main(String[] args)
	{
		   ApplicationContext ctx = SpringApplication.run(SbDataJpaProj17OneToMany3Application.class, args);
		   IOTMServiceManagement service = ctx.getBean("otmService", IOTMServiceManagement.class);
		   //service.saveDataUsingParent();
		   //service.saveDataUsingChild();
		   //service.loadDataUsingParent();
		   //service.loadDataUsingChild();
		   
		   //delete parent and its associated object
		   //System.out.println(service.deleteByPerson(1005));
		   //System.out.println(service.deleteAllPhoneNumbersOfAPerson(1004));
		   //System.out.println(service.addNewChildToParentById(1004));
			/*List<Person> oList = service.getAllPersons();
			for(Person p : oList)
			{
			  System.out.println(p);
			  System.out.println(p.getContactDetails());
			}*/
			/*System.out.println("pid\tpname\taddrs\tphoneid\tphoneNum\tprovide\tnumberType");
			System.out.println("**************************************************************");
			service.fetchDataUsingJoinsByParent().forEach(row->{
			   for(Object val : row)
			   {
				   System.out.print(val+" ");
			   }
			   System.out.println();
			});*/
		   
		   System.out.println("pid\tpname\taddrs\tphoneid\tphoneNum\tprovide\tnumberType");
		   System.out.println("**************************************************************");
		   service.fetchDataUsingJoinByChild("Jio").forEach(row->{
		        for(Object obj : row)
		        {
		        	 System.out.print(obj+" ");
		        }
		        System.out.println();
		   });
		   ((ConfigurableApplicationContext) ctx).close();
	}

}
