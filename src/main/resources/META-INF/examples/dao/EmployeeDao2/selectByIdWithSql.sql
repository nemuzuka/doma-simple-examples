SELECT
    id,
    name,
    age,
    salary,
    job_type,
    hiredate,
    department_id,
    version,
    insertTimestamp,
    updateTimestamp,
    attribute
FROM employee e
WHERE
    e.id = /* id */123
