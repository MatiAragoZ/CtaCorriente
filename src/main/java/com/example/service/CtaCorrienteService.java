package com.example.service;

import com.example.dao.CtaCorrienteDAO;
import com.example.model.CtaCorriente;

public class CtaCorrienteService {
    private CtaCorrienteDAO ctaCorrienteDAO;

    public CtaCorrienteService() {
        ctaCorrienteDAO = new CtaCorrienteDAO();
    }

    public void insertCtaCorriente(CtaCorriente ctaCorriente) {
        ctaCorrienteDAO.insertCtaCorriente(ctaCorriente);
    }
}