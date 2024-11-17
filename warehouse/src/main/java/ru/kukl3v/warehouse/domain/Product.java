package ru.kukl3v.warehouse.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность, представляющая товар в базе данных.
 */
@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * Уникальный идентификатор товара.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Название товара.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Артикул товара.
     */
    @Column(name = "article_number", unique = true, nullable = false)
    private String articleNumber;

    /**
     * Описание товара.
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * Категория товара.
     */
    @Column(name = "category", nullable = false)
    private String category;

    /**
     * Цена товара.
     */
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Количество товара.
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * Дата и время последнего изменения количества товара.
     */
    @Column(name = "last_quantity_update", nullable = false)
    private LocalDateTime lastQuantityUpdate;

    /**
     * Дата создания товара.
     */
    @Column(name = "date_created", updatable = false, nullable = false)
    private LocalDate dateCreated;
}
