package com.bam.bs.validators;

import java.util.Objects;

import com.bam.bs.dto.BillDto;
import com.bam.bs.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@Qualifier("SaveBillRequestValidator")
public class SaveBillRequestValidator implements Validator {

    @Autowired
    @Qualifier("ProductValidator")
    private Validator productValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return BillDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BillDto billDto = (BillDto) target;
        if (Objects.isNull(billDto.getBillType())) {
            errors.rejectValue("BillType", "Cannot be Null");
        }
        if (Objects.isNull(billDto.getCreationDate())) {
            errors.rejectValue("CreationDate", "Cannot be Null");
        }
        if (Utils.isNullOrZero(billDto.getCustomerId())) {
            errors.rejectValue("CustomerId", "Cannot be Null or Less Than or Equal to Zero");
        }
        if (Utils.isNullOrZero(billDto.getUserId())) {
            errors.rejectValue("UserId", "Cannot be Null or Less Than or Equal to Zero");
        }
        billDto.getProducts().forEach(product -> ValidationUtils.invokeValidator(productValidator, product, errors));
    }

}