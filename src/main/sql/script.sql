CREATE TABLE contribuyentes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    codigo_catastral VARCHAR(50),
    documento VARCHAR(50)
);

CREATE TABLE estado_cuenta (
    id SERIAL PRIMARY KEY,
    contribuyente_id INT,
    valor_deuda NUMERIC,
    estado VARCHAR(20)
);