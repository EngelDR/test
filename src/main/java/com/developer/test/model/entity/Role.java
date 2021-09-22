package com.developer.test.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TROLE")
@SequenceGenerator(name= "NAME_SEQUENCE", sequenceName = "ROLE_SEQ", initialValue=1, allocationSize = 1)
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NAME_SEQUENCE")
	@Column(name = "ID")
	public Long id;
	@Column(name = "NOMBRE")
	public String nombre;
}
