package com.envios.repository;

import com.envios.entity.EnvioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<EnvioEntity, Integer> {

    @Query(value = "select * from envio where estado =:estado", nativeQuery = true)
    public List<EnvioEntity> filtrarPorEstado(@Param("estado") String tipo);
}
