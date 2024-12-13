package com.sansive.comercio.application.mapper;

import com.sansive.comercio.domain.model.Price;
import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper to convert PriceEntity to Price domain object.
 */
@Component
public class PriceMapper {

    /**
     * Converts a PriceEntity to a Price domain object.
     *
     * @param priceEntity the PriceEntity to convert
     * @return the corresponding Price domain object
     */
    public Price toPrice(PriceEntity priceEntity) {
        return new Price(
                priceEntity.getProductId(),
                priceEntity.getBrandId(),
                priceEntity.getPriceList(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPrice(),
                priceEntity.getCurr()
        );
    }
}