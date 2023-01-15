package com.dn.inventory.repository

import com.dn.inventory.entity.SkuEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SkuRepository : JpaRepository<SkuEntity, Long>{
}