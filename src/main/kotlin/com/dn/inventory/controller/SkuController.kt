package com.dn.inventory.controller

import com.dn.inventory.controller.dto.SkuDto
import com.dn.inventory.service.SkuService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "2. 상품관리 API")
class SkuController(
    private val skuService: SkuService
) {
    @GetMapping("/v1/skus/skus")
    @Operation(summary = "상품목록 조회 API", description = "상품목록 조회 API")
    fun getSkuList(): List<SkuDto> {
        return skuService.getSkuList()
    }

    @GetMapping("/v1/skus/skus/{skuId}")
    @Operation(summary = "상품목록 조회 API", description = "상품목록 조회 API")
    fun getSku(@PathVariable skuId: Long): SkuDto {
        return skuService.getSku(skuId)
    }

    @PostMapping("/v1/skus/skus")
    @Operation(summary = "상품저장 API", description = "상품저장 API")
    fun saveSku(@RequestBody skuDto: SkuDto) {
        skuService.saveSku(skuDto)
    }

    @PutMapping("/v1/skus/skus")
    @Operation(summary = "상품수정 API", description = "상품수정 API")
    fun updateSku(@RequestBody skuDto: SkuDto) {
        skuService.updateSku(skuDto)
    }
}