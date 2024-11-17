package ru.kukl3v.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO для передачи данных о товаре.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "товар")
public class ProductDTO {

    /**
     * Уникальный идентификатор товара.
     */
    @Schema(description = "id товара")
    private UUID id;

    /**
     * Название товара.
     */
    @Schema(description = "название")
    @NotBlank(message = "название товара не должно быть пустым")
    private String name;

    /**
     * Артикул товара.
     */
    @Schema(description = "артикул")
    @NotBlank(message = "артикул товара не должен быть пустым")
    private String articleNumber;

    /**
     * Описание товара.
     */
    @Schema(description = "описание")
    private String description;

    /**
     * Категория товара.
     */
    @Schema(description = "категория")
    @NotBlank(message = "категория товара не должна быть пустой")
    private String category;

    /**
     * Цена товара.
     */
    @Schema(description = "цена")
    @NotNull(message = "цена не должна быть пустой")
    @Positive(message = "цена не должна быть отрицательной")
    private BigDecimal price;

    /**
     * Количество товара.
     */
    @Schema(description = "количество")
    @NotNull(message = "количество товара не должно быть пустым")
    @Positive(message = "количество товара не должно быть отрицательным")
    private Integer quantity;

    /**
     * Дата и время последнего изменения количества товара.
     */
    @Schema(description = "дата и время последнего изменения товара")
    @NotNull(message = "дата и время последнего изменения товара не должны быть пустыми")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime lastQuantityUpdate;

    /**
     * Дата создания товара.
     */
    @Schema(description = "дата создания товара")
    @NotNull(message = "дата создания товара не должна быть пустой")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dateCreated;
}