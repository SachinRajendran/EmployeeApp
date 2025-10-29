package com.ssfoft.employee.EmployeeApplication;

import java.time.LocalDate;
import java.util.List;

import com.ssoft.employee.entity.Employee;
import com.ssoft.employee.repository.EmployeeOperationsQueryImpl;
import com.ssoft.employee.service.EmployeeServiceImpl;
import com.ssoft.employee.service.IEmployeeService;

/**
 * Hello world!
 */
public class App {
	private static void addEmployee()
	{
		Employee c1 = new Employee(1001,"Sachin",25000,"Chennai","Java Developer",LocalDate.of(2025,9,18));
		Employee c2 = new Employee(1002,"Mani",225000,"Pune","Full stack Developer",LocalDate.of(2024,9,18));
		Employee c3 = new Employee(1003,"Stephin",325000,"Mumbai","IOT Developer",LocalDate.of(2024,1,18));
		Employee c4 = new Employee(1004,"Guru",125000,"Chennai","Production Manager",LocalDate.of(2022,9,18));
		EmployeeService.addEmployee(c1);
		EmployeeService.addEmployee(c2);
		EmployeeService.addEmployee(c3);
		EmployeeService.addEmployee(c4);
	}
	private static void readEmployee()
	{
		Employee c  = EmployeeService.retriveEmployee(1111);
		if(c==null)
		{
			System.out.println("Not found");
		}
		else
		{
		System.out.println(c.toString());
		}
	}
	private static void updateEmployee()
	{
//		Employee c1 = new Employee(1111,"Capgemini",LocalDate.of(1967, 10, 1),"delhi", 950);
//		Employee c = EmployeeService.updateEmployee(c1);
//		System.out.println(c.toString());
	}
	private static void deleteEmployee()
	{
		boolean res = EmployeeService.removeEmployee(11);
		if(res)
		System.out.println("Deleted sucessfully");
		else
			System.out.println("Not deleted");
	}
	private static IEmployeeService EmployeeService = new EmployeeServiceImpl();
 
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    		//addEmployee();
    		EmployeeOperationsQueryImpl eoqi = new EmployeeOperationsQueryImpl();
    		List<Employee> list = eoqi.findEmployeesByLocation("Chennai");
    		System.out.println(list);
    		System.out.println("--------------------------------------");
    		List<Employee> salary = eoqi.findEmployeesBySalaryRange(100000,300000);
    		System.out.println(salary);
    		System.out.println("--------------------------------------");
    		List<Employee> role = eoqi.findEmployeesByRole("IOT Developer");
    		System.out.println(role);
    		System.out.println("--------------------------------------");
    		List<Employee> rename = eoqi.updateEmployeeNameByRole("Thommai","IOT Developer");
    		System.out.println(rename);
    		System.out.println("--------------------------------------");
    		eoqi.findMonthEmployeeWorked();
    		System.out.println("--------------------------------------");
    		List<Employee> increment = eoqi.updateEmployeeSalary(155000);
    		System.out.println(increment);
    		
    		
    }
}
