package com.sansive.comercio.application.service;

import com.sansive.comercio.application.exception.BadRequestException;
import com.sansive.comercio.application.mapper.PriceMapper;
import com.sansive.comercio.domain.model.Price;
import com.sansive.comercio.domain.repository.PriceRepository;
import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PriceServiceImplTest {

    @Mock
    PriceRepository priceRepository;

    @Mock
    PriceMapper priceMapper;

    @InjectMocks
    PriceServiceImpl priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPrice_NoApplicablePrices() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(priceRepository.findApplicablePrices(productId, brandId, applicationDate))
                .thenReturn(Collections.emptyList());

        assertThrows(BadRequestException.class, () ->
                priceService.getPrice(productId, brandId, applicationDate));

        verify(priceRepository, times(1))
                .findApplicablePrices(productId, brandId, applicationDate);
    }

    @Test
    void testGetPrice_MultipleApplicablePrices() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.now();

        PriceEntity highPriorityPriceEntity = new PriceEntity(1L, LocalDateTime.now(), LocalDateTime.now(), 1L, 35455L, 1, 35.5, "EUR");
        PriceEntity lowPriorityPriceEntity = new PriceEntity(1L, LocalDateTime.now(), LocalDateTime.now(), 1L, 35455L, 0, 50.0, "EUR");

        List<PriceEntity> priceEntities = List.of(highPriorityPriceEntity, lowPriorityPriceEntity);
        when(priceRepository.findApplicablePrices(productId, brandId, applicationDate))
                .thenReturn(priceEntities);

        Price price = new Price(1L, 1L, 35455L, LocalDateTime.now(), LocalDateTime.now(), 35.5, "EUR");
        when(priceMapper.toPrice(highPriorityPriceEntity))
                .thenReturn(price);

        Price result = priceService.getPrice(productId, brandId, applicationDate);

        assertNotNull(result);
        assertEquals(highPriorityPriceEntity.getPrice(), result.getPrice());

        verify(priceRepository, times(1))
                .findApplicablePrices(productId, brandId, applicationDate);
    }
}
