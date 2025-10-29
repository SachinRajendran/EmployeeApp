package com.ssoft.employee.repository;

import com.ssoft.employee.entity.Employee;
import com.ssoft.employee.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class EmployeeRepositoryImpl implements IEmployeeRepository
{

		private EntityManager entityManager;
		@Override
		public Employee saveEmployee(Employee employee) {
			entityManager = EntityManagerUtil.getEntityManager();
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(employee);
			
			System.out.println("Employee saved in db");
			
			entityManager.getTransaction().commit();
			
			return employee;
		}

		@Override
		public Employee findEmployee(int empId) {
			
			entityManager = EntityManagerUtil.getEntityManager();
			Employee Employee = entityManager.find(Employee.class, empId);
			if(Employee!=null)
			{
			System.out.println("Employee details found");
			}
			return Employee;
		}

		@Override
		public Employee updateEmployee(Employee Employee) {
			entityManager = EntityManagerUtil.getEntityManager();
			Employee retrievedEmployee = findEmployee(Employee.getEmpId());
			System.out.println(retrievedEmployee);
			if(retrievedEmployee!=null)
			{
			entityManager.getTransaction().begin();
			retrievedEmployee.setName(Employee.getName());
			retrievedEmployee.setDoj(Employee.getDoj());
			retrievedEmployee.setLocation(Employee.getLocation());
			retrievedEmployee.setRole(Employee.getRole());
			retrievedEmployee.setSalary(Employee.getSalary());
			
			entityManager.getTransaction().commit();
			System.out.println("Employee info updated");
			}
			else
			{
				System.out.println("Employee details not found");
			}
			
			return Employee;
		}

		@Override
		public boolean removeEmployee(int empId)
		{
			entityManager = EntityManagerUtil.getEntityManager();
			Employee Employee = findEmployee(empId);
			if(Employee!=null)
			{
			entityManager.getTransaction().begin();
			entityManager.remove(Employee);
			entityManager.getTransaction().commit();
			System.out.println("Employee obj deleted for id: "+ empId);
			return true;
			}
			
			return false;
		}

	}
