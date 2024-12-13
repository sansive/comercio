package com.sansive.comercio.infrastructure.persistence.repository;

import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for querying price records in the database.
 */
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Custom query to retrieve price records for a specific product and brand, valid at the given application date.
     * This query checks that the price's start date is before or equal to the application date, and the end date
     * is after or equal to the application date. The results are ordered by priority, ensuring the most relevant
     * price is returned first.
     *
     * @param productId         the ID of the product whose price is being queried
     * @param brandId           the ID of the brand associated with the price
     * @param applicationDate   the date and time at which the price should be applied
     * @return A list of price records matching the specified criteria, ordered by priority in descending order
     */
    @Query("SELECT p " +
            "FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND p.startDate <= :applicationDate " +
            "AND p.endDate >= :applicationDate " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(
            Long productId, Long brandId, LocalDateTime applicationDate);
}
