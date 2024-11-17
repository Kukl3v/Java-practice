package ru.kukl3v.warehouse.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kukl3v.warehouse.dto.ProductDTO;
import ru.kukl3v.warehouse.service.ProductService;

import java.util.List;
import java.util.UUID;

/**
 * REST-контроллер для обработки запросов, связанных с товарами.
 */
@RestController
@RequestMapping("/product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name="товары", description = "запросы для товаров")
@AllArgsConstructor
public class ProductController {
    ProductService productService;

    /**
     * Получает список товаров.
     *
     * @param pageable параметры пагинации.
     * @return список товаров.
     */
    @Operation(summary = "получить список товаров")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(Pageable pageable){
        return ResponseEntity.ok(productService.getProductList(pageable));
    }

    /**
     * Находит товар по id.
     *
     * @param id идентификатор товара.
     * @return товар.
     */
    @Operation(summary = "найти товар по id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> findProduct(@PathVariable
                                                  @Parameter(description = "идентификатор товара") UUID id){
        return ResponseEntity.ok(productService.findProduct(id));
    }

    /**
     * Создает товар.
     *
     * @param product данные создаваемого товара.
     * @return HTTP статус.
     */
    @Operation(summary = "добавить товар")
    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO product){
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Изменяет товар по id.
     *
     * @param id идентификатор товара.
     * @return обновленный товаро.
     */
    @Operation(summary = "отредактировать товар по id")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> editProduct(@RequestBody ProductDTO product,
                                                  @PathVariable
                                                  @Parameter(description = "идентификатор товара") UUID id){
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }

    /**
     * Удаляет товар по id.
     *
     * @param id идентификатор товара.
     * @return HTTP статус без контента.
     */
    @Operation(summary = "удалить товар по id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable
                              @Parameter(description = "идентификатор товара") UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
