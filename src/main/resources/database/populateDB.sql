INSERT INTO manager (id, surname, name, patronymic, phone_number, deputy_id) VALUES
(1, 'Surname1', 'Name1', 'Patronymic1', '111-11-11', null),
(2, 'Surname2', 'Name2', 'Patronymic2', '222-22-22', 1);

INSERT INTO client (id, name, address, manager_id) VALUES
(3, 'Company number 1', 'address1', 1),
(4, 'Company number 2', 'address2', 1),
(5, 'Company number 3', 'address3', 2);