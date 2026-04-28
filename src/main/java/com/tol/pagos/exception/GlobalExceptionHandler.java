package com.tol.pagos.exception;

import com.tol.pagos.model.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    public static ApiResponse handle(Exception e) {

        logger.error("Error controlado en sistema", e);

        if (e instanceof DataException) {
            return new ApiResponse(
                    "ERROR_BUSINESS",
                    e.getMessage(),
                    null
            );
        }

        return new ApiResponse(
                "ERROR_SYSTEM",
                "Error interno del servidor",
                null
        );
    }
}
