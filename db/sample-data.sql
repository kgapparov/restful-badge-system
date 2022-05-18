INSERT INTO badgedb.member (id, emailAddress, firstName, lastName) VALUES (1, 'mem@mail.com', 'Joe', 'Student');
INSERT INTO badgedb.member (id, emailAddress, firstName, lastName) VALUES (2, 'gat@mail.com', 'Mer', 'Staff');

INSERT INTO badgedb.member_roles (member_id, roles) VALUES (1, 'STUDENT');
INSERT INTO badgedb.member_roles (member_id, roles) VALUES (2, 'STAFF');
INSERT INTO badgedb.member_roles (member_id, roles) VALUES (2, 'FACULTY');

INSERT INTO badgedb.badge (id, issueDate, isActive, expireDate, member_id) VALUES (1, '2022-05-09', true, '2022-05-23', 1);
INSERT INTO badgedb.badge (id, issueDate, isActive, expireDate, member_id) VALUES (2, '2022-05-02', false, '2022-05-23', 1);
INSERT INTO badgedb.badge (id, issueDate, isActive, expireDate, member_id) VALUES (3, '2022-05-02', true, '2022-05-09', 2);

INSERT INTO badgedb.plan (id, description, name) VALUES (1, '90 times a month', '90x a month');
INSERT INTO badgedb.plan (id, description, name) VALUES (2, '3 times a day for student, staff and faculty', '3x a day');
INSERT INTO badgedb.plan (id, description, name) VALUES (3, '1 time a day for staff and faculty', '1x a day');

INSERT INTO badgedb.plan_allowedlocationtypes (Plan_id, allowedLocationTypes) VALUES (1, 'DINING_HALL');
INSERT INTO badgedb.plan_allowedlocationtypes (Plan_id, allowedLocationTypes) VALUES (1, 'MEDITATION_HALL');
INSERT INTO badgedb.plan_allowedlocationtypes (Plan_id, allowedLocationTypes) VALUES (2, 'FLYING_HALL');
INSERT INTO badgedb.plan_allowedlocationtypes (Plan_id, allowedLocationTypes) VALUES (3, 'CLASSROOM');

INSERT INTO badgedb.plan_allowedroles (Plan_id, allowedRoles) VALUES (1, 'STUDENT');
INSERT INTO badgedb.plan_allowedroles (Plan_id, allowedRoles) VALUES (2, 'STUDENT');
INSERT INTO badgedb.plan_allowedroles (Plan_id, allowedRoles) VALUES (2, 'STAFF');
INSERT INTO badgedb.plan_allowedroles (Plan_id, allowedRoles) VALUES (2, 'FACULTY');
INSERT INTO badgedb.plan_allowedroles (Plan_id, allowedRoles) VALUES (3, 'STAFF');
INSERT INTO badgedb.plan_allowedroles (Plan_id, allowedRoles) VALUES (3, 'FACULTY');

INSERT INTO badgedb.location (id, capacity, description, name, address) VALUES (1, 100, 'Dinning Hall', 'DINNING_HALL', 'Beside the Highway');
INSERT INTO badgedb.location (id, capacity, description, name, address) VALUES (2, 20, 'Recreational center', 'GYMNASIUM', 'Beside the rode');

INSERT INTO badgedb.location_types (Location_id, types) VALUES (1, 'DINING_HALL');
INSERT INTO badgedb.location_types (Location_id, types) VALUES (2, 'GYMNASIUM');

INSERT INTO badgedb.timeslot (id, endTime, startTime) VALUES (1, '08:30:00', '10:00:00');
INSERT INTO badgedb.timeslot (id, endTime, startTime) VALUES (2, '11:30:00', '13:30:00');
INSERT INTO badgedb.timeslot (id, endTime, startTime) VALUES (3, '18:00:00', '19:30:00');
INSERT INTO badgedb.timeslot (id, endTime, startTime) VALUES (4, '07:00:00', '20:30:00');

INSERT INTO badgedb.location_timeslot (Location_id, timeSlots_id) VALUES (1, 1);
INSERT INTO badgedb.location_timeslot (Location_id, timeSlots_id) VALUES (1, 2);
INSERT INTO badgedb.location_timeslot (Location_id, timeSlots_id) VALUES (1, 3);
INSERT INTO badgedb.location_timeslot (Location_id, timeSlots_id) VALUES (2, 4);

INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'TUESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'WEDNESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'THURSDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'FRIDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'SATURDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (1, 'SUNDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'TUESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'WEDNESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'THURSDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'FRIDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'SATURDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (2, 'SUNDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'TUESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'WEDNESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'THURSDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'FRIDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'SATURDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (3, 'SUNDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'TUESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'MONDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'WEDNESDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'THURSDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'FRIDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'SATURDAY');
INSERT INTO badgedb.timeslot_daysofweek (TimeSlot_id, daysOfWeek) VALUES (4, 'SUNDAY');
-- Membership , Transaction
INSERT INTO badgedb.membership (id, endDate, startDate, plan_id, member_Id, membershipType, consumed, membership_limit) VALUES (1, '2022-05-09', '2022-05-02', 1, 1, 'limited', 10, 30);
INSERT INTO badgedb.membership (id, endDate, startDate, plan_id, member_Id, membershipType, consumed, membership_limit) VALUES (2, '2022-05-23', '2022-05-09', 2, 1, 'unlimited', null, null);
INSERT INTO badgedb.membership (id, endDate, startDate, plan_id, member_Id, membershipType, consumed, membership_limit) VALUES (3, '2022-05-23', '2022-05-09', 1, 2, 'checker', null, null);

INSERT INTO badgedb.transaction (id, dateTime, type, member_id, location_id) VALUES (1, '2022-05-17 15:00:00', 'CHECKIN', 1, 1);
INSERT INTO badgedb.transaction (id, dateTime, type, member_id, location_id) VALUES (2, '2022-05-17 16:00:00', 'CHECKIN', 1, 1);
INSERT INTO badgedb.transaction (id, dateTime, type, member_id, location_id) VALUES (3, '2022-05-17 17:00:00', 'CHECKIN', 2, 1);
INSERT INTO badgedb.transaction (id, dateTime, type, member_id, location_id) VALUES (4, '2022-05-17 18:00:00', 'CHECKIN', 2, 2);