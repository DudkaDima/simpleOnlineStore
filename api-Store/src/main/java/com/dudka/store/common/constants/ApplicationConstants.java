package com.dudka.store.common.constants;

import jakarta.persistence.UniqueConstraint;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

/**
 * Contains various constants used in the messenger application.
 */
@UtilityClass
public class ApplicationConstants {

    /**
     * Inner utility class for validation-related constants.
     */
    @UtilityClass
    public class Validation {
        /**
         * A regular expression for validating email addresses.
         */
        public final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        public final Pattern EMAIL_PATTERN = Pattern.compile(Validation.EMAIL_REGEX);
    }


    /**
     * Inner utility class for web-related constants.
     */
    @UtilityClass
    public class Web {

        /**
         * Inner utility class for dto validation.
         */
        @UtilityClass
        public class DataValidation {
            public final int MIN_SIZE_OF_PASSWORD = 8;
            public final int MAX_SIZE_OF_PASSWORD = 255;
            public final int MIN_SIZE_OF_LOGIN = 3;
            public final int MAX_SIZE_OF_LOGIN = 50;
            public final int MIN_SIZE_OF_RATING = 0;
            public final int MAX_SIZE_OF_RATING = 10;
            public final int MIN_SIZE_OF_EMAIL = 4;
            public final int MAX_SIZE_OF_EMAIL = 100;
            public final int MIN_SIZE_OF_SURNAME = 1;
            public final int MAX_SIZE_OF_FIRSTNAME = 255;
            public final int MIN_SIZE_OF_FIRSTNAME = 1;
            public final int MAX_SIZE_OF_SURNAME = 255;
            public final int MIN_SIZE_OF_LASTNAME = 5;
            public final int MAX_SIZE_OF_LASTNAME = 255;
            public final int MIN_SIZE_OF_PHONE_NUMBER = 4;
            public final int MAX_SIZE_OF_PHONE_NUMBER = 15;
            public final int MIN_SIZE_OF_DATE_OF_BIRTH = 10;
            public final int MAX_SIZE_OF_DATE_OF_BIRTH = 10;
            public final int MIN_SIZE_OF_COUNTRY = 3;
            public final int MAX_SIZE_OF_COUNTRY = 100;
            public final int MIN_SIZE_OF_CITY = 3;
            public final int MAX_SIZE_OF_CITY = 100;

            public final int MIN_SIZE_DESCRIPTION = 10;
            public final int MAX_SIZE_DESCRIPTION = 5000;
            public final int MIN_SIZE_OF_FEEDBACK = 1;
            public final int MAX_SIZE_OF_FEEDBACK = 1000;
        }


    }

}
