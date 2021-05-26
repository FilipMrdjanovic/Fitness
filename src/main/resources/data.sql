INSERT INTO TRAINING (name, description, type, duration) VALUES
    ('MASTER ABS', 'HOME WORKOUT FOR ABS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER CHEST', 'HOME WORKOUT FOR CHEST (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER BICEPS', 'HOME WORKOUT FOR BICEPS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER TRICEPS', 'HOME WORKOUT FOR TRICEPS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER LEGS', 'HOME WORKOUT FOR LEGS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45);

INSERT INTO TRAINER (username, first_name, last_name, password, email, birth_date, mobile_number, role, active, grade, fitness_id) VALUES
    ('test1','test','test','test','test1','test','test','test',true, 5, (SELECT ID from FITNESS LIMIT 1)),
    ('test2','test','test','test','test2','test','test','test',true, 5, (SELECT ID from FITNESS LIMIT 1)),
    ('test3','test','test','test','test3','test','test','test',true, 5, (SELECT ID from FITNESS LIMIT 1)),
    ('test4','test','test','test','test4','test','test','test',true, 5, (SELECT ID from FITNESS LIMIT 1)),
    ('test5','test','test','test','test5','test','test','test',true, 5, (SELECT ID from FITNESS LIMIT 1)),
    ('test6','test','test','test','test6','test','test','test',true, 5, (SELECT ID from FITNESS LIMIT 1));

INSERT INTO MEMBER (username, first_name, last_name, password, email, birth_date, mobile_number, role, active) VALUES
    ('test1','test','test','test','test1','test','test','test',true),
    ('test2','test','test','test','test2','test','test','test',true),
    ('test3','test','test','test','test3','test','test','test',true),
    ('test4','test','test','test','test4','test','test','test',true),
    ('test5','test','test','test','test5','test','test','test',true),
    ('test6','test','test','test','test6','test','test','test',true);

INSERT INTO FITNESS (name, address, central_number, email) VALUES
    ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com'),
    ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com'),
    ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com'),
    ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com'),
    ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com'),
    ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com');

INSERT INTO GRADE(grade, appointment_id, member_id) VALUES
    (5, (SELECT ID from APPOINTMENT LIMIT 1), (SELECT ID from MEMBER LIMIT 1)),
    (4, (SELECT ID from APPOINTMENT LIMIT 1), (SELECT ID from MEMBER LIMIT 1)),
    (5, (SELECT ID from APPOINTMENT LIMIT 1), (SELECT ID from MEMBER LIMIT 1));

INSERT INTO APPOINTMENT(date, price, hall_id, trainer_id, training_id) VALUES
    ('2014-12-05T03:58:46 -01:00', 1500, (SELECT ID from HALL LIMIT 1), (SELECT ID from TRAINER LIMIT 1), (SELECT ID from TRAINING LIMIT 1));

INSERT INTO ASSIGNED(member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1), (SELECT ID from APPOINTMENT LIMIT 1));

INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1), (SELECT ID from APPOINTMENT LIMIT 1));

INSERT INTO HALL (capacity, fitness_id) VALUES (50, 1), (60, 4), (50, 3), (50, 1), (50, 2);


