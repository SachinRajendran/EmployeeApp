package com.ssoft.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee
{
	@Id
	@Column(name = "Employee Id")
	private int empId;
	@Column(name = "Employee Name")
	private String name;
	@Column(name = "Enmployee Salary")
	private double salary;
	@Column(name = "Employee Location")
	private String location;
	@Column(name = "Employee role")
	private String role;
	@Column(name = "Date of Joining")
	private LocalDate doj;
	
	public Employee(int empId, String name, double salary, String location, String role, LocalDate doj) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.location = location;
		this.role = role;
		this.doj = doj;
	}
	public Employee()
	{
		
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "empId=" + empId + ", name=" + name + ", salary=" + salary + ", location=" + location
				+ ", role=" + role + ", doj=" + doj + "\n";
	}
}
