package com.dn.inventory.entity

import com.dn.inventory.entity.base.BaseEntity
import javax.persistence.*
import org.hibernate.annotations.Comment

@Table(name = "center")
@Entity
class CenterEntity(

    @Comment("센터명")
    @Column(name = "center_name")
    val name: String,

    @Comment("센터코드")
    @Column(name = "center_code")
    val code: String,

    @Comment("센터전화번호")
    @Column(name = "phone")
    val phone: String,

    @Comment("센터주소")
    @Column(name = "address")
    val address: String

) : BaseEntity() {

    @Id
    @Column(name = "center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}