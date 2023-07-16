package com.example.service;

import com.example.dao.PersonaDAO;
import com.example.model.Persona;

public class PersonaService {
    private PersonaDAO personaDAO;

    public PersonaService() {
        personaDAO = new PersonaDAO();
    }

    public Persona getPersonaByRut(String rut) {
        return personaDAO.getPersonaByRut(rut);
    }
    public void insertPersona(Persona persona) {
        personaDAO.insertPersona(persona);
    }
}