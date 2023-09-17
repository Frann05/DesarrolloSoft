package com.example.Tp1PersistenciaJPAGiuliani.Repositorios;

import com.example.Tp1PersistenciaJPAGiuliani.Entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
