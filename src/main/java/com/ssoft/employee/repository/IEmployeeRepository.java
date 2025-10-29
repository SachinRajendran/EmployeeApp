package com.ssoft.employee.repository;

import com.ssoft.employee.entity.Employee;

public interface IEmployeeRepository 
{
	public Employee saveEmployee(Employee employee);
	public Employee findEmployee(int empId);
	public Employee updateEmployee(Employee employee);
	public boolean removeEmployee(int empId);
}
