package com.bam.bs.util;

import java.io.IOException;

import com.bam.bs.exception.CommonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Utils
 */
@Slf4j
public class Utils {

    private Utils() {

    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            log.error("{}", e);
            throw new CommonException("Error happened while reading from json");
        }
    }
}