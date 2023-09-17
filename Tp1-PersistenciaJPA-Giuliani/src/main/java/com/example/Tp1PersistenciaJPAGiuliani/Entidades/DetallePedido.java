package com.example.Tp1PersistenciaJPAGiuliani.Entidades;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido extends BaseEntidad {
    private int cantidad;
    private double subtotal;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto-id")
    private Producto producto;
}
