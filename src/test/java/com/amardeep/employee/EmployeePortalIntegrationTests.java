package com.amardeep.employee;

import com.amardeep.employee.entity.Employee;
import com.amardeep.employee.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeePortalIntegrationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenSaveEmployee_thenReturnEmployee() {
        // given
        Employee emp = new Employee();
        emp.setFirstName("Test");
        emp.setLastName("Test");

        // when
        Employee found = employeeRepository.save(emp);

        // then
        assertThat(found.getFirstName())
                .isEqualTo(emp.getFirstName());
    }
}