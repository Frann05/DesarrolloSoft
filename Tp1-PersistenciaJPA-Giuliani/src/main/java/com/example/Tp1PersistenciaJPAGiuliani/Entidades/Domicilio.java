package com.example.Tp1PersistenciaJPAGiuliani.Entidades;

import jakarta.persistence.Entity;
import lombok.*;
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {
    private String calle;
    private int numero;
    private String localidad;
}
