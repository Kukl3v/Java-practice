package ru.kukl3v.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Контроллер глобальной обработки исключений.
 */
@RestControllerAdvice
public class AdviceController {

    /**
     * Обрабатывает исключение {@link NotFoundException}, возвращая HTTP статус 404.
     *
     * @param throwable выброшенное исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(Throwable throwable) {
        return new ResponseEntity<>(throwable.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает исключение {@link MethodArgumentNotValidException}, возвращая HTTP статус 400.
     *
     * @param throwable выброшенное исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleDataIntegrityViolationException(Throwable throwable) {
        return new ResponseEntity<>(throwable.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Обрабатывает любое исключение, возвращая HTTP статус 500.
     *
     * @param throwable выброшенное исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleAnyException(Throwable throwable) {
        return new ResponseEntity<>(throwable.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
