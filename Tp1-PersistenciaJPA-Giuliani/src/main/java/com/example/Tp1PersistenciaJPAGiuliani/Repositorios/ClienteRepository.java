package com.example.Tp1PersistenciaJPAGiuliani.Repositorios;

import com.example.Tp1PersistenciaJPAGiuliani.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
}
