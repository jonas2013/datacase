package org.datacase.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.datacase.model.Department;
import org.datacase.model.QDepartment;
import org.datacase.model.QEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月11日
 * @Version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityTest {

    @Autowired
    EntityManager em;
    @Autowired
    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;

    @Test
    //Repository 无缝和 Querydsl 连接
    public void findDepartment() {
        QDepartment qDepartment = QDepartment.department;
        departmentDao.findAll(qDepartment.name.eq("IT部"));
    }

    @Test
    // Querydsl
    public void findDepartmentByDsl() {
        QDepartment qDepartment = QDepartment.department;
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Department> persons = queryFactory.selectFrom(qDepartment)
                .where(qDepartment.name.eq("IT部"))
                .fetch();
    }
//    https://github.com/leelance/spring-boot-all/tree/master/spring-boot-jpa-querydsl

    @Test
    public void findByLeftJoin() {
        //动态条件
        QDepartment qDepartment = QDepartment.department;
        QEmployee qEmployee = QEmployee.employee;
        Predicate predicate = qDepartment.name.eq("IT部");
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        JPAQuery<Tuple> jpaQuery = queryFactory.select(QDepartment.department,QEmployee.employee)
                .from(QDepartment.department)
                .join(QEmployee.employee)
                .on(qEmployee.getType().longValue().eq(qDepartment.id.longValue()));
        jpaQuery.where(predicate);
        jpaQuery.fetch();
    }
}
