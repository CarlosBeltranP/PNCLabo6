package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	private Integer c_codigo;
	
	@Column(name="s_nombre")
	private String nombre;
	
	@Column(name="s_apellido")
	private String apellido;
	
	@Column(name="s_nit")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fechaIngreso;
	
	@Transient
	private Integer cimportancia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	
	
	public Importancia getImportancia() {
		return importancia;
	}
	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
	public Integer getCimportancia() {
		return cimportancia;
	}
	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}
	public Integer getC_codigo() {
		return c_codigo;
	}
	public void setC_codigo(Integer c_codigo) {
		this.c_codigo = c_codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public Contribuyente() {
		super();
	}
	
	public String getFechaDelegate(){
		if(this.fechaIngreso == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String shortdate = sdf.format(this.fechaIngreso.getTime());
			return shortdate;
		}
	}

}
