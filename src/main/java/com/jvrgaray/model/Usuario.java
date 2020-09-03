/*
 * @(#)Usuario.java
 *
 * Copyright (c) BANCO DE CHILE (Chile). All rights reserved.
 *
 * All rights to this product are owned by BANCO DE CHILE and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BANCO DE CHILE.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.jvrgaray.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 2b-0088
 *
 */
@Entity
@Table(name="Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String nombre;
	private String email;
	private String password;
	private Integer estatus;
	private Date fechaRegistro;
	/**
	* Obtiene el campo "id".
	*
	* @return id
	*/
	public Integer getId() {
		return id;
	}
	/**
	 * Modifica el campo "id" 
	 * @param id id a modificar
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	* Obtiene el campo "username".
	*
	* @return username
	*/
	public String getUsername() {
		return username;
	}
	/**
	 * Modifica el campo "username" 
	 * @param username username a modificar
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	* Obtiene el campo "nombre".
	*
	* @return nombre
	*/
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el campo "nombre" 
	 * @param nombre nombre a modificar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	* Obtiene el campo "email".
	*
	* @return email
	*/
	public String getEmail() {
		return email;
	}
	/**
	 * Modifica el campo "email" 
	 * @param email email a modificar
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	* Obtiene el campo "password".
	*
	* @return password
	*/
	public String getPassword() {
		return password;
	}
	/**
	 * Modifica el campo "password" 
	 * @param password password a modificar
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	* Obtiene el campo "estatus".
	*
	* @return estatus
	*/
	public Integer getEstatus() {
		return estatus;
	}
	/**
	 * Modifica el campo "estatus" 
	 * @param estatus estatus a modificar
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	/**
	* Obtiene el campo "fechaRegistro".
	*
	* @return fechaRegistro
	*/
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * Modifica el campo "fechaRegistro" 
	 * @param fechaRegistro fechaRegistro a modificar
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append("]");
		return builder.toString();
	}
}
