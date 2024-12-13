package com.sansive.comercio.domain.repository;

import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for accessing price records from the database.
 */
public interface PriceRepository {

    /**
     * Retrieves a list of price records for a specific product, brand, and application date.
     * The prices are expected to be sorted by priority, with the most relevant price appearing first.
     *
     * @param productId         the ID of the product for which the price is being queried
     * @param brandId           the ID of the brand associated with the price
     * @param applicationDate   the date and time at which the price should be applied
     * @return A list of price records that match the given product, brand, and application date
     */
    List<PriceEntity> findApplicablePrices(Long productId, Long brandId, LocalDateTime applicationDate);
}
