package ru.aservice.prod.exeption;

public class LanguageException extends Exception {
    public static <T> void requireLgnNonRu(T obj, String message) {
        if (!obj.equals("ru"))
            throw new IllegalArgumentException(message);
    }
}
