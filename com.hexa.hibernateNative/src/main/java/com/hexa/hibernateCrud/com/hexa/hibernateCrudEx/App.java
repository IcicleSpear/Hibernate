package com.hexa.hibernateCrud.com.hexa.hibernateCrudEx;

import Service.StudentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentService service = new StudentService();
        //service.addStudentFromUser();
    	service.removeData();
    	//service.updateStudentByRoll();
    	//service.searchByRoll();
    	
    	//service.showData();
    	
    	//service.searchName();
        
        //service.retrieveByMarks();
    	
    	//service.updateNameByRollUsingHQL();
    	
    	
    }
}
