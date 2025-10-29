package com.ssoft.employee.repository;

import java.util.List;
import java.util.Map;

import com.ssoft.employee.entity.Employee;

public interface IEmployeeQueryOperations 
{
public List<Employee> findEmployeesByLocation(String location);

public List<Employee> findEmployeesBySalaryRange(double from, double to);

public List<Employee> findEmployeesByRole(String role);

public List<Employee> updateEmployeeNameByRole(String newName,String role);

public List<Employee> updateEmployeeSalary(int percent);

public void findMonthEmployeeWorked();

}
