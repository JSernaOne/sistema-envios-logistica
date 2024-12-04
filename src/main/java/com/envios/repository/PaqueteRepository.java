package com.envios.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.envios.entity.PaqueteEntity;


@Repository
public interface PaqueteRepository extends JpaRepository<PaqueteEntity, Integer> {
}
