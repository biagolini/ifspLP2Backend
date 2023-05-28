INSERT INTO tbl_type_region (ds_type, st_active) VALUES
                                                     ('Norte', true),
                                                     ('Nordeste', true),
                                                     ('Centro-Oeste', true),
                                                     ('Sudeste', true),
                                                     ('Sul', true),
                                                     ('Nao declarado', true);

INSERT INTO tbl_type_state (ds_abbreviation, ds_type,id_region_type, st_active) VALUES
                                                                                    ('AC', 'Acre', 1, true),
                                                                                    ('AL', 'Alagoas', 2, true),
                                                                                    ('AP', 'Amapa', 1, true),
                                                                                    ('AM', 'Amazonas', 1, true),
                                                                                    ('BA', 'Bahia', 2, true),
                                                                                    ('CE', 'Ceara', 2, true),
                                                                                    ('DF', 'Distrito Federal', 3, true),
                                                                                    ('ES', 'Esporito Santo', 4, true),
                                                                                    ('GO', 'Goias', 3, true),
                                                                                    ('MA', 'Maranhao', 2, true),
                                                                                    ('MT', 'Mato Grosso', 3, true),
                                                                                    ('MS', 'Mato Grosso do Sul', 3, true),
                                                                                    ('MG', 'Minas Gerais', 4, true),
                                                                                    ('PA', 'Para', 1, true),
                                                                                    ('PB', 'Paraiba', 2, true),
                                                                                    ('PR', 'Parana', 5, true),
                                                                                    ('PE', 'Pernambuco', 2, true),
                                                                                    ('PI', 'Piaui', 2, true),
                                                                                    ('RJ', 'Rio de Janeiro', 4, true),
                                                                                    ('RN', 'Rio Grande do Norte', 2, true),
                                                                                    ('RS', 'Rio Grande do Sul', 5, true),
                                                                                    ('RO', 'Rondonia', 1, true),
                                                                                    ('RR', 'Roraima', 1, true),
                                                                                    ('SC', 'Santa Catarina', 5, true),
                                                                                    ('SP', 'Sao Paulo', 4, true),
                                                                                    ('SE', 'Sergipe', 2, true),
                                                                                    ('TO', 'Tocantins', 1, true),
                                                                                    ('NA', 'Nao declarado',0, true);

INSERT INTO tbl_type_location (ds_type, st_active) VALUES
                                                                     ('Especial', true),
                                                                     ('Normal', true),
                                                                     ('Trabalhoso', true),
                                                                     ('Nao declarado', true);

