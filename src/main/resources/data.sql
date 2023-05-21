INSERT INTO tbl_type_region (ds_type, st_active) VALUES
                                                     ('Norte', true),
                                                     ('Nordeste', true),
                                                     ('Centro-Oeste', true),
                                                     ('Sudeste', true),
                                                     ('Sul', true);


INSERT INTO tbl_type_location (ds_type, st_active) VALUES
                                                                     ('Especial', true),
                                                                     ('Normal', true),
                                                                     ('Trabalhoso', true);

INSERT INTO tbl_type_state (ds_abbreviation, ds_type, st_active) VALUES
                                                                     ('AC', 'Acre', true),
                                                                     ('AL', 'Alagoas', true),
                                                                     ('AP', 'Amapa', true),
                                                                     ('AM', 'Amazonas', true),
                                                                     ('BA', 'Bahia', true),
                                                                     ('CE', 'Ceara', true),
                                                                     ('DF', 'Distrito Federal', true),
                                                                     ('ES', 'Esporito Santo', true),
                                                                     ('GO', 'Goias', true),
                                                                     ('MA', 'Maranhao', true),
                                                                     ('MT', 'Mato Grosso', true),
                                                                     ('MS', 'Mato Grosso do Sul', true),
                                                                     ('MG', 'Minas Gerais', true),
                                                                     ('PA', 'Para', true),
                                                                     ('PB', 'Paraiba', true),
                                                                     ('PR', 'Parana', true),
                                                                     ('PE', 'Pernambuco', true),
                                                                     ('PI', 'Piaui', true),
                                                                     ('RJ', 'Rio de Janeiro', true),
                                                                     ('RN', 'Rio Grande do Norte', true),
                                                                     ('RS', 'Rio Grande do Sul', true),
                                                                     ('RO', 'Rondonia', true),
                                                                     ('RR', 'Roraima', true),
                                                                     ('SC', 'Santa Catarina', true),
                                                                     ('SP', 'Sao Paulo', true),
                                                                     ('SE', 'Sergipe', true),
                                                                     ('TO', 'Tocantins', true);

INSERT INTO tbl_type_phone_number (ds_type, st_active) VALUES
                                                           ('Movel', true),
                                                           ('Casa', true),
                                                           ('Trabalho', true),
                                                           ('Outro', true);

INSERT INTO tbl_type_gender (ds_type, st_active) VALUES
                                                     ('M', true),
                                                     ('F', true),
                                                     ('Nao Declarado', true);

INSERT INTO tbl_type_timezone (ds_timezone_offset, ds_timezone_description, st_active) VALUES
                                                                                            ('-3:00', 'Brazil Time (BRT)', true),
                                                                                            ('-12:00', 'Baker Island Time (BIT)', true),
                                                                                            ('-11:00', 'Niue Time (NUT)', true),
                                                                                            ('-10:00', 'Hawaii-Aleutian Standard Time (HAST)', true),
                                                                                            ('-9:00', 'Alaska Standard Time (AKST)', true),
                                                                                            ('-8:00', 'Pacific Standard Time (PST)', true),
                                                                                            ('-7:00', 'Mountain Standard Time (MST)', true),
                                                                                            ('-6:00', 'Central Standard Time (CST)', true),
                                                                                            ('-5:00', 'Eastern Standard Time (EST)', true),
                                                                                            ('-4:00', 'Atlantic Standard Time (AST)', true),
                                                                                            ('-3:00', 'Argentina Time (ART)', true),
                                                                                            ('-2:00', 'South Georgia and South Sandwich Islands Time (GST)', true),
                                                                                            ('-1:00', 'Cape Verde Time (CVT)', true),
                                                                                            ('0:00', 'Greenwich Mean Time (GMT)', true),
                                                                                            ('1:00', 'Central European Time (CET)', true),
                                                                                            ('2:00', 'Eastern European Time (EET)', true),
                                                                                            ('3:00', 'Moscow Standard Time (MSK)', true),
                                                                                            ('4:00', 'Gulf Standard Time (GST)', true),
                                                                                            ('5:00', 'Pakistan Standard Time (PKT)', true),
                                                                                            ('5:30', 'Indian Standard Time (IST)', true),
                                                                                            ('6:00', 'Bangladesh Standard Time (BST)', true),
                                                                                            ('7:00', 'Indochina Time (ICT)', true),
                                                                                            ('8:00', 'China Standard Time (CST)', true),
                                                                                            ('9:00', 'Japan Standard Time (JST)', true),
                                                                                            ('10:00', 'Australian Eastern Standard Time (AEST)', true),
                                                                                            ('11:00', 'Vanuatu Standard Time (VUT)', true),
                                                                                            ('12:00', 'New Zealand Standard Time (NZST)', true);

INSERT INTO tbl_type_nationality (ds_abbreviation, ds_type, st_active) VALUES
                                                                           ('BR', 'Brazil', true),
                                                                           ('AR', 'Argentina', true),
                                                                           ('AU', 'Australia', true),
                                                                           ('CA', 'Canada', true),
                                                                           ('CN', 'China', true),
                                                                           ('DE', 'Germany', true),
                                                                           ('EG', 'Egypt', true),
                                                                           ('ES', 'Spain', true),
                                                                           ('FR', 'France', true),
                                                                           ('GB', 'United Kingdom', true),
                                                                           ('ID', 'Indonesia', true),
                                                                           ('IL', 'Israel', true),
                                                                           ('IN', 'India', true),
                                                                           ('IT', 'Italy', true),
                                                                           ('JP', 'Japan', true),
                                                                           ('KE', 'Kenya', true),
                                                                           ('MX', 'Mexico', true),
                                                                           ('NG', 'Nigeria', true),
                                                                           ('NO', 'Norway', true),
                                                                           ('NZ', 'New Zealand', true),
                                                                           ('RU', 'Russia', true),
                                                                           ('SE', 'Sweden', true),
                                                                           ('SG', 'Singapore', true),
                                                                           ('US', 'United States', true),
                                                                           ('ZA', 'South Africa', true);


INSERT INTO tbl_user (
    id_type_gender, ds_title, ds_first_name, ds_last_name, id_location_type, id_region_type, ds_street, ds_city,
    id_type_state, ds_postcode, ds_latitude, ds_longitude, id_type_timezone, ds_email, dt_birthday, dt_registered,
    id_type_nationality, st_active
) VALUES
      (1, 'mr', 'Joselino', 'Alves', 1, 1, 'Rua Espirito Santo 2095', 'Sao Jose de Ribamar', 16, '96895000', -35.868700, -131.880100, 1, 'joselino@gmail.com', '1996-01-09', '2014-02-09', 1, true),
      (1, 'mr', 'Antonelo', 'da Conceicao', 2, 2, 'Rua Rui Barbosa 8986', 'Santo Andre', 2, '40751000', -69.870400, -165.954500, 1, 'antonelo@email.com', '1956-02-12', '2005-12-05', 1, true),
      (1, 'mr', 'João', 'Silva', 1, 1, 'Rua das Flores 100', 'Rio de Janeiro', 18, '20010020', -22.908333, -43.196388, 1, 'joao.silva@gmail.com', '1990-02-15', '2015-03-20', 1, true),
      (2, 'ms', 'Maria', 'Santos', 2, 2, 'Avenida Paulista 200', 'São Paulo', 25, '01311000', -23.550520, -46.633308, 1, 'maria.santos@gmail.com', '1985-08-10', '2016-09-05', 1, true),
      (1, 'mr', 'José', 'Pereira', 3, 3, 'Rua das Pedras 300', 'Belo Horizonte', 11, '30190010', -19.917599, -43.934093, 1, 'jose.pereira@gmail.com', '1975-12-05', '2017-11-01', 1, true),
      (2, 'ms', 'Ana', 'Carvalho', 2, 4, 'Avenida Beira Mar 400', 'Florianópolis', 24, '88015200', -27.597300, -48.549610, 1, 'ana.carvalho@gmail.com', '1982-06-30', '2018-01-15', 1, true),
      (1, 'mr', 'Antônio', 'Oliveira', 1, 5, 'Rua da Praia 500', 'Porto Alegre', 21, '90010030', -30.032499, -51.230377, 1, 'antonio.oliveira@gmail.com', '1995-10-20', '2019-05-10', 1, true),
      (2, 'ms', 'Francisca', 'Lima', 3, 3, 'Praça da República 600', 'Salvador', 5, '40050010', -12.977749, -38.501630, 1, 'francisca.lima@gmail.com', '1960-05-15', '2020-07-01', 1, true),
      (1, 'mr', 'Raimundo', 'Barbosa', 2, 2, 'Rua do Ouro 700', 'Recife', 17, '50010010', -8.052240, -34.928610, 1, 'raimundo.barbosa@gmail.com', '1970-01-30', '2021-08-20', 1, true),
      (1, 'mr', 'Pedro', 'Costa', 2, 4, 'Rua das Palmeiras 900', 'Fortaleza', 6, '60060010', -3.730451, -38.521799, 1, 'pedro.costa@gmail.com', '1988-03-05', '2013-02-25', 1, true),
      (2, 'ms', 'Laura', 'Mendes', 1, 5, 'Praça da Estação 1000', 'Natal', 20, '59010010', -5.793570, -35.198999, 1, 'laura.mendes@gmail.com', '1997-09-30', '2014-10-15', 1, true),
      (1, 'mr', 'Rafael', 'Barros', 3, 3, 'Avenida das Américas 1100', 'Manaus', 4, '69010010', -3.131633, -59.999039, 1, 'rafael.barros@gmail.com', '1978-07-25', '2015-12-10', 1, true),
      (2, 'ms', 'Márcia', 'Cardoso', 2, 2, 'Rua do Mercado 1200', 'Goiânia', 9, '74010010', -16.686891, -49.264794, 1, 'marcia.cardoso@gmail.com', '1981-11-20', '2017-01-05', 1, true),
      (1, 'mr', 'Gustavo', 'Cavalcante', 1, 1, 'Avenida da Liberdade 1300', 'Teresina', 19, '64000010', -5.089640, -42.809588, 1, 'gustavo.cavalcante@gmail.com', '1993-06-15', '2018-03-25', 1, true),
      (2, 'ms', 'Renata', 'Fonseca', 3, 4, 'Rua do Imperador 1400', 'Belém', 14, '66010010', -1.459649, -48.492245, 1, 'renata.fonseca@gmail.com', '1965-05-30', '2019-06-15', 1, true),
      (1, 'mr', 'André', 'Castro', 2, 5, 'Praça da Sé 1500', 'Campo Grande', 12, '79010010', -20.469710, -54.620121, 1, 'andre.castro@gmail.com', '1972-12-10', '2020-08-30', 1, true),
      (2, 'ms', 'Beatriz', 'Viana', 1, 1, 'Rua do Bosque 1600', 'Aracaju', 26, '49010010', -10.947267, -37.073082, 1, 'beatriz.viana@gmail.com', '1998-08-25', '2021-11-15', 1, true);



INSERT INTO tbl_phone_number (id_user, ds_phone_number, id_phone_number_type, st_active) VALUES
                                                                                             (1, '+551123456789', 1, true),
                                                                                             (2, '+558587478125', 2, true),
                                                                                             (2, '+558724140993', 1, true);

INSERT INTO tbl_picture (id_user, ds_large_url, ds_medium_url, ds_thumbnail_url, st_active) VALUES
                                                                                                (1, 'https://randomuser.me/api/portraits/men/1.jpg', 'https://randomuser.me/api/portraits/med/men/1.jpg', 'https://randomuser.me/api/portraits/thumb/men/1.jpg', true),
                                                                                                (2, 'https://randomuser.me/api/portraits/men/2.jpg', 'https://randomuser.me/api/portraits/med/men/2.jpg', 'https://randomuser.me/api/portraits/thumb/men/2.jpg', true),
                                                                                                (3, 'https://randomuser.me/api/portraits/men/3.jpg', 'https://randomuser.me/api/portraits/med/men/3.jpg', 'https://randomuser.me/api/portraits/thumb/men/3.jpg', true),
                                                                                                (4, 'https://randomuser.me/api/portraits/women/4.jpg', 'https://randomuser.me/api/portraits/med/women/4.jpg', 'https://randomuser.me/api/portraits/thumb/women/4.jpg', true),
                                                                                                (5, 'https://randomuser.me/api/portraits/men/5.jpg', 'https://randomuser.me/api/portraits/med/men/5.jpg', 'https://randomuser.me/api/portraits/thumb/men/5.jpg', true),
                                                                                                (6, 'https://randomuser.me/api/portraits/women/6.jpg', 'https://randomuser.me/api/portraits/med/women/6.jpg', 'https://randomuser.me/api/portraits/thumb/women/6.jpg', true),
                                                                                                (7, 'https://randomuser.me/api/portraits/men/7.jpg', 'https://randomuser.me/api/portraits/med/men/7.jpg', 'https://randomuser.me/api/portraits/thumb/men/7.jpg', true),
                                                                                                (8, 'https://randomuser.me/api/portraits/women/8.jpg', 'https://randomuser.me/api/portraits/med/women/8.jpg', 'https://randomuser.me/api/portraits/thumb/women/8.jpg', true),
                                                                                                (9, 'https://randomuser.me/api/portraits/men/9.jpg', 'https://randomuser.me/api/portraits/med/men/9.jpg', 'https://randomuser.me/api/portraits/thumb/men/9.jpg', true),
                                                                                                (10, 'https://randomuser.me/api/portraits/men/10.jpg', 'https://randomuser.me/api/portraits/med/men/10.jpg', 'https://randomuser.me/api/portraits/thumb/men/10.jpg', true),
                                                                                                (11, 'https://randomuser.me/api/portraits/women/11.jpg', 'https://randomuser.me/api/portraits/med/women/11.jpg', 'https://randomuser.me/api/portraits/thumb/women/11.jpg', true),
                                                                                                (12, 'https://randomuser.me/api/portraits/men/12.jpg', 'https://randomuser.me/api/portraits/med/men/12.jpg', 'https://randomuser.me/api/portraits/thumb/men/12.jpg', true),
                                                                                                (13, 'https://randomuser.me/api/portraits/women/13.jpg', 'https://randomuser.me/api/portraits/med/women/13.jpg', 'https://randomuser.me/api/portraits/thumb/women/13.jpg', true),
                                                                                                (14, 'https://randomuser.me/api/portraits/men/14.jpg', 'https://randomuser.me/api/portraits/med/men/14.jpg', 'https://randomuser.me/api/portraits/thumb/men/14.jpg', true),
                                                                                                (15, 'https://randomuser.me/api/portraits/women/15.jpg', 'https://randomuser.me/api/portraits/med/women/15.jpg', 'https://randomuser.me/api/portraits/thumb/women/15.jpg', true),
                                                                                                (16, 'https://randomuser.me/api/portraits/men/16.jpg', 'https://randomuser.me/api/portraits/med/men/16.jpg', 'https://randomuser.me/api/portraits/thumb/men/16.jpg', true),
                                                                                                (17, 'https://randomuser.me/api/portraits/women/17.jpg', 'https://randomuser.me/api/portraits/med/women/18.jpg', 'https://randomuser.me/api/portraits/thumb/women/18.jpg', true);

INSERT INTO tbl_type_login (ds_type, st_active) VALUES
                                                    ('Regular', true),
                                                    ('Admin', true);



INSERT INTO tbl_login (ds_username, ds_password, id_type_login, id_user, st_active) VALUES
                                                                                        ('admin', '$2a$10$2.P3Sj9JMG5pHGJYZAKA.eMX97aUcQwMWRNX9Puo1k2YBQuY0BvKS', 1, NULL, true),
                                                                                        ('marketing', '$2a$10$2.P3Sj9JMG5pHGJYZAKA.eMX97aUcQwMWRNX9Puo1k2YBQuY0BvKS', 1, NULL, true),
                                                                                        ('miguel@email.com', '$2a$10$WXfQsblcdtTpL/dndZUC9.NUXDk6bvOTpCr33N7E2/cB/U83RTfvu', 2, 1, true),
                                                                                        ('helena@email.com', '$2a$10$WXfQsblcdtTpL/dndZUC9.NUXDk6bvOTpCr33N7E2/cB/U83RTfvu', 2, 2, true);
