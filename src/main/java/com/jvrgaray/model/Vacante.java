package com.jvrgaray.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Vacantes")
public class Vacante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private Double salario;
	private Integer destacado;
	private String imagen="no-image.jpg";
	private String estatus;
	private String detalles;
	@Transient
	private Categoria categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Integer getDestacado() {
		return destacado;
	}
	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}
	
	/**
	* Obtiene el campo "image".
	*
	* @return image
	*/
	public String getImagen() {
		return imagen;
	}
	/**
	 * Modifica el campo "image" 
	 * @param image image a modificar
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	* Obtiene el campo "estatus".
	*
	* @return estatus
	*/
	public String getEstatus() {
		return estatus;
	}
	/**
	 * Modifica el campo "estatus" 
	 * @param estatus estatus a modificar
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	* Obtiene el campo "detalles".
	*
	* @return detalles
	*/
	public String getDetalles() {
		return detalles;
	}
	/**
	 * Modifica el campo "detalles" 
	 * @param detalles detalles a modificar
	 */
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	/**
	* Obtiene el campo "categoria".
	*
	* @return categoria
	*/
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * Modifica el campo "categoria" 
	 * @param categoria categoria a modificar
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vacante [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", salario=");
		builder.append(salario);
		builder.append(", destacado=");
		builder.append(destacado);
		builder.append(", imagen=");
		builder.append(imagen);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", detalles=");
		builder.append(detalles);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append("]");
		return builder.toString();
	}
}
