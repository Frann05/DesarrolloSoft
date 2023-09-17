package com.example.Tp1PersistenciaJPAGiuliani.Repositorios;


import com.example.Tp1PersistenciaJPAGiuliani.Entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Long> {
}
