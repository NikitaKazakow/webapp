INSERT INTO "user" VALUES ('admin', '$2a$10$jKi/.IFHuBCx7HDtLUBiqOFdwshYRnbcWzRMJxQOJAwzRrfRJ5lvG');

INSERT INTO client VALUES ('1234567890', 'Иванов Иван Иванович', 'г. Самара, Московское шоссе,  д. 25', '89271234567');

INSERT INTO car VALUES (1, 'Белый', 'Япония', 'Mitsubishi', 'Lancer X', 'Базовая', 2010);

INSERT INTO specification VALUES (nextval('seq_specification'), 'Хэтчбэк', 5, 'Полный', 4, 144, 'Бензиновый', 'МКПП');
INSERT INTO specification VALUES (nextval('seq_specification'), 'Хэтчбэк', 5, 'передний', 4, 105, 'Бензиновый', 'МКПП');

INSERT INTO complectation VALUES (1, 'Спорт', 1250000, 1);
INSERT INTO complectation VALUES (1, 'Базовая', 750000, 2)