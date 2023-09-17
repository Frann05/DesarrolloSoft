package com.example.Tp1PersistenciaJPAGiuliani.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad {
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro-id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod){
        productos.add(prod);
    }
    public void mostrarProducto(){
        for (Producto producto: productos){
            System.out.println("Denominacion: " + producto.getDenominacion() + ", Receta: " + producto.getReceta()
                    + ", Unidad Medida: " + producto.getUnidadMedida() + ", Precio Compra: " + producto.getPrecioCompra()
                    + ", Precio Venta: " + producto.getPrecioVenta() + ", Stock Actual: " + producto.getStockActual()
                    + ", Stock Min: " + producto.getStockMinimo() + ", Tiempo Estimado Cocina: " + producto.getTiempoEstimadoCocina()
                    + ", Tipo: " + producto.getTipoProducto());
        }
    }
}
