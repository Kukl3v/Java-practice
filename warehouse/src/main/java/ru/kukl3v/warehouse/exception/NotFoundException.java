package ru.kukl3v.warehouse.exception;

import java.util.UUID;

/**
 * Кастомное исключение, выбрасываемое при отсутствии объекта с заданным идентификатором.
 */
public class NotFoundException extends RuntimeException {
    /**
     * Создает исключение с сообщением о ненайденном объекте.
     *
     * @param clazz класс объекта.
     * @param id идентификатор объекта.
     */
    public <T> NotFoundException(Class<T> clazz, UUID id) {
        super(String.format("%s с id [%s] не найден или не существует", clazz.getSimpleName(), id));
    }
}
