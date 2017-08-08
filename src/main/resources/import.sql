INSERT INTO company (id_company, name) VALUES (1 ,'CMC');
INSERT INTO company (id_company, name) VALUES (2,'SZZ');
INSERT INTO company (id_company, name) VALUES (3 ,'NFC');
INSERT INTO company (id_company, name) VALUES (4 ,'PLC');

INSERT INTO material_details (id, colour, weight, price) VALUES (1 ,'red', 2, 100);
INSERT INTO material_details (id, colour, weight, price) VALUES (2 ,'silver', 5, 200);
INSERT INTO material_details (id, colour, weight, price) VALUES (3 ,'black', 10, 100);
INSERT INTO material_details (id, colour, weight, price) VALUES (4 ,'silver', 3, 500);
INSERT INTO material_details (id, colour, weight, price) VALUES (5 ,'brown', 2, 100);
INSERT INTO material_details (id, colour, weight, price) VALUES (6 ,'brown', 2, 200);
INSERT INTO material_details (id, colour, weight, price) VALUES (7 ,'brown', 2, 300);
INSERT INTO material_details (id, colour, weight, price) VALUES (8 ,'brown', 2, 250);
INSERT INTO material_details (id, colour, weight, price) VALUES (9 ,'silver', 2, 180);
INSERT INTO material_details (id, colour, weight, price) VALUES (10 ,'black', 2, 145);
INSERT INTO material_details (id, colour, weight, price) VALUES (11 ,'gold', 2, 1000);
INSERT INTO material_details (id, colour, weight, price) VALUES (12 ,'silver', 2, 340);
INSERT INTO material_details (id, colour, weight, price) VALUES (13 ,'black', 2, 322);
INSERT INTO material_details (id, colour, weight, price) VALUES (14 ,'brown', 2, 50);
INSERT INTO material_details (id, colour, weight, price) VALUES (15 ,'black', 2, 150);
INSERT INTO material_details (id, colour, weight, price) VALUES (16 ,'brown', 2, 100);


INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (1 ,'Copper',1 , 1);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (2 ,'Iron',2 , 1);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (3 ,'Led',3 , 1);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (4 ,'Silver', 4, 1);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (5 ,'Pine', 5, 2);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (6 ,'Alder',6 , 2);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (7 ,'Oak', 7, 2);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (8 ,'Maple',8 , 2);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (9 ,'Iron',9, 3);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (10 ,'Carbon',10 , 3);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (11 ,'Gold', 11, 3);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (12 ,'Silver',12 , 3);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (13 ,'Coal', 13, 4);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (14 ,'Wood', 14, 4);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (15 ,'Coke', 15, 4);
INSERT INTO material (id_material, name, material_details_id, company_id) VALUES (16 ,'Peat', 16, 4);

INSERT INTO users (id, login, username, email, password) VALUES (1 ,'testowy', 'Andrzej', '', 'test');
INSERT INTO users (id, login, username, email, password) VALUES (2 ,'admin', 'Administrator', 'admin@wp.pl', 'admin');
