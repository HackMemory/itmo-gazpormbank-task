ALTER TABLE Server
    DROP CONSTRAINT server_responsible_employee_id_fkey;

ALTER TABLE Server
    ADD CONSTRAINT server_responsible_employee_id_fkey
        FOREIGN KEY (responsible_employee_id) REFERENCES Employee(employee_id)
            ON DELETE SET NULL;