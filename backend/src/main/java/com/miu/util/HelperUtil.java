package com.miu.util;

import java.util.UUID;

public class HelperUtil {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

}
