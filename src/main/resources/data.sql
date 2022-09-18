INSERT INTO usuario (id, password, username) VALUES ('73279bef-94bd-4a64-bd90-f2927388c4d5',
                                                     '$2a$10$fRXYVWjQquryY/.cQ2OwmuenaeyHm2YBUi8WIOD3dyJqtde7bSGBG',
                                                     'Miguel Bada'),
                                                    ('3769d690-5423-4399-bbea-3b15827a72ed',
                                                     '$2a$10$fRXYVWjQquryY/.cQ2OwmuenaeyHm2YBUi8WIOD3dyJqtde7bSGBG',
                                                     'Nancy Nagel');

INSERT INTO rol (id, nombre) VALUES ('db71e070-aa86-4cf2-a19d-7e2bbccd6207', 'ROLE_ADMIN'),
                                    ('9b52ed5d-35e7-4f0e-b0e8-f5eeecb0a1cc', 'ROLE_USER');

INSERT INTO usuario_rol (usuario_id, rol_id) VALUES ('73279bef-94bd-4a64-bd90-f2927388c4d5',
                                                     'db71e070-aa86-4cf2-a19d-7e2bbccd6207'),
                                                    ('3769d690-5423-4399-bbea-3b15827a72ed',
                                                     '9b52ed5d-35e7-4f0e-b0e8-f5eeecb0a1cc');

