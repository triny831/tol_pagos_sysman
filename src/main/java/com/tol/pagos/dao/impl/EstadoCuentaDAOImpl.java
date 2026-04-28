package com.tol.pagos.dao.impl;

import com.tol.pagos.dao.EstadoCuentaDAO;
import com.tol.pagos.exception.DataException;
import com.tol.pagos.model.EstadoCuentaDTO;
import com.tol.pagos.util.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class EstadoCuentaDAOImpl implements EstadoCuentaDAO {

    @Override
    public EstadoCuentaDTO obtenerEstadoCuenta(String codigo, String documento) throws DataException {

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{ call sp_estado_cuenta(?, ?) }")) {

            cs.setString(1, codigo);
            cs.setString(2, documento);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                EstadoCuentaDTO dto = new EstadoCuentaDTO();
                dto.setNombre(rs.getString("nombre"));
                dto.setValorDeuda(rs.getDouble("valor_deuda"));
                dto.setEstado(rs.getString("estado"));
                return dto;
            }

            throw new DataException("No se encontró información del contribuyente");

        } catch (Exception e) {
            throw new DataException("Error consultando estado de cuenta", e);
        }
    }
}
