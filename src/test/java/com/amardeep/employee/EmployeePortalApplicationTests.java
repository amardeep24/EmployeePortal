package com.amardeep.employee;

import com.amardeep.employee.entity.Employee;
import com.amardeep.employee.repository.EmployeeRepository;
import com.amardeep.employee.service.EmployeeService;
import com.amardeep.employee.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmployeePortalApplicationTests {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() {
		Employee empOne = new Employee();
		empOne.setFirstName("Test1");

		Employee empTwo = new Employee();
		empTwo.setFirstName("Test2");

		List<Employee> empList = new ArrayList<>(Arrays.asList(empOne, empTwo));


		Mockito.when(employeeRepository.findAll())
				.thenReturn(empList);
	}

	@Test
	public void testFindAllEmployees() {
		List<Employee> found = employeeService.getAllEmployees();

		IntStream.range(0, 2).forEach(idx -> {
			assertThat(found.get(idx).getFirstName()).isEqualTo("Test"+(idx+1));
		});

	}
}
