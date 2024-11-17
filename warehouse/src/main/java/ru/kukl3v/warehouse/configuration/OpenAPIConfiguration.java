package ru.kukl3v.warehouse.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация OpenAPI для настройки документации API склада.
 */
@Configuration
public class OpenAPIConfiguration {
    /**
     * Создает и настраивает экземпляр OpenAPI.
     *
     * @return объект OpenAPI с настройками API.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Warehouse API")
                        .description("API для склада товаров.")
                        .version("1.0"));
    }
}
