package com.tol.pagos.servlet;

import com.google.gson.Gson;
import com.tol.pagos.exception.GlobalExceptionHandler;
import com.tol.pagos.model.ApiResponse;
import com.tol.pagos.model.EstadoCuentaDTO;
import com.tol.pagos.service.EstadoCuentaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/estado-cuenta")
public class EstadoCuentaServlet extends HttpServlet {

    private final EstadoCuentaService service = new EstadoCuentaService();
    private final Gson gson = new Gson();
    private static final Logger logger = LogManager.getLogger(EstadoCuentaServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("application/json");

        try {

            String codigo = req.getParameter("codigoCatastral");
            String documento = req.getParameter("documento");

            logger.info("Request recibido | codigo={} | documento={}", codigo, documento);

            EstadoCuentaDTO data = service.consultarEstadoCuenta(codigo, documento);

            resp.getWriter().write(
                    gson.toJson(new ApiResponse("SUCCESS", "OK", data))
            );

        } catch (Exception e) {

            logger.error("Error en consulta", e);

            try {
                resp.setStatus(500);
                resp.getWriter().write(
                        gson.toJson(GlobalExceptionHandler.handle(e))
                );
            } catch (Exception ignored) {}
        }
    }
}
