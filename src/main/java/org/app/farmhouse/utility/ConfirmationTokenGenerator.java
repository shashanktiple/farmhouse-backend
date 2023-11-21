package org.app.farmhouse.utility;

import java.util.UUID;

public class ConfirmationTokenGenerator {

    public static String getEmailConfirmationToken(String value){
        return UUID.fromString(value.substring(0,value.indexOf("@"))).toString();
    }
}
