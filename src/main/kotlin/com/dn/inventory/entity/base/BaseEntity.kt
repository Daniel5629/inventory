package com.dn.inventory.entity.base

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {

    @CreatedDate
    @Column(name = "created_date", updatable = false, nullable = false)
    val createdDate: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "updated_date")
    val updatedDAte: LocalDateTime? = null

    @Column(name = "is_delete")
    val isDelete: Boolean = false
}