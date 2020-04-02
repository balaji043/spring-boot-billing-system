package com.bam.bs.util;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.bam.bs.exception.CommonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Utils
 */
@Slf4j
public class Utils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Utils() {

    }

    public static boolean isNullOrEmpty(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }

    public static boolean isNullOrEmpty(List<?> list) {
        return Objects.isNull(list) || list.isEmpty();
    }

    public static boolean isNullOrZero(Long longNumer) {
        return Objects.isNull(longNumer) || longNumer.intValue() <= 0;
    }

    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            log.error("{}", e);
            throw new CommonException("Error happened while reading from json");
        }
    }
}