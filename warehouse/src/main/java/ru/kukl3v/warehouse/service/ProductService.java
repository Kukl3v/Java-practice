package ru.kukl3v.warehouse.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kukl3v.warehouse.domain.Product;
import ru.kukl3v.warehouse.dto.ProductDTO;
import ru.kukl3v.warehouse.exception.NotFoundException;
import ru.kukl3v.warehouse.mapper.ProductMapper;
import ru.kukl3v.warehouse.repository.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Бизнес-логига для товаров.
 */
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(readOnly = true)
public class ProductService {
    ProductMapper productMapper;
    ProductRepository productRepository;

    /**
     * Реализует логику получения списка товаров.
     *
     * @param pageable параметры пагинации.
     * @return список dto товаров.
     */
    public List<ProductDTO> getProductList(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.stream().map(productMapper::toDTO).toList();
    }

    /**
     * Реализует логику нахождения товара по id.
     *
     * @param id идентификатор товара.
     * @return товар.
     */
    public ProductDTO findProduct(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(Product.class, id));
    }

    /**
     * Реализует логику создания товара.
     *
     * @param productDTO данные создаваемого товара.
     */
    @Transactional
    public void createProduct(ProductDTO productDTO){
        Product product = productMapper.toProduct(productDTO);
        product.setLastQuantityUpdate(LocalDateTime.now());
        product.setDateCreated(LocalDate.now());
        productRepository.save(product);
    }
    /**
     * Реализует логику изменения товара по id.
     *
     * @param productDTO данные создаваемого товара.
     * @param id идентификатор товара.
     */
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO, UUID id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Product.class, id));
        if (!product.getQuantity().equals(productDTO.getQuantity())) {
            product.setLastQuantityUpdate(LocalDateTime.now());
        }
        product.setName(productDTO.getName());
        product.setArticleNumber(productDTO.getArticleNumber());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return productMapper.toDTO(productRepository.save(product));
    }

    /**
     * Реализует логику удаления товара по id.
     *
     * @param id идентификатор товара.
     */
    @Transactional
    public void deleteProduct(UUID id){
        if (!productRepository.existsById(id)) {
            throw new NotFoundException(Product.class, id);
        }
        productRepository.deleteById(id);
    }
}
