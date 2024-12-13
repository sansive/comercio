package com.sansive.comercio.infrastructure.persistence.repository;

import com.sansive.comercio.domain.repository.PriceRepository;
import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of the PriceRepository interface for interacting with the database.
 */
@Repository
public class H2PriceRepository implements PriceRepository {

    private final JpaPriceRepository jpaPriceRepository;

    /**
     * Constructs an H2PriceRepository with the provided JpaPriceRepository.
     *
     * @param jpaPriceRepository    the repository used to interact with the database
     */
    public H2PriceRepository(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    /**
     * Retrieves a list of applicable price records based on the given product ID, brand ID, and application date.
     *
     * @param productId         the ID of the product whose price is being queried
     * @param brandId           the ID of the brand associated with the price
     * @param applicationDate   the date and time at which the price should be applied
     * @return A list of price records that match the given product, brand, and application date
     */
    @Override
    public List<PriceEntity> findApplicablePrices(Long productId, Long brandId, LocalDateTime applicationDate) {
        return jpaPriceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(productId, brandId, applicationDate);
    }
}
