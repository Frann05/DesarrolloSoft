package com.example.Tp1PersistenciaJPAGiuliani.Entidades;

import com.example.Tp1PersistenciaJPAGiuliani.Enums.EstadoPedido;
import com.example.Tp1PersistenciaJPAGiuliani.Enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad {

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double total;
    private EstadoPedido estadoPedido;
    private TipoEnvio tipoEnvio;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido-id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetalle(DetallePedido det){
        detallePedidos.add(det);
    }

}
