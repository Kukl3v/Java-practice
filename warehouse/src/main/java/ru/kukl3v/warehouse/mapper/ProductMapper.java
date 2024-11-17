package ru.kukl3v.warehouse.mapper;

import org.mapstruct.Mapper;
import ru.kukl3v.warehouse.domain.Product;
import ru.kukl3v.warehouse.dto.ProductDTO;

/**
 * Интерфейс маппера для преобразования между {@link Product} и {@link ProductDTO}.
 */
@Mapper(config = BaseMapperConfig.class)
public interface ProductMapper {

    /**
     * Преобразует {@link Product} в {@link ProductDTO}.
     *
     * @param product сущность товара.
     * @return DTO товара.
     */
    ProductDTO toDTO(Product product);

    /**
     * Преобразует {@link ProductDTO} в {@link Product}.
     *
     * @param dto dto товара.
     * @return сущность товара.
     */
    Product toProduct(ProductDTO dto);
}
