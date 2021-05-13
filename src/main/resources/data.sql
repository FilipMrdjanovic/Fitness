INSERT INTO TRAINING (name, description, type, duration) VALUES
    ('MASTER ABS', 'HOME WORKOUT FOR ABS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER CHEST', 'HOME WORKOUT FOR CHEST (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER BICEPS', 'HOME WORKOUT FOR BICEPS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER TRICEPS', 'HOME WORKOUT FOR TRICEPS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45),
    ('MASTER LEGS', 'HOME WORKOUT FOR LEGS (6 EXERCISES X 3 SETS)', 'ENDURANCE', 45);

INSERT INTO trainer (username, first_name, last_name, password, email, birth_date, mobile_number, role, active, training, rating) VALUES
    ('test','test','test','test','test','test','test','test',true,1,1),
    ('test','test','test','test','test','test','test','test',true,1,1),
    ('test','test','test','test','test','test','test','test',true,1,1),
    ('test','test','test','test','test','test','test','test',true,1,1),
    ('test','test','test','test','test','test','test','test',true,1,1);

INSERT INTO MEMBER (username, first_name, last_name, password, email, birth_date, mobile_number, role, active, completed_training, signed_training, rated_training) VALUES
    ('test','test','test','test','test','test','test','test',true, 1, 1, 1),
    ('test','test','test','test','test','test','test','test',true, 1, 1, 1),
    ('test','test','test','test','test','test','test','test',true, 1, 1, 1),
    ('test','test','test','test','test','test','test','test',true, 1, 1, 1),
    ('test','test','test','test','test','test','test','test',true, 1, 1, 1),
    ('test','test','test','test','test','test','test','test',true, 1, 1, 1);

INSERT INTO FITNESS (name, address, central_number, email, trainers, halls) VALUES ('FITNESS CENTRE', 'Bulevar Oslobodjenja 1', '0123456879', 'fitness.centre@centre.com', 1, 1);

INSERT INTO FITNESS_TIMETABLE (training_id, price_id) VALUES (1, 1);

INSERT INTO HALL (capacity) VALUES (50),(54),(60),(30),(45),(75),(78),(24);

INSERT INTO HALL_TIMETABLE (training_id, price_id) VALUES (1, 1);
