INSERT INTO regiones (id, name) VALUES (1,'Sudamérica');
INSERT INTO regiones (id, name) VALUES (2,'Centroamérica');
INSERT INTO regiones (id, name) VALUES (3,'Norteamérica');
INSERT INTO regiones (id, name) VALUES (4,'Europa');
INSERT INTO regiones (id, name) VALUES (5,'Asia');
INSERT INTO regiones (id, name) VALUES (6,'Africa');
INSERT INTO regiones (id, name) VALUES (7,'Oceanía');
INSERT INTO regiones (id, name) VALUES (8,'Antártida');

INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(1, 'Roger', 'Pomacarhua', 'roger@gmail.com', '2018-01-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(2, 'Juan', 'Marquina', 'juan@gmail.com', '2018-02-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(2, 'Pablo', 'Escobar', 'pablo@gmail.com', '2019-03-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(1, 'Roger', 'Pomacarhua', 'roger1@gmail.com', '2018-01-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(3, 'Juan', 'Marquina', 'juan1@gmail.com', '2018-02-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(4, 'Pablo', 'Escobar', 'pablo1@gmail.com', '2019-03-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(5, 'Roger', 'Pomacarhua', 'roge2r@gmail.com', '2018-01-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(5, 'Juan', 'Marquina', 'juan2@gmail.com', '2018-02-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(5, 'Pablo', 'Escobar', 'pablo2@gmail.com', '2019-03-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(6, 'Roger', 'Pomacarhua', 'roger3@gmail.com', '2018-01-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(6, 'Juan', 'Marquina', 'juan3@gmail.com', '2018-02-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(2, 'Pablo', 'Escobar', 'pablo3@gmail.com', '2019-03-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(3, 'Roger', 'Pomacarhua', 'roger4@gmail.com', '2018-01-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(2, 'Juan', 'Marquina', 'juan4@gmail.com', '2018-02-01');
INSERT INTO clients (region_id, name, lastname, email, created_at) VALUES(8, 'Pablo', 'Escobar', 'pablo4@gmail.com', '2019-03-01');

INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('roger','$2a$10$1Iu2pd9eJjOvRQT7ena8JebACtvMzL3HuWbmLhURjBTo7E1zcR6rW',1, 'Roger B', 'Pomacarhua', 'roger.pomacarhua@gmail.com');
INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('admin','$2a$10$yJ5.pvOns/tnZx5.ytjTx.pn5hQJGiXSivPG1P0MSzc9e5gTvq/Xu',1, 'Juan P', 'Gonzalez', 'juan.gonzalez@gmail.com');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1,1);
INSERT INTO users_roles (user_id, role_id) VALUES (2,2);
INSERT INTO users_roles (user_id, role_id) VALUES (2,1);