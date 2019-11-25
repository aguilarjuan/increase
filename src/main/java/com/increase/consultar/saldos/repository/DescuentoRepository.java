package com.increase.consultar.saldos.repository;

import com.increase.consultar.saldos.domain.DescuentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<DescuentoEntity, Long> {
}
