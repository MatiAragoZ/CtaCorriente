package com.example.service;

import com.example.dao.TransaccionDAO;
import com.example.model.Transaccion;

public class TransaccionService {
    private TransaccionDAO transaccionDAO;

    public TransaccionService() {
        transaccionDAO = new TransaccionDAO();
    }

    public void insertTransaccion(Transaccion transaccion) {
        transaccionDAO.insertTransaccion(transaccion);
    }
}