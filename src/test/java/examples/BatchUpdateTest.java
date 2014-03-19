package examples;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;

import examples.AppConfig;
import examples.dao.EmployeeDao;
import examples.dao.EmployeeDaoImpl;
import examples.domain.Salary;
import examples.entity.Employee;

public class BatchUpdateTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testBatchUpdate() throws Exception {
        LocalTransactionManager tx = AppConfig.singleton()
                .getLocalTransactionManager();

        tx.required(() -> {
            List<Employee> list = dao.selectAll();
            for (Employee employee : list) {
                Salary salary = employee.getSalary();
                if (salary != null) {
                    employee.setSalary(salary.add(new Salary(100)));
                }
            }
            dao.batchUpdate(list);
        });
    }
}