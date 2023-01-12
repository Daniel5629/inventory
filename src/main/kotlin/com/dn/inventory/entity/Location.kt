package com.dn.inventory.entity

import com.dn.inventory.entity.base.BaseEntity
import jakarta.persistence.*

@Table(name = "location")
@Entity
class Location(

    @Column(name = "location_name")
    val name: String,

    @Column(name = "zone")
    val zone: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    val id: Long? = null,
) : BaseEntity()