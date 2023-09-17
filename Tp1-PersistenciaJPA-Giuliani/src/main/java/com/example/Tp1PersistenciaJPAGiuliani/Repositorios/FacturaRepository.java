package com.example.Tp1PersistenciaJPAGiuliani.Repositorios;

import com.example.Tp1PersistenciaJPAGiuliani.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository  extends JpaRepository<Factura,Long> {
}
