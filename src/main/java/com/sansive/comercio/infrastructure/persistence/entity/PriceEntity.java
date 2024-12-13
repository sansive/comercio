package com.sansive.comercio.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents a price record for a product associated with a specific brand.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Id private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String curr;
}
