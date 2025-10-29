package com.ssoft.employee.service;

import com.ssoft.employee.entity.Employee;
import com.ssoft.employee.repository.EmployeeRepositoryImpl;
import com.ssoft.employee.repository.IEmployeeRepository;

public class EmployeeServiceImpl implements IEmployeeService
{

private IEmployeeRepository EmployeeRepository = new EmployeeRepositoryImpl();
	
	@Override
	public Employee addEmployee(Employee Employee) {
		Employee savedEmployee = EmployeeRepository.saveEmployee(Employee);
		return savedEmployee;
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		Employee updatedEmployee = EmployeeRepository.updateEmployee(Employee);
		return updatedEmployee;
	}

	@Override
	public Employee retriveEmployee(int empId) {
		
		Employee foundEmployee = EmployeeRepository.findEmployee(empId);
		if(foundEmployee!=null)
		return foundEmployee;
		
		return null;
	}

	@Override
	public boolean removeEmployee(int empId) {
		boolean result = EmployeeRepository.removeEmployee(empId);
		return result;
	}

}
