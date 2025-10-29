package com.ssoft.employee.service;

import com.ssoft.employee.entity.Employee;

public interface IEmployeeService {
	public Employee addEmployee(Employee Employee);

	public Employee updateEmployee(Employee Employee);

	public Employee retriveEmployee(int empId);

	public boolean removeEmployee(int empId);
}
