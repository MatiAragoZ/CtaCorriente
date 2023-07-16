package com.example.model;

public class Transaccion {
    private int id;
    private String rut_cliente;
    private String rut_dueno;
    private int id_cuenta;
    private double monto_transferencia;
    private String cuenta_transferencia;
    private String tipo_cuenta;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRut_cliente() {
		return rut_cliente;
	}
	public void setRut_cliente(String rut_cliente) {
		this.rut_cliente = rut_cliente;
	}
	public String getRut_dueno() {
		return rut_dueno;
	}
	public void setRut_dueno(String rut_dueno) {
		this.rut_dueno = rut_dueno;
	}
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public double getMonto_transferencia() {
		return monto_transferencia;
	}
	public void setMonto_transferencia(double monto_transferencia) {
		this.monto_transferencia = monto_transferencia;
	}
	public String getCuenta_transferencia() {
		return cuenta_transferencia;
	}
	public void setCuenta_transferencia(String cuenta_transferencia) {
		this.cuenta_transferencia = cuenta_transferencia;
	}
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
}

