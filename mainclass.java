package com.mpha.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.mpha.controller.EmployeeController;
import com.mpha.controller.Employeeintrface;
import com.mpha.exceptions.EmployeeNotFoundException;

// all keywords in java is in small case like  package,class ,public,  etc..
// static variables can be created only within a class
public class MainClass {
	double x; // all instance variable has a defined value like 0

	public static void main(String[] args) throws NumberFormatException, IOException{
		System.out.println("Hello beta!!");
//		MainClass mc= new MainClass(); //new MainClass() is reference getting store in object mc
//		System.out.println(mc.x);
//		System.out.println(mc);
		//EmployeeController ec = new EmployeeController();
		Employeeintrface ec=new EmployeeController();
	try {	
		InputStreamReader isr= new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
	String un=null,pass=null;

   int z=0;
   for(int i=0;i<3 && z!=3;i++) {
		System.out.println("Enter user: ");
		un=br.readLine();
		System.out.println("Enter password: ");
		pass=br.readLine();
//		ec.addEmp(102, "Ramesh");
//		ec.viewemp();
		Scanner sc = new Scanner(System.in);
		String s = null;
		
		if(un.equals("pran") && pass.equals("qqq") ) {
		do {
//			System.out.println("Enter choice: 1. Full time Emp  2. Parttime Emp ");
			System.out.println("Enter choice: 1. Add 2. View 3.Serialize 4.Deserialise");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				
				ec.addEmp();
				break;
			}
			case 2: {
				ec.viewemp();
				break;
			}
			case 3:{
				ec.serialize();
				break;
			}
			case 4:{
				ec.deserialize();
			}
			default:
				System.out.println("wrong key press");
			}
			System.out.println("if want to continue : press n");
			s = sc.next();
		
			
		} while (s.equals("n"));
		
		System.out.println("Thanks for using");
		System.exit(0);
	}
	
	else {z++;
	if(z<3)System.out.println("Wrong details !! enter again !!");	
	else throw new EmployeeNotFoundException("Invalid user!! ");
	
	}
   }
	}
	catch(EmployeeNotFoundException rf) {
		System.out.println(rf);
	
	}
	System.exit(0);
	}
}
