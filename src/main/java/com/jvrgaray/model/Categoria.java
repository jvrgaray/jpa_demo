package com.jvrgaray.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
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
	* Obtiene el campo "descripcion".
	*
	* @return descripcion
	*/
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Modifica el campo "descripcion" 
	 * @param descripcion descripcion a modificar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categoria [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}
	
	
}
