package com.example.Tp1PersistenciaJPAGiuliani.Entidades;

import com.example.Tp1PersistenciaJPAGiuliani.Enums.FormaPago;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad {
    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;
}
