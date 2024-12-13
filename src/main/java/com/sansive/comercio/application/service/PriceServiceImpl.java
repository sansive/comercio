package com.sansive.comercio.application.service;

import com.sansive.comercio.application.exception.BadRequestException;
import com.sansive.comercio.application.mapper.PriceMapper;
import com.sansive.comercio.domain.model.Price;
import com.sansive.comercio.domain.repository.PriceRepository;
import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of the PriceService interface for retrieving prices.
 */
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    /**
     * Constructor for PriceServiceImpl. Initializes the service with the PriceRepository.
     *
     * @param priceRepository   the repository used to fetch price records
     * @param priceMapper       the mapper used to convert PriceEntity to Price
     */
    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    /**
     * Retrieves the price of a product for a specific brand at a given date and time.
     *
     * @param productId         the ID of the product whose price is being retrieved
     * @param brandId           the ID of the brand associated with the price
     * @param applicationDate   the date and time at which the price should be applied
     * @return The price of the product for the given brand at the specified date and time
     */
    @Override
    public Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        // Retrieve the list of prices applicable to the given product, brand, and date
        List<PriceEntity> priceEntities = priceRepository.findApplicablePrices(productId, brandId, applicationDate);

        // If no prices are found, throw a BadRequestException
        if (priceEntities.isEmpty()) {
            throw new BadRequestException("No price records found for the provided criteria: productId=" + productId + ", brandId=" + brandId + ", applicationDate=" + applicationDate);
        }

        // Return the first applicable price since they are ordered by priority
        return priceMapper.toPrice(priceEntities.get(0));
    }
}
