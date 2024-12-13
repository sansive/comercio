package com.sansive.comercio.infrastructure.rest.controller;

import com.sansive.comercio.application.service.PriceService;
import com.sansive.comercio.domain.model.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Controller for retrieving prices.
 */
@RestController
@RequestMapping(path = "api/prices")
public class PriceController {

    private final PriceService priceService;

    /**
     * Constructor for PriceController.
     *
     * @param priceService     the service used to fetch price records
     */
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Retrieves the price of a product for a specific brand at a given date and time.
     *
     * @param applicationDate   the date and time at which the price should be applied
     * @param productId         the ID of the product whose price is being retrieved
     * @param brandId           the ID of the brand associated with the price
     * @return The price of the product for the given brand at the specified date and time
     */
    @GetMapping("")
    Price getPrice(@RequestParam LocalDateTime applicationDate,
                   @RequestParam Long productId,
                   @RequestParam Long brandId) {

        return priceService.getPrice(productId, brandId, applicationDate);
    }
}
