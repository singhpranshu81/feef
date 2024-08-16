# feef
Cpontrollerr
package com.mpha.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mpha.model.Employee;
import com.mpha.model.FullTime;
import com.mpha.model.Parttime;
import com.mpha.model.Salary;

public class EmployeeController implements Employeeintrface{
	 Employee emp;
	// Salary sal= new Salary();
	 FullTime sal=new FullTime();
	 Parttime pr=new Parttime();
	 Scanner sc = new Scanner(System.in);
	 List<Employee> emplist = new ArrayList<>();
       public void addEmp() {
    	   emp=new Employee();
    	   int p=0;
    	   String s=null;
    	   String type=null;
    	  // push all the values to the model
    	   System.out.println("Enter Emp name: ");
    	   s=sc.next();
    	   System.out.println("Enter Emp ID: ");
    	   p=sc.nextInt();
    	   System.out.println("Enter Emp Type: ");
    	   type=sc.next();
    		emp.setEmpno(p);
    		emp.setEmpname(s);
    		if(type.equals("F")) {
    		System.out.println("Enter salary: ");
    		int basic = sc.nextInt();
    		sal.setBasic(basic);
    		sal.setHra();
    		sal.setPf();
    		sal.setGross();
    		sal.setNet();
    		System.out.println("salary: ");
    		sal.totsalary();
             emp.setSalary(sal);
             emplist.add(emp);
    		System.out.println("Employee added");
    		}
    		else if (type.equals("P"))
    		{
    			System.out.println("Enter hours worked : ");
         		int basic = sc.nextInt();
         		pr.setHours(basic);
         		System.out.println("Enter wage/hr worked : ");
         		int d = sc.nextInt();
         		pr.setTsal(d);
         		System.out.println("salary: ");
         		pr.totsalary();
         		emp.setSl(pr);
         		 emplist.add(emp);
         		System.out.println("Employee added");
    		}
    		
          }
    
       public void viewemp()
          {
    	  // System.out.println(emp.getempno() + " "+ emp.getname());
    	   Iterator i = emplist.iterator();
    	   while(i.hasNext()) {
    		 //  Employee e=(Employee) i.next(); //  access e.getEmpno()+e.getName();
   			System.out.println(i.next());
   		}
    	//  System.out.println(emp);
    	   }
     
}
-=======================
package com.mpha.controller;

public interface Employeeintrface {
	public void addEmp();

	  public void viewemp();
	 
}
========
package com.mpha.controller;

public interface Empsal {
 public void totsalary();
}
=====
MODELS

package com.mpha.model;

public class Employee {  // has a relationship  --> Employee has a name ,id,salary
 private int empno;
 private String empname; // string is predefined datatype
  //private Salary salary;  // user defined reference datatype
  private Parttime sl;
  private FullTime salary;
public int getEmpno() {
	return empno;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public Parttime getSl() {
	return sl;
}
public void setSl(Parttime sl) {
	this.sl = sl;
}
public FullTime getSalary() {
	return salary;
}
public void setSalary(FullTime salary) {
	this.salary = salary;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
@Override
public String toString() {
	return "Employee [empno=" + empno + ", empname=" + empname + ", sl=" + sl + ", salary=" + salary + "]";
}

}
// ensure to use tostring() in all the model classes
=====
package com.mpha.model;

import com.mpha.controller.Empsal;

public class FullTime implements Empsal {
	 private int basic;
     private double hra;
     private double pf;
     private double gross;
     private double net;
     private int tsal;
	public FullTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra() {
		this.hra = basic*0.1;
	}
	public double getPf() {
		return pf;
	}
	public void setPf() {
		this.pf =basic*0.05;
	}
	public double getGross() {
		return gross;
	}
	public void setGross() {
		this.gross = getBasic()+getHra()+getPf();
	}
	public double getNet() {
		return net;
	}
	public void setNet() {
		this.net = getGross()-getPf();
	}
	public double totalSalary() {
		return getNet();
	}
	@Override
	public void totsalary() {
		System.out.println(getNet());
	}
	@Override
	public String toString() {
		return "FullTime [basic=" + basic + ", hra=" + hra + ", pf=" + pf + ", gross=" + gross + ", net=" + net
				+ ", tsal=" + tsal + "]";
	}
     
}
====
package com.mpha.model;

import com.mpha.controller.Empsal;

public class Parttime implements Empsal{
	 private final int fp=1000 ;
     private int hours;
 private int tsal;
	public Parttime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getFp() {
		return fp;
	}
	public int getTsal() {
		return tsal;
	}
	public void setTsal(int x) {
		this.tsal = getHours()*x;
	}
	@Override
	public void totsalary() {
		System.out.println(getTsal());
	}
	@Override
	public String toString() {
		return "Parttime [fp=" + fp + ", hours=" + hours + ", tsal=" + tsal + "]";
	}

}
=========
package com.mpha.model;

public class Salary {
      private int basic;
      private double hra;
      private double pf;
      private double gross;
      private double net;
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra() {
		this.hra = basic*0.1;
	}
	public double getPf() {
		return pf;
	}
	public void setPf() {
		this.pf =basic*0.05;
	}
	public double getGross() {
		return gross;
	}
	public void setGross() {
		this.gross = getBasic()+getHra()+getPf();
	}
	public double getNet() {
		return net;
	}
	public void setNet() {
		this.net = getGross()-getPf();
	}
	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", hra=" + hra + ", pf=" + pf + ", gross=" + gross + ", net=" + net + "]";
	}
      
}
//// POJO  -> plain object java
//-- a CLASS WITH PRIVATE INSTACE VARIABLE
//-- public getter and setter
//prameterless constructor
//toString
===========
VIEW  
package com.mpha.view;

import java.util.Scanner;

import com.mpha.controller.EmployeeController;
import com.mpha.controller.Employeeintrface;

// all keywords in java is in small case like  package,class ,public,  etc..
// static variables can be created only within a class
public class MainClass {
	double x; // all instance variable has a defined value like 0

	public static void main(String[] args) {
		System.out.println("Hello beta!!");
//		MainClass mc= new MainClass(); //new MainClass() is reference getting store in object mc
//		System.out.println(mc.x);
//		System.out.println(mc);
		//EmployeeController ec = new EmployeeController();
		Employeeintrface ec=new EmployeeController();
//		ec.addEmp(102, "Ramesh");
//		ec.viewemp();
		Scanner sc = new Scanner(System.in);
		String s = null;
		do {
//			System.out.println("Enter choice: 1. Full time Emp  2. Parttime Emp ");
			System.out.println("Enter choice: 1. Add 2. View");
			
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
			default:
				System.out.println("wrong key press");
			}
			System.out.println("if want to continue : press n");
			s = sc.next();
		
			
		} while (s.equals("n"));
		
		System.out.println("Thanks for using");
		System.exit(0);
	}

}

