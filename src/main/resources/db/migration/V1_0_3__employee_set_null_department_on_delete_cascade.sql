ALTER TABLE Employee
    DROP CONSTRAINT employee_department_id_fkey;

ALTER TABLE Employee
    ADD CONSTRAINT employee_department_id_fkey
        FOREIGN KEY (department_id) REFERENCES Department(department_id)
            ON DELETE SET NULL;