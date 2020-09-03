/*
 * @(#)Perfil.java
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
@Table(name = "Perfiles")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String perfil;
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
	* Obtiene el campo "perfil".
	*
	* @return perfil
	*/
	public String getPerfil() {
		return perfil;
	}
	/**
	 * Modifica el campo "perfil" 
	 * @param perfil perfil a modificar
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perfil [id=");
		builder.append(id);
		builder.append(", perfil=");
		builder.append(perfil);
		builder.append("]");
		return builder.toString();
	}
	
	
}
