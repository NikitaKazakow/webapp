INSERT INTO "user" VALUES ('admin', '$2a$10$jKi/.IFHuBCx7HDtLUBiqOFdwshYRnbcWzRMJxQOJAwzRrfRJ5lvG');

INSERT INTO client VALUES ('1234567890', '������ ���� ��������', '�. ������, ���������� �����,  �. 25', '89271234567');

INSERT INTO car VALUES (1, '�����', '������', 'Mitsubishi', 'Lancer X', '�������', 2010);

INSERT INTO specification VALUES (nextval('seq_specification'), '�������', 5, '������', 4, 144, '����������', '����');
INSERT INTO specification VALUES (nextval('seq_specification'), '�������', 5, '��������', 4, 105, '����������', '����');

INSERT INTO complectation VALUES (1, '�����', 1250000, 1);
INSERT INTO complectation VALUES (1, '�������', 750000, 2)