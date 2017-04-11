package org.datacase.repository;

import org.datacase.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月11日
 * @Version v1.0
 */
public interface DepartmentDao extends JpaRepository<Department, Long>, QueryDslPredicateExecutor<Department> {
}
