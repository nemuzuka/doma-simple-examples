package examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import examples.dao.EmployeeDao;
import examples.dao.EmployeeDao2;
import examples.dao.EmployeeDao2Impl;
import examples.dao.EmployeeDaoImpl;
import examples.domain.Age;
import examples.domain.Attribute;
import examples.domain.Salary;
import examples.entity.Employee;
import examples.entity.JobType;
import java.sql.Timestamp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestEnvironment.class)
public class InsertTest {

  private final DbConfig config;
  private final EmployeeDao dao;
  private final EmployeeDao2 dao2;

  InsertTest(DbConfig config) {
    this.config = config;
    dao = new EmployeeDaoImpl(config);
    dao2 = new EmployeeDao2Impl(config);
  }

  @Test
  public void test() throws JsonProcessingException {
      var attribute = new Attribute("C_001", "customer_name", 30);
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(attribute);
      System.out.println(json);
      var actual = objectMapper.readValue(json, Attribute.class);
      System.out.println(actual);
  }

  @Test
  public void testInsert() {
    var tm = config.getTransactionManager();

    tm.required(
        () -> {
          var employee = new Employee();
          employee.setId(12345678);
          employee.setName("test");
          employee.setAge(new Age(50));
          employee.setSalary(new Salary(300));
          employee.setJobType(JobType.PRESIDENT);
          employee.setVersion(1);

          var attribute = new Attribute("C_001", "customer_name", 30);
          employee.setAttribute(attribute);

          dao2.insertWithSqlFile(employee);

          var actual = dao2.selectByIdWithSql(employee.getId());
          System.out.println(actual);
        });
  }

  @Test
  public void testInsertByNativeSql() {
    var tm = config.getTransactionManager();

    tm.required(
        () -> {
          var employee = new Employee();
          employee.setId(100);
          employee.setName("test");
          employee.setAge(new Age(50));
          employee.setSalary(new Salary(300));
          employee.setJobType(JobType.PRESIDENT);
          employee.setInsertTimestamp(new Timestamp(System.currentTimeMillis()));
          employee.setVersion(1);
          dao.insertByNativeSql(employee);
        });
  }
}