INSERT INTO tbl_type_phone_nationality (ds_country_abbreviation, ds_country_description, ds_code, st_active) VALUES
                                                                                                                 ('UN', 'Desconhecido', 'Unknown', true),
                                                                                                                 ('NA', 'Nao declarado', 'Not available', true),
                                                                                                                 ('AL', 'Albania', '+355', true),
                                                                                                                 ('AR', 'Argentina', '+54', true),
                                                                                                                 ('AM', 'Armenia', '+374', true),
                                                                                                                 ('AT', 'Austria', '+43', true),
                                                                                                                 ('AZ', 'Azerbaijan', '+994', true),
                                                                                                                 ('BE', 'Belgium', '+32', true),
                                                                                                                 ('BA', 'Bosnia and Herzegovina', '+387', true),
                                                                                                                 ('BR', 'Brazil', '+55', true),
                                                                                                                 ('BG', 'Bulgaria', '+359', true),
                                                                                                                 ('CL', 'Chile', '+56', true),
                                                                                                                 ('CO', 'Colombia', '+57', true),
                                                                                                                 ('HR', 'Croatia', '+385', true),
                                                                                                                 ('CY', 'Cyprus', '+357', true),
                                                                                                                 ('CZ', 'Czech Republic', '+420', true),
                                                                                                                 ('DK', 'Denmark', '+45', true),
                                                                                                                 ('EC', 'Ecuador', '+593', true),
                                                                                                                 ('EG', 'Egypt', '+20', true),
                                                                                                                 ('EE', 'Estonia', '+372', true),
                                                                                                                 ('FI', 'Finland', '+358', true),
                                                                                                                 ('FR', 'France', '+33', true),
                                                                                                                 ('GE', 'Georgia', '+995', true),
                                                                                                                 ('DE', 'Germany', '+49', true),
                                                                                                                 ('GR', 'Greece', '+30', true),
                                                                                                                 ('HU', 'Hungary', '+36', true),
                                                                                                                 ('IS', 'Iceland', '+354', true),
                                                                                                                 ('IN', 'India', '+91', true),
                                                                                                                 ('ID', 'Indonesia', '+62', true),
                                                                                                                 ('IR', 'Iran', '+98', true),
                                                                                                                 ('IQ', 'Iraq', '+964', true),
                                                                                                                 ('IE', 'Ireland', '+353', true),
                                                                                                                 ('IL', 'Israel', '+972', true),
                                                                                                                 ('IT', 'Italy', '+39', true),
                                                                                                                 ('JP', 'Japan', '+81', true),
                                                                                                                 ('JO', 'Jordan', '+962', true),
                                                                                                                 ('KZ', 'Kazakhstan', '+7', true),
                                                                                                                 ('KW', 'Kuwait', '+965', true),
                                                                                                                 ('LV', 'Latvia', '+371', true),
                                                                                                                 ('LB', 'Lebanon', '+961', true),
                                                                                                                 ('LT', 'Lithuania', '+370', true),
                                                                                                                 ('LU', 'Luxembourg', '+352', true),
                                                                                                                 ('MY', 'Malaysia', '+60', true),
                                                                                                                 ('MT', 'Malta', '+356', true),
                                                                                                                 ('MX', 'Mexico', '+52', true),
                                                                                                                 ('MC', 'Monaco', '+377', true),
                                                                                                                 ('ME', 'Montenegro', '+382', true),
                                                                                                                 ('MA', 'Morocco', '+212', true),
                                                                                                                 ('NL', 'Netherlands', '+31', true),
                                                                                                                 ('NZ', 'New Zealand', '+64', true),
                                                                                                                 ('NO', 'Norway', '+47', true),
                                                                                                                 ('PK', 'Pakistan', '+92', true),
                                                                                                                 ('PA', 'Panama', '+507', true),
                                                                                                                 ('PY', 'Paraguay', '+595', true),
                                                                                                                 ('PE', 'Peru', '+51', true),
                                                                                                                 ('PL', 'Poland', '+48', true),
                                                                                                                 ('PT', 'Portugal', '+351', true),
                                                                                                                 ('RO', 'Romania', '+40', true),
                                                                                                                 ('RU', 'Russia', '+7', true),
                                                                                                                 ('SA', 'Saudi Arabia', '+966', true),
                                                                                                                 ('RS', 'Serbia', '+381', true),
                                                                                                                 ('SG', 'Singapore', '+65', true),
                                                                                                                 ('SK', 'Slovakia', '+421', true),
                                                                                                                 ('SI', 'Slovenia', '+386', true),
                                                                                                                 ('ZA', 'South Africa', '+27', true),
                                                                                                                 ('ES', 'Spain', '+34', true),
                                                                                                                 ('SE', 'Sweden', '+46', true),
                                                                                                                 ('CH', 'Switzerland', '+41', true),
                                                                                                                 ('TW', 'Taiwan', '+886', true),
                                                                                                                 ('TH', 'Thailand', '+66', true),
                                                                                                                 ('TR', 'Turkey', '+90', true),
                                                                                                                 ('UA', 'Ukraine', '+380', true),
                                                                                                                 ('AE', 'United Arab Emirates', '+971', true),
                                                                                                                 ('GB', 'United Kingdom', '+44', true),
                                                                                                                 ('US', 'United States', '+1', true),
                                                                                                                 ('UY', 'Uruguay', '+598', true),
                                                                                                                 ('UZ', 'Uzbekistan', '+998', true),
                                                                                                                 ('VE', 'Venezuela', '+58', true),
                                                                                                                 ('VN', 'Vietnam', '+84', true);

