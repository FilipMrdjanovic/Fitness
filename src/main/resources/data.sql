INSERT INTO COMPANY (name, address) VALUES ('FTN', 'Trg Dositeja Obradovića 6');

INSERT INTO DEPARTMENT (name, company_id) VALUES ('Menadžment', 1);
INSERT INTO DEPARTMENT (name, company_id) VALUES ('Računarski centar', 1);

INSERT INTO EMPLOYEE (first_name, last_name, birth_date, email, password) VALUES ('Aleksandar', 'Aleksić', '2000-10-12', 'nesto@gmail.com', '123');
INSERT INTO EMPLOYEE (first_name, last_name, birth_date, email, password) VALUES ('Milica', 'Milić', '2000-10-12', 'nesto@gmail.com', '123');
INSERT INTO EMPLOYEE (first_name, last_name, birth_date, email, password) VALUES ('Slavica', 'Slavić', '2000-10-12', 'nesto@gmail.com', '123');

INSERT INTO PROJECT (name, deadline) VALUES ('Biću student FTN', '2019-02-10');
INSERT INTO PROJECT (name, deadline) VALUES ('Podizanje sistema', '2019-05-1');

INSERT INTO WORKING (project_id, employee_id) VALUES (1, 1);
INSERT INTO WORKING (project_id, employee_id) VALUES (1, 2);
INSERT INTO WORKING (project_id, employee_id) VALUES (2, 3);
