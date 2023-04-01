-- INSERT DATA CATALOGS

---------------------------------------------------- average_data --------------------------------------------------------------------------

INSERT INTO average_data(description, quantity, measure)
VALUES ('Uso mensual de combustible para los vehículos administrativos', 750, 'galones');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Pérdidas de gases refrigerantes mensuales', 3, 'galones');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Consumo de energía eléctrica en oficinas administrativas', 300, 'Kw');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Uso mensual de combustible para vehículos de distribución', 1250, 'galones');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Uso mensual de combustible para transporte tercero de materia prima', 500, 'galones');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Viajes del CEO y COO de la empresa', 3, 'viajes mensuales');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Uso mensual de aceite para mantenimiento de máquinas operadoras', 900, 'galones');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Consumo de energía eléctrica en planta de envasado', 900, 'Kw');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Consumo diario de aceite para mantenimiento de flota de distribución', 1, 'galones');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Uso promedio diario de papel bond para impresión de documentos', 300, 'hojas');

INSERT INTO average_data(description, quantity, measure)
VALUES ('Viajes del equipo de ventas de la empresa', 2, 'viajes mensuales');

---------------------------------------------------- users --------------------------------------------------------------------------

INSERT INTO users(name, user_name, email_address, password, enabled, created_at, created_by, updated_at, updated_by)
VALUES ('ADMIN', 'admin', 'admin@admin.com', 'admin', true, now(), 'ADMIN', now(), 'ADMIN');

---------------------------------------------------- type_fuel --------------------------------------------------------------------------

INSERT INTO type_fuel(name, description,created_at, created_by, updated_at, updated_by)
VALUES ('COMBUSTIBLE', 'Consumo de combustible.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_fuel(name, description,created_at, created_by, updated_at, updated_by)
VALUES ('ENERGIA ELECTRICA', 'Consumo de energia electrica.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_fuel(name, description,created_at, created_by, updated_at, updated_by)
VALUES ('DERIVADOS DEL PETROLEO', 'Consumo de productos derivados del petroleo.', now(), 'ADMIN', now(), 'ADMIN');

---------------------------------------------------- type_consumption --------------------------------------------------------------------------

INSERT INTO type_consumption(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('ADMINISTRATIVO', 'Consumo administrativo.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_consumption(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('INDIRECTO DE PROVEEDOR', 'Consumo indirecto de proveedor.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_consumption(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('LOGISTICA', 'Consumo de logistica.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_consumption(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('DISTRIBUCION', 'Consumo de distribucion.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_consumption(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('OPERACION', 'Consumo de operacion.', now(), 'ADMIN', now(), 'ADMIN');

---------------------------------------------------- measure --------------------------------------------------------------------------

INSERT INTO measure(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('GALON', 'Tipo de medida galon.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO measure(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('KILO WATTS', 'Tipo de medida kilo watts.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO measure(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('HOJAS', 'Tipo de medida hoja.', now(), 'ADMIN', now(), 'ADMIN');

---------------------------------------------------- type_trip --------------------------------------------------------------------------

INSERT INTO type_trip(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('VIAJE DE NEGOCIOS', 'Tipo de viajes de negocios CEO y CTO.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_trip(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('VIAJE ADMINISTRATIVO', 'Tipo de viaje administrativo.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_trip(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('VIAJE DE EMPRESARIAL', 'Tipo de viaje empresarial.', now(), 'ADMIN', now(), 'ADMIN');

---------------------------------------------------- type_emission --------------------------------------------------------------------------

INSERT INTO type_emission(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('EMISIONES DIRECTAS', 'Tipo de emisiones directas.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_emission(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('EMISIONES INDIRECTAS', 'Tipo de emisiones indirectas.', now(), 'ADMIN', now(), 'ADMIN');

INSERT INTO type_emission(name, description, created_at, created_by, updated_at, updated_by)
VALUES ('OTRAS EMISIONES INDIRECTAS', 'Tipo de otras emisiones indidirectas.', now(), 'ADMIN', now(), 'ADMIN');