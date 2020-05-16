package examples.dao;

import examples.entity.Employee;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Sql;

import java.util.Optional;

@Dao
public interface EmployeeDao2 {

    @Select
    Optional<Employee> selectByIdWithSql(Integer id);

    @Insert(sqlFile = true)
    int insertWithSqlFile(Employee employee);
}
