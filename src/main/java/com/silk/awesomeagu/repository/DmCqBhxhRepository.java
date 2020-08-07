package com.silk.awesomeagu.repository;

import com.silk.awesomeagu.domain.DmCqBhxh;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DmCqBhxh entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DmCqBhxhRepository extends JpaRepository<DmCqBhxh, Long>, JpaSpecificationExecutor<DmCqBhxh> {
}
