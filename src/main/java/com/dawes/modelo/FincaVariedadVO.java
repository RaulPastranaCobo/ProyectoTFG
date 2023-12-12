package com.dawes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fincavariedades")

public class FincaVariedadVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfincavariedad;
	private String nombrefinca;
	private String nombrevariedad;
	
	@ManyToOne
	@JoinColumn(name="idfinca")
	private FincaVO finca;
	@ManyToOne
	@JoinColumn(name="idvariedad")
	private VariedadVO variedad;

	
}