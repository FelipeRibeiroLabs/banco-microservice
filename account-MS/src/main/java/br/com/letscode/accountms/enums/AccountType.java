package br.com.letscode.accountms.enums;

import java.util.Arrays;

public enum AccountType {

    PF,
    PJ;

    public static AccountType getEnum(String name) {
        return Arrays.stream(values()).filter(
                        e -> e.name().equals(name))
                .findFirst().orElse(null);
    }
}
