package com.tol.pagos.service;

import com.tol.pagos.dao.EstadoCuentaDAO;
import com.tol.pagos.dao.impl.EstadoCuentaDAOImpl;
import com.tol.pagos.model.EstadoCuentaDTO;

public class EstadoCuentaService {

    private final EstadoCuentaDAO dao = new EstadoCuentaDAOImpl();

    public EstadoCuentaDTO consultarEstadoCuenta(String codigo, String documento) throws Exception {

        validate(codigo, documento);

        return dao.obtenerEstadoCuenta(codigo, documento);
    }

    private void validate(String codigo, String documento) {

        if (codigo == null || codigo.trim().isEmpty())
            throw new IllegalArgumentException("Código catastral requerido");

        if (documento == null || documento.trim().isEmpty())
            throw new IllegalArgumentException("Documento requerido");
    }
}
