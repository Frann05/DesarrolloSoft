package com.example.Tp1PersistenciaJPAGiuliani.Repositorios;

import com.example.Tp1PersistenciaJPAGiuliani.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
