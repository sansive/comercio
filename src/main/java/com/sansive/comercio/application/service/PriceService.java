package com.sansive.comercio.application.service;

import com.sansive.comercio.domain.model.Price;

import java.time.LocalDateTime;

/**
 * Service interface for managing price retrieval operations.
 */
public interface PriceService {

    /**
     * Retrieves the price of a product for a specific brand at a given date and time.
     *
     * @param productId         the ID of the product whose price is being retrieved
     * @param brandId           the ID of the brand associated with the price
     * @param applicationDate   the date and time at which the price should be applied
     * @return The price of the product for the given brand at the specified date and time
     */
    Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
