package com.dn.inventory.service.impl

import com.dn.inventory.controller.dto.SkuDto
import com.dn.inventory.entity.SkuEntity
import com.dn.inventory.repository.SkuRepository
import com.dn.inventory.service.SkuService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SkuServiceImpl(
    val skuRepository: SkuRepository
) : SkuService {

    @Transactional(readOnly = true)
    override fun getSkuList(): List<SkuDto> {
        return skuRepository.findAll().map { i -> i.toDto() }
    }

    @Transactional(readOnly = true)
    override fun getSku(skuId: Long): SkuDto {
        val skuEntity = (skuRepository.findByIdOrNull(skuId) ?: throw IllegalArgumentException("존재하지 않는 SKU 입니다."))
        return skuEntity.toDto()
    }

    @Transactional
    override fun saveSku(skuDto: SkuDto) {
        val skuEntity = SkuEntity(skuDto)
        skuRepository.save(skuEntity)
    }

    @Transactional
    override fun updateSku(skuDto: SkuDto) {
        val skuEntity = (skuRepository.findByIdOrNull(skuDto.id) ?: throw IllegalArgumentException("존재하지 않는 SKU 입니다."))

        skuEntity.apply {
            name = skuDto.name ?: name
            mainCategory = skuDto.mainCategory ?: mainCategory
            middleCategory = skuDto.middleCategory ?: middleCategory
            subCategory = skuDto.subCategory ?: subCategory
        }
    }
}