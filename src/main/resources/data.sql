INSERT IGNORE INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT IGNORE INTO roles (name) VALUES ('ROLE_USER');

-- Логин: admin  Пароль: admin  (захэширован BCrypt)
INSERT IGNORE INTO users (id, username, password) VALUES (1, 'admin', '$2a$10$7EqJtq98hPqEX7fNZaFWoOa.lQHpOJHpHNRMFBSBMY4TqKMoSJ7Jm');

INSERT IGNORE INTO users_roles (user_id, role_id) VALUES (1, 1);