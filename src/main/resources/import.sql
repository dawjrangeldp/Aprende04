INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_EMPLEADO');

INSERT INTO users (username, password, email) VALUES ('us01','$2a$10$B8TV/DdpK1Mfc8uy09q6F.HfBj.2yS922R/NF9ucpDso.0yq1wU6G', 'pepito1@iescastelar.com');
INSERT INTO users (username, password, email) VALUES ('us02','$2a$10$B8TV/DdpK1Mfc8uy09q6F.HfBj.2yS922R/NF9ucpDso.0yq1wU6G', 'pepito2@iescastelar.com');
INSERT INTO users (username, password, email) VALUES ('us03','$2a$10$B8TV/DdpK1Mfc8uy09q6F.HfBj.2yS922R/NF9ucpDso.0yq1wU6G', 'pepito3@iescastelar.com');

INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (1,2);
INSERT INTO user_roles (user_id,role_id) VALUES (2,1);
INSERT INTO user_roles (user_id,role_id) VALUES (3,1);

