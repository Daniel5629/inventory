package com.dn.inventory.repository

import com.dn.inventory.entity.LotEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LotRepository : JpaRepository<LotEntity, Long> {
}