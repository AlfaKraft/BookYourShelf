package com.tieto.bookyourshelf.library.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.apache.commons.beanutils.BeanUtils;


public class PasswordsEqualConstraintValidator implements
        ConstraintValidator<PasswordsEqualConstraint, Object> {

    private String baseFieldName;
    private String matchFieldName;
    private String message;

    @Override
    public void initialize(final PasswordsEqualConstraint constraintAnnotation) {
        baseFieldName = constraintAnnotation.baseField();
        matchFieldName = constraintAnnotation.matchField();
        message = constraintAnnotation.message();
    }


   @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {  boolean valid = true;
        try
        {
            final Object firstObj = BeanUtils.getProperty(value, baseFieldName);
            final Object secondObj = BeanUtils.getProperty(value, matchFieldName);

           valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(baseFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}

