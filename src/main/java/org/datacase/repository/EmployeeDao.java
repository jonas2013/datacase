package org.datacase.repository;

import org.datacase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月11日
 * @Version v1.0
 */
public interface EmployeeDao extends JpaRepository<Employee, Long>, QueryDslPredicateExecutor<Employee> {
}
