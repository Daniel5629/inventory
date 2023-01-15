package com.dn.inventory.repository

import com.dn.inventory.entity.LocationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<LocationEntity, Long> {
}