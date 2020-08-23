use bug_tracker;
insert into authorities(authority, authority_level)
values ('ROLE_SUBMITTER', 1),
       ('ROLE_DEVELOPER', 2),
       ('ROLE_PROJECT_MANAGER', 3),
       ('ROLE_ADMIN', 4);


insert into users (username, password, registration_date, account_non_locked)
values ('manager1', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('manager2', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('manager3', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer1', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer2', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer3', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer4', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer5', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer6', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer7', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer8', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer9', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer10', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer11', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer12', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer13', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer14', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('developer15', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter1', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter2', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter3', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter4', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter5', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter6', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter7', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter8', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter9', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true),
       ('submitter10', '$2a$10$N84ugQMjD25QvdyIOBWEpeZLAQOwzjFAQdaIGLQkQY.2JGIMr06C6', now(), true);

insert into users_authorities(user_id, authority_id)
VALUES (1, 3),
       (2, 3),
       (3, 3),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2),
       (10, 2),
       (11, 2),
       (12, 2),
       (13, 2),
       (14, 2),
       (15, 2),
       (16, 2),
       (17, 2),
       (18, 2),
       (19, 1),
       (20, 1),
       (21, 1),
       (22, 1),
       (23, 1),
       (24, 1),
       (25, 1),
       (26, 1),
       (27, 1),
       (28, 1);


insert into projects(title, description, creation_date, project_manager_id)
values ('Issue tracker', 'Tracking issues to help with project development', now(), 1),
       ('Finance tracking system project', 'System that tracks your weekly finances and your families', now(), 1),
       ('Spring Security project', 'Securing web applications with the Web Security module', now(), 2),
       ('React website for selling food', 'SPA application to help end users sell their food products, like FoodPanda',
        now(), 2),
       ('Spring Rest + Hibernate ORM project', 'Back end only application that front end only developers can use',
        now(), 3),
       ('For test purposes', 'project for purely test purpose!', now(), 3);

insert into projects_developers (project_id, user_id)
values (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (2, 9),
       (2, 10),
       (2, 11),
       (2, 12),
       (2, 13),
       (2, 14),
       (3, 10),
       (3, 12),
       (3, 15),
       (3, 4),
       (3, 7),
       (4, 15),
       (4, 8),
       (4, 9),
       (4, 10),
       (5, 4),
       (5, 7),
       (5, 6),
       (5, 13),
       (5, 14),
       (3, 8);

insert into tickets(title, description, creation_date, category, priority, status, project_id, submitter_id)
values ('Remember User log in after page refresh', 'after page refreshes user is no longer logged in', now(),
        'FEATURE_REQUEST', 'HIGH', 'NEW', 1, 20),
       ('Assign developer issue', 'assign developers doesnt work', now(), 'BUGS_AND_ERRORS', 'LOW', 'NEW', 1, 19),
       ('Remove developer issue', 'remove developer doesnt work', now(), 'BUGS_AND_ERRORS', 'MEDIUM', 'NEW', 1, 21),
       ('Implement ticket history', 'some description', now(), 'FEATURE_REQUEST', 'HIGH', 'NEW', 1, 22),
       ('Implement website animation', 'Implement animations on componentDidMount();', now(), 'FEATURE_REQUEST', 'HIGH','NEW', 2, 23),
       ('Bug with transactions', 'transactions not working correctly', now(), 'BUGS_AND_ERRORS', 'MEDIUM', 'NEW', 2, 24),
       ('How do i add an account?', 'How do i add an account?', now(), 'OTHER', 'LOW', 'NEW', 2, 25),
       ('Logout URL', 'Redirect people to home page on logout not to login', now(), 'FEATURE_REQUEST', 'MEDIUM', 'NEW',  3, 27),
       ('I cant see my account details', 'it says \'403-forbidden\' when ever i want to see my account page', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 3, 28),
       ('How do i change my authority?', 'how do i become an admin', now(), 'OTHER', 'LOW', 'NEW', 3, 19),
       ('Rout changes', 'Changing routes refreshes the entire page', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 4, 20),
       ('Implement animations', 'Implement animations or componentDidMount()', now(), 'FEATURE_REQUEST', 'MEDIUM', 'NEW', 4, 22),
       ('How do i log out', 'I cant find the logout page', now(), 'OTHER', 'LOW', 'NEW', 4, 21),
       ('New rest endpoint', 'Can you implement a rest endpoint for user details?', now(), 'FEATURE_REQUEST', 'HGH',  'NEW', 5, 28),
       ('I cant logout', 'Logging out doesnt work', now(), 'BUGS_AND_ERRORS', 'MEDIUM', 'NEW', 5, 27),
       ('Demo ticket1', 'Demo ticket1 description for test purposes', now(), 'OTHER', 'LOW', 'NEW', 6, 28),
       ('Demo ticket2', 'Demo ticket2 description for test purposes', now(), 'OTHER', 'LOW', 'NEW', 6, 27),
       ('Demo ticket3', 'Demo ticket3 description for test purposes', now(), 'OTHER', 'LOW', 'NEW', 6, 27),
       ('Demo ticket4', 'Demo ticket4 description for test purposes', now(), 'FEATURE_REQUEST', 'MEDIUM', 'NEW', 6, 27),
       ('Demo ticket5', 'Demo ticket5 description for test purposes', now(), 'FEATURE_REQUEST', 'MEDIUM', 'NEW', 6, 27),
       ('Demo ticket6', 'Demo ticket6 description for test purposes', now(), 'FEATURE_REQUEST', 'MEDIUM', 'NEW', 6, 27),
       ('Demo ticket7', 'Demo ticket7 description for test purposes', now(), 'FEATURE_REQUEST', 'MEDIUM', 'NEW', 6, 27),
       ('Demo ticket8', 'Demo ticket8 description for test purposes', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 6, 27),
       ('Demo ticket9', 'Demo ticket9 description for test purposes', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 6, 27),
       ('Demo ticket10', 'Demo ticket10 description for test purposes', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 6, 27),
       ('Demo ticket11', 'Demo ticket11 description for test purposes', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 6, 27),
       ('Demo ticket12', 'Demo ticket12 description for test purposes', now(), 'BUGS_AND_ERRORS', 'HIGH', 'NEW', 6, 27);

insert into comments(description, creation_date, ticket_id, user_id)
values ('demo ticket1 description', now(), 1, 5),
       ('demo ticket1 description', now(), 1, 5);


