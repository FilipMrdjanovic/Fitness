INSERT INTO COMPANY (name, address) VALUES ('FTN', 'Trg Dositeja Obradovića 6');

INSERT INTO DEPARTMENT (name, company_id) VALUES ('Menadžment', 1);
INSERT INTO DEPARTMENT (name, company_id) VALUES ('Računarski centar', 1);

INSERT INTO EMPLOYEE (username, first_name, last_name, email, password, mobile_number, birth_date, position) VALUES ('admin', 'Tdmin', 'admin', 'admin@admin.admin', 'admin', '000000000', '00-00-00', 'Administrator');
INSERT INTO EMPLOYEE (username, first_name, last_name, email, password, mobile_number, birth_date, position) VALUES ('trainer', 'trainer', 'trainer', 'trainer@trainer.trainer', 'trainer', '000000000', '00-00-00', 'Trainer');
INSERT INTO EMPLOYEE (username, first_name, last_name, email, password, mobile_number, birth_date, position) VALUES ('user', 'user', 'user', 'user@user.user', 'user', '000000000', '00-00-00', 'User');


INSERT INTO PROJECT (name, deadline) VALUES ('Biću student FTN', '2019-02-10');
INSERT INTO PROJECT (name, deadline) VALUES ('Podizanje sistema', '2019-05-1');

INSERT INTO WORKING (project_id, employee_id) VALUES (1, 1);
INSERT INTO WORKING (project_id, employee_id) VALUES (1, 2);
INSERT INTO WORKING (project_id, employee_id) VALUES (2, 3);
