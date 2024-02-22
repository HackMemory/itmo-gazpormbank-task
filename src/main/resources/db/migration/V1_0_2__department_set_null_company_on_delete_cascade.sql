ALTER TABLE Department
    DROP CONSTRAINT department_company_id_fkey;

ALTER TABLE Department
    ADD CONSTRAINT department_company_id_fkey
        FOREIGN KEY (company_id) REFERENCES Company(company_id)
            ON DELETE SET NULL;