package com.ssoft.employee.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssoft.employee.entity.Employee;
import com.ssoft.employee.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class EmployeeOperationsQueryImpl implements IEmployeeQueryOperations {
	private EntityManager em;
	@Override
	public List<Employee> findEmployeesByLocation(String location)
	{
		String query = "select e from Employee e where e.location=:loc";
		em=EntityManagerUtil.getEntityManager();
		TypedQuery<Employee> typedquery = em.createQuery(query, Employee.class);
		typedquery.setParameter("loc", location);
		return typedquery.getResultList();
	}

	@Override
	public List<Employee> findEmployeesBySalaryRange(double from, double to)
	{
		String query = "select e from Employee e where e.salary between :from and :to";
		em=EntityManagerUtil.getEntityManager();
		TypedQuery<Employee> typedquery = em.createQuery(query, Employee.class);
		typedquery.setParameter("from", from);
		typedquery.setParameter("to", to);
		return typedquery.getResultList();
	}

	@Override
	public List<Employee> findEmployeesByRole(String role)
	{
		String query = "select e from Employee e where e.role=:role ORDER BY e.role";
		em=EntityManagerUtil.getEntityManager();
		TypedQuery<Employee> typedquery = em.createQuery(query, Employee.class);
		typedquery.setParameter("role", role);
		return typedquery.getResultList();
	}

	@Override
	public List<Employee> updateEmployeeNameByRole(String newName, String role)
	{
	
		em = EntityManagerUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		String update_query = "update Employee e set e.name=?1 where e.role=?2";
		Query query = em.createQuery(update_query);
		query.setParameter(1, newName);
		query.setParameter(2, role);
		tx.begin();
		int rowsUpdated = query.executeUpdate();
		tx.commit();
		String typedQuery = "select e from Employee e where e.name=:n";
		TypedQuery<Employee> typeQuery = em.createQuery(typedQuery, Employee.class);
		typeQuery.setParameter("n", newName);
		return typeQuery.getResultList();
		//return rowsUpdated;
	}

	@Override
	public List<Employee> updateEmployeeSalary(int percent) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();

		// ✅ Correct way to execute an update query
		String updatedQuery = "UPDATE Employee e SET e.salary = e.salary * :percent";
		Query query = em.createQuery(updatedQuery);
		int multiplier =(int)( 1 + (percent / 100.0));
		query.setParameter("percent", multiplier);
		int updatedCount = query.executeUpdate(); // <-- Use executeUpdate() here
		em.getTransaction().commit();

		// Now fetch updated data
		em.getTransaction().begin();
		String typedQuery = "SELECT e FROM Employee e";
		TypedQuery<Employee> query1 = em.createQuery(typedQuery, Employee.class);
		List<Employee> list = query1.getResultList(); // <-- Use query1, not query
		em.getTransaction().commit();

		return list;
	}

	@Override
	public void findMonthEmployeeWorked() {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		HashMap<Employee , Long> map = new HashMap<>();
		String qstr = "select e, function('timestampdiff', MONTH, e.doj, current_date) from Employee e";
		TypedQuery<Object[]> query = em.createQuery(qstr, Object[].class);
		List<Object[]> list = query.getResultList();
 
      for (Object[] employee : list) {
          Employee c = (Employee) employee[0];
          Long month = (Long) employee[1];
          map.put(c, month);
      }
      for(Map.Entry<Employee, Long> entry : map.entrySet()) {
			System.out.println(entry.getKey().getName() + " total Months " + entry.getValue());
      }
		
		
	}

}
