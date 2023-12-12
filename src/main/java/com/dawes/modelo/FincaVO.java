package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "fincas", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))


public class FincaVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfinca;
    private LocalDate fecha;
    private String nombre;
    private int superficie;
    private String referencia;



    @OneToMany(mappedBy="finca")
    private List<ArbolVO> arboles;

    @OneToMany(mappedBy="finca")
    private List<RecoleccionVO> recolecciones;

    @OneToMany(mappedBy="finca")
    private List<VariedadVO> variedades;

    @OneToMany(mappedBy="finca")
    private List<VariedadTratamientoFincaVO> variedadestratamientosfincas;

    @OneToMany(mappedBy="finca")
    private List<TratamientoFincaVO> tratamientosfincas;
}