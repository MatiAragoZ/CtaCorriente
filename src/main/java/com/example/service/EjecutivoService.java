package com.example.service;

import com.example.dao.EjecutivoDAO;
import com.example.model.Ejecutivo;

public class EjecutivoService {
    private EjecutivoDAO ejecutivoDAO;

    public EjecutivoService() {
        ejecutivoDAO = new EjecutivoDAO();
    }

    public Ejecutivo getEjecutivoByRut(String rut) {
        return ejecutivoDAO.getEjecutivoByRut(rut);
    }
}

