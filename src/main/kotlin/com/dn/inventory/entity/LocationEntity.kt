package com.dn.inventory.entity

import com.dn.inventory.common.enumuration.LocationType
import com.dn.inventory.entity.base.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "location")
@Entity
class LocationEntity(

    @Comment("로케이션 명칭")
    @Column(name = "location_name")
    val name: String,

    @Comment("로케이션 코드")
    @Column(name = "location_code")
    val code: String,

    @Comment("PICKING: 피킹 로케이션, STORED: 적치 로케이션")
    @Column(name = "location_type")
    val locationType: LocationType,

    @Comment("존 아이디")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zone_id")
    val zone: ZoneEntity,

) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    val id: Long? = null
}