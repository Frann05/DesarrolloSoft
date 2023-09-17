package com.example.Tp1PersistenciaJPAGiuliani.Entidades;

import com.example.Tp1PersistenciaJPAGiuliani.Enums.TipoProducto;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad{
    private TipoProducto tipoProducto;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;

}
