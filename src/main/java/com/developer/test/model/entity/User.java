package com.developer.test.model.entity;

import java.io.Serializable;

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

import lombok.Data;

@Data
@Entity
@Table(name = "TUSUARIO")
@SequenceGenerator(name= "NAME_SEQUENCE", sequenceName = "USER_SEQ", initialValue=1, allocationSize = 1)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NAME_SEQUENCE")
	@Column(name = "ID")
	public Long id;
	@Column(name = "NOMBRE")
	public String nombre;
	@Column(name = "A_PATERNO")
	public String a_Paterno;
	@Column(name="A_MATERNO")
	public String a_Materno;
	@JoinColumn(name = "ID_ROLE", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	public Role role;
}
