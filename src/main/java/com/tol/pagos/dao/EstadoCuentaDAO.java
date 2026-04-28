package com.tol.pagos.dao;

import com.tol.pagos.model.EstadoCuentaDTO;

public interface EstadoCuentaDAO {

    EstadoCuentaDTO obtenerEstadoCuenta(String codigo, String documento) throws Exception;
}
