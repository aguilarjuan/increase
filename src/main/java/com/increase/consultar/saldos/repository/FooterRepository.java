package com.increase.consultar.saldos.repository;

import com.increase.consultar.saldos.domain.FooterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterRepository extends JpaRepository<FooterEntity, Long> {
}
