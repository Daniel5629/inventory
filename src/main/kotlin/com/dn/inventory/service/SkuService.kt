package com.dn.inventory.service

import com.dn.inventory.controller.dto.SkuDto

interface SkuService {

    /**
     * sku 목록조회
     */
    fun getSkuList(): List<SkuDto>

    /**
     * 특정 sku 조회
     */
    fun getSku(skuId: Long): SkuDto

    /**
     * sku 등록
     */
    fun saveSku(skuDto: SkuDto)

    /**
     * sku 수정
     */
    fun updateSku(skuDto: SkuDto)

}