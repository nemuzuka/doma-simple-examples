insert into Employee (
    id,
    name,
    age,
    salary,
    JOB_TYPE,
    hiredate,
    DEPARTMENT_ID,
    VERSION,
    insertTimestamp,
    updateTimestamp,
    attribute
) values (
    /* employee.id */100,
    /* employee.name */'test',
    /* employee.age */50,
    /* employee.salary */300,
    /* employee.jobType */'PRESIDENT',
    /* employee.hiredate */null,
    /* employee.departmentId */null,
    /* employee.version */1,
    /* employee.insertTimestamp */'2020-05-16 10:21:06.21',
    /* employee.updateTimestamp */null,
    /* employee.attribute */'{"customer_code":"C_001","customer_name":"customer_name","age":30}'::json
)
