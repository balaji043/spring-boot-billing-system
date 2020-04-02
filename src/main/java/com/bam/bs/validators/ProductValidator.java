package com.bam.bs.validators;

import com.bam.bs.dto.ProductDto;
import com.bam.bs.util.Utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Qualifier("ProductValidator")
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (Utils.isNullOrEmpty(productDto.getDescription())) {
            errors.rejectValue("Description", "Can not be Null or Empty");
        }
    }

}