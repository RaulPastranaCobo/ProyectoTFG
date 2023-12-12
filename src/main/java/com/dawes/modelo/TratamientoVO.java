package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "tratamientos")

public class TratamientoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtratamiento;
    private String nombre;
    private LocalDate fecha;

    @OneToMany(mappedBy="tratamiento", cascade = CascadeType.ALL)
    private List<ArbolTratamientoVO> arbolestratamientos;

    @OneToMany(mappedBy="tratamiento")
    private List<VariedadTratamientoFincaVO> variedadestratamientosfincas;

    @OneToMany(mappedBy="tratamiento")
    private List<TratamientoFincaVO> tratamientosfincas;

}