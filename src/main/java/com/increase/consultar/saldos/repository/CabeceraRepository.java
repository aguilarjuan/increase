package com.increase.consultar.saldos.repository;

import com.increase.consultar.saldos.domain.CabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CabeceraRepository extends JpaRepository<CabeceraEntity, Long> {
}
