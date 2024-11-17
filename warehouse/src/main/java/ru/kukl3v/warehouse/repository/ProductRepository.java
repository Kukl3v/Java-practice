package ru.kukl3v.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kukl3v.warehouse.domain.Product;

import java.util.UUID;

/**
 * Репозиторий для сущности {@link Product}.
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
