package com.dudka.store.common.validator;


import com.dudka.store.common.constants.ApplicationConstants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NonNull;

/**
 * Class validate an email address using a regular expression.
 * The class implements the {@link ConstraintValidator} interface.
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(@NonNull final String email,
                           @NonNull final ConstraintValidatorContext context) {
        return validateEmail(email);
    }

    private boolean validateEmail(@NonNull final String email) {
        final var matcher = ApplicationConstants.Validation.EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