INSERT INTO tbl_type_phone_number (ds_type, st_active) VALUES
                                                           ('Fixo', true),
                                                           ('Celular', true),
                                                           ('Nao declarado', true);

INSERT INTO tbl_type_gender (ds_type, st_active) VALUES
                                                     ('Male', true),
                                                     ('Female', true),
                                                     ('Nao declarado', true);

INSERT INTO tbl_type_timezone (ds_timezone_offset, ds_timezone_description, st_active) VALUES
                                                                                            ('-12:00', 'Baker Island Time (BIT)', true),
                                                                                            ('-11:00', 'Niue Time (NUT)', true),
                                                                                            ('-10:00', 'Hawaii-Aleutian Standard Time (HAST)', true),
                                                                                            ('-9:00', 'Alaska Standard Time (AKST)', true),
                                                                                            ('-8:00', 'Pacific Standard Time (PST)', true),
                                                                                            ('-7:00', 'Mountain Standard Time (MST)', true),
                                                                                            ('-6:00', 'Central Standard Time (CST)', true),
                                                                                            ('-5:00', 'Eastern Standard Time (EST)', true),
                                                                                            ('-4:00', 'Atlantic Standard Time (AST)', true),
                                                                                            ('-3:00', 'Brazil Time (BRT)', true),
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
                                                                                            ('12:00', 'New Zealand Standard Time (NZST)', true),
                                                                                            ('NA', 'Nao declarado', true);

