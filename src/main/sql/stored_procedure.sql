CREATE OR REPLACE FUNCTION sp_estado_cuenta(p_codigo VARCHAR, p_documento VARCHAR)
RETURNS TABLE(nombre VARCHAR, valor_deuda NUMERIC, estado VARCHAR)
AS $$
BEGIN
    RETURN QUERY
    SELECT c.nombre, e.valor_deuda, e.estado
    FROM contribuyentes c
    JOIN estado_cuenta e ON e.contribuyente_id = c.id
    WHERE c.codigo_catastral = p_codigo
      AND c.documento = p_documento;
END;
$$ LANGUAGE plpgsql;