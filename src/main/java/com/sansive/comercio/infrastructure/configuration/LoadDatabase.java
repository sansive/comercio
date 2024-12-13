package com.sansive.comercio.infrastructure.configuration;

import com.sansive.comercio.infrastructure.persistence.entity.PriceEntity;
import com.sansive.comercio.infrastructure.persistence.repository.JpaPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * Configuration class to preload sample price data into the database on application startup.
 */
@Configuration
public class LoadDatabase {

    // Logger to track database initialization
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    /**
     * Initializes the database with sample price records.
     * This method creates and saves four `Price` objects into the `JpaPriceRepository`. It is executed
     * automatically when the Spring Boot application starts, due to the `@Bean` annotation.
     *
     * @param repository    the repository used to save the price records into the database
     * @return A CommandLineRunner that preloads price records on application startup
     */
    @Bean
    CommandLineRunner initDatabase(JpaPriceRepository repository) {

        return args -> {
            // Preload sample price records
            log.info("Preloading " + repository.save(new PriceEntity(1L, LocalDateTime.of(2020, 6, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1L, 35455L, 0, 35.5, "EUR")));
            log.info("Preloading " + repository.save(new PriceEntity(1L, LocalDateTime.of(2020, 6, 14, 15, 0, 0), LocalDateTime.of(2020, 6, 14, 18, 30, 0), 2L, 35455L, 1, 25.45, "EUR")));
            log.info("Preloading " + repository.save(new PriceEntity(1L, LocalDateTime.of(2020, 6, 15, 0, 0, 0), LocalDateTime.of(2020, 6, 15, 11, 0, 0), 3L, 35455L, 1, 30.5, "EUR")));
            log.info("Preloading " + repository.save(new PriceEntity(1L, LocalDateTime.of(2020, 6, 15, 16, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4L, 35455L, 1, 38.95, "EUR")));
        };
    }
}
