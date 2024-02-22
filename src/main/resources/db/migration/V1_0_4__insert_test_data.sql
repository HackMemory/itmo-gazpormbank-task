INSERT INTO Company (name) VALUES
('Company A'),
('Company B'),
('Company C');

INSERT INTO Department (name, company_id) VALUES
('Department X', 1),
('Department Y', 1),
('Department Z', 2),
('Department W', 3);

INSERT INTO Employee (name, department_id) VALUES
('John Doe', 1),
('Alice Smith', 1),
('Bob Johnson', 2),
('Emily Brown', 3);


INSERT INTO Server (name, manufacturer, ipv4_address, ram, storage, responsible_employee_id) VALUES
('Server 1', 'Manufacturer A', '192.168.0.1', 16.0, 512.0, 1),
('Server 2', 'Manufacturer B', '192.168.0.2', 32.0, 1024.0, 2),
('Server 3', 'Manufacturer C', '192.168.0.3', 64.0, 2048.0, 3);