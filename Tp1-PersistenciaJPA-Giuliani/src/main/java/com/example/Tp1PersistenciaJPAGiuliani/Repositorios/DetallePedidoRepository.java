package com.example.Tp1PersistenciaJPAGiuliani.Repositorios;

import com.example.Tp1PersistenciaJPAGiuliani.Entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}
