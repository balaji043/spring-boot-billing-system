package com.bam.bs.config;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bam.bs.exception.CommonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeSerializer extends JsonDeserializer<Date> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext ctxt) throws IOException {
        try {
            return simpleDateFormat.parse(jsonparser.getText());
        } catch (ParseException e) {
            throw new CommonException("Error occured when Deserializing the date");
        }
    }
}