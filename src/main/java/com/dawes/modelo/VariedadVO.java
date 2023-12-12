package com.dawes.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "variedades")

public class VariedadVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvariedad;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idfinca")
    private FincaVO finca;


    @OneToMany(mappedBy="variedad", cascade = CascadeType.PERSIST)
    private List<VariedadTratamientoFincaVO> variedadtratamientofincas;
    @OneToMany(mappedBy="variedad", cascade = CascadeType.ALL)
    private List<ArbolVO> arboles;
    @OneToMany(mappedBy="variedad", cascade = CascadeType.ALL)
    private List<RecoleccionVO> recolecciones;

}