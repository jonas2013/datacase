package org.datacase.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.datacase.model.Department;
import org.datacase.model.Employee;
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
        departmentDao.findAll(qDepartment.name.eq("IT"));
    }

    @Test
    // Querydsl
    public void findDepartmentByDsl() {
        QDepartment qDepartment = QDepartment.department;
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Department> persons = queryFactory.selectFrom(qDepartment)
                .where(qDepartment.name.eq("IT"))
                .fetch();
    }
//    https://github.com/leelance/spring-boot-all/tree/master/spring-boot-jpa-querydsl
//https://www.v2ex.com/t/350737
//    http://blog.csdn.net/ro_wsy/article/details/51345875
    @Test
    // Querydsl
    public void findEmployeeByDsl() {
        QEmployee qEmployee = QEmployee.employee;
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Employee> employee = queryFactory.selectFrom(qEmployee)
                .where(qEmployee.name.eq("IBM"))
                .fetch();
    }


    @Test
    public void findByLeftJoin() {
        //动态条件
        QDepartment department = QDepartment.department;
        QEmployee employee = QEmployee.employee;
        Predicate predicate = department.name.eq("IT");
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        JPAQuery<Tuple> jpaQuery = queryFactory.select(department.id,employee.name)
                .from(department)
                .leftJoin(department.employees,employee);
//                .on(employee.department.id.longValue().eq(department.id.longValue()));
        jpaQuery.where(predicate);
        jpaQuery.fetch();
    }
}
//https://github.com/querydsl/querydsl/issues/1746
//https://github.com/querydsl/querydsl/tree/master/querydsl-examples/querydsl-example-jpa-guice/src/main/java/com/querydsl/example/jpa/model
//https://bitbucket.org/atlassian/querydsl-examples
//http://blog.csdn.net/ro_wsy/article/details/51345875