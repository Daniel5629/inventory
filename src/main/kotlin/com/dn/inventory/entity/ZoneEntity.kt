package com.dn.inventory.entity

import com.dn.inventory.entity.base.BaseEntity
import javax.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "center")
@Entity
class ZoneEntity(

    @Comment("존 명칭")
    @Column(name = "zone_name")
    val name: String,

    @Comment("존 코드")
    @Column(name = "zone_code")
    val code: String,

    @Comment("센터 아이디")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    val center: CenterEntity

) : BaseEntity() {

    @Id
    @Column(name = "zone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}