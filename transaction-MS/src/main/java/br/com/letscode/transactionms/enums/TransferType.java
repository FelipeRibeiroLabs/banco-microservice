package br.com.letscode.transactionms.enums;

import java.util.Arrays;

public enum TransferType {
    PIX,
    TED,
    DOC;

    public static TransferType getEnum(String name) {
        return Arrays.stream(values()).filter(
                        e -> e.name().equals(name))
                .findFirst().orElse(null);
    }
}