INSERT INTO tbl_user (
    id_type_gender, ds_title, ds_first_name, ds_last_name, id_location_type, ds_street, ds_city,
    id_type_state, ds_postcode, ds_latitude, ds_longitude, id_type_timezone, ds_email, dt_birthday, dt_registered,
    st_active) VALUES
                   (1, 'mr', 'Joselino', 'Alves', 1, 'Rua Espirito Santo 2095', 'Sao Jose de Ribamar', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'MA'), '96895000', -35.868700, -131.880100, 1, 'joselino@gmail.com', '1996-01-09', '2014-02-09', true),
                   (1, 'mr', 'Antonelo', 'da Conceicao', 2, 'Rua Rui Barbosa 8986', 'Santo Andre', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'SP'), '40751000', -69.870400, -165.954500, 1, 'antonelo@email.com', '1956-02-12', '2005-12-05', true),
                   (1, 'mr', 'João', 'Silva', 1, 'Rua das Flores 100', 'Rio de Janeiro', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'RJ'), '20010020', -22.908333, -43.196388, 1, 'joao.silva@gmail.com', '1990-02-15', '2015-03-20', true),
                   (2, 'ms', 'Maria', 'Santos', 2, 'Avenida Paulista 200', 'São Paulo', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'SP'), '01311000', -23.550520, -46.633308, 1, 'maria.santos@gmail.com', '1985-08-10', '2016-09-05', true),
                   (1, 'mr', 'José', 'Pereira', 3, 'Rua das Pedras 300', 'Belo Horizonte', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'MG'), '30190010', -19.917599, -43.934093, 1, 'jose.pereira@gmail.com', '1975-12-05', '2017-11-01', true),
                   (2, 'ms', 'Ana', 'Carvalho', 2, 'Avenida Beira Mar 400', 'Florianópolis', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'SC'), '88015200', -27.597300, -48.549610, 1, 'ana.carvalho@gmail.com', '1982-06-30', '2018-01-15', true),
                   (1, 'mr', 'Antônio', 'Oliveira', 1, 'Rua da Praia 500', 'Porto Alegre', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'RS'), '90010030', -30.032499, -51.230377, 1, 'antonio.oliveira@gmail.com', '1995-10-20', '2019-05-10', true),
                   (2, 'ms', 'Francisca', 'Lima', 3, 'Praça da República 600', 'Salvador', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'BA'), '40050010', -12.977749, -38.501630, 1, 'francisca.lima@gmail.com', '1960-05-15', '2020-07-01', true),
                   (1, 'mr', 'Raimundo', 'Barbosa', 2, 'Rua do Ouro 700', 'Recife', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'PE'), '50010010', -8.052240, -34.928610, 1, 'raimundo.barbosa@gmail.com', '1970-01-30', '2021-08-20', true),
                   (1, 'mr', 'Pedro', 'Costa', 2, 'Rua das Palmeiras 900', 'Fortaleza', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'CE'), '60060010', -3.730451, -38.521799, 1, 'pedro.costa@gmail.com', '1988-03-05', '2013-02-25', true),
                   (2, 'ms', 'Laura', 'Mendes', 1, 'Praça da Estação 1000', 'Natal', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'RN'), '59010010', -5.793570, -35.198999, 1, 'laura.mendes@gmail.com', '1997-09-30', '2014-10-15', true),
                   (1, 'mr', 'Rafael', 'Barros', 3, 'Avenida das Américas 1100', 'Manaus', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'AM'), '69010010', -3.131633, -59.999039, 1, 'rafael.barros@gmail.com', '1978-07-25', '2015-12-10', true),
                   (2, 'ms', 'Márcia', 'Cardoso', 2, 'Rua do Mercado 1200', 'Goiânia', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'GO'), '74010010', -16.686891, -49.264794, 1, 'marcia.cardoso@gmail.com', '1981-11-20', '2017-01-05', true),
                   (1, 'mr', 'Gustavo', 'Cavalcante', 1, 'Avenida da Liberdade 1300', 'Rio de Janeiro', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'RJ'), '64000010', -5.089640, -42.809588, 1, 'gustavo.cavalcante@gmail.com', '1993-06-15', '2018-03-25', true),
                   (2, 'ms', 'Renata', 'Fonseca', 3, 'Rua do Imperador 1400', 'Belém', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'PA'), '66010010', -1.459649, -48.492245, 1, 'renata.fonseca@gmail.com', '1965-05-30', '2019-06-15', true),
                   (1, 'mr', 'André', 'Castro', 2, 'Praça da Sé 1500', 'Campo Grande', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'MS'), '79010010', -20.469710, -54.620121, 1, 'andre.castro@gmail.com', '1972-12-10', '2020-08-30', true),
                   (2, 'ms', 'Beatriz', 'Viana', 1, 'Rua do Bosque 1600', 'Aracaju', (SELECT id_type_state FROM tbl_type_state WHERE ds_abbreviation = 'SE'), '49010010', -10.947267, -37.073082, 1, 'beatriz.viana@gmail.com', '1998-08-25', '2021-11-15', true);


INSERT INTO tbl_phone_number (id_user, ds_phone_number, id_phone_number_type, id_phone_number_nationality, st_active) VALUES
                                                                                                                          (1, '+551234567890', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (1, '+5511987654321', 2, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (2, '+551234567891', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (2, '+5511987654322', 2, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (3, '+541234567890', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'AR'), true),
                                                                                                                          (3, '+5411987654321', 2, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'AR'), true),
                                                                                                                          (4, '+541234567891', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'AR'), true),
                                                                                                                          (4, '+5411987654322', 2, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'AR'), true),
                                                                                                                          (5, '+59812345678', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'UY'), true),
                                                                                                                          (5, '+59898765432', 2, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'UY'), true),
                                                                                                                          (6, '+59812345679', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'UY'), true),
                                                                                                                          (6, '+59898765433', 2, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'UY'), true),
                                                                                                                          (7, '+12123456789', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'US'), true),
                                                                                                                          (8, '+551234567892', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (9, '+551234567893', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (10, '+551234567894', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (11, '+551234567895', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'BR'), true),
                                                                                                                          (12, '+541234567892', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'AR'), true),
                                                                                                                          (13, '+541234567893', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'AR'), true),
                                                                                                                          (14, '+59812345680', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'UY'), true),
                                                                                                                          (15, '+12123456790', 1, (SELECT id_phone_number_nationality FROM tbl_type_phone_nationality WHERE ds_country_abbreviation = 'US'), true);


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
