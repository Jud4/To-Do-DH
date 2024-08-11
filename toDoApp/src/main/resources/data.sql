--TaskStatus
INSERT INTO TASKSTATUS (name, priority) VALUES ('TODO', 1);
INSERT INTO TASKSTATUS (name, priority) VALUES ('In Progress', 2);
INSERT INTO TASKSTATUS (name, priority) VALUES ('Done', 3);

--Tasks
INSERT INTO TASK (title, description, status_id, created_at) VALUES
    ('Create an account', 'Define user and password', 3, NOW()),
    ('Confirm email', 'Check mail and press confirmation button',2, NOW()),
    ('Fill personal info', 'Fill the form in the app',2, NOW()),
    ('Comment a post', 'Select a post in the category and type a comment',1, NOW());