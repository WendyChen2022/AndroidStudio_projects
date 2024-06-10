package com.prog.easygeartrack;

public class ValidationUtils {

    // Validate the gear item details
    public static boolean validateGearItem(String name, String type, String condition) {
        return validateName(name) && validateType(type) && validateCondition(condition);
    }

    private static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private static boolean validateType(String type) {
        return type != null && !type.trim().isEmpty();
    }

    private static boolean validateCondition(String condition) {
        return condition != null && !condition.trim().isEmpty();
    }
}

