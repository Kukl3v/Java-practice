package ru.kukl3v.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс запуска приложения.
 */
@SpringBootApplication
public class WarehouseApplication {

	/**
	 * Точка входа в приложение.
	 */
	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

}
