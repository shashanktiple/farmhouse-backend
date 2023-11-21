package org.app.farmhouse.service.email;

import org.app.farmhouse.modal.user.AccountVerification;


public class EmailTemplate {
    private final static String HOST_SERVER = "http://localhost:8090";
    private static String ACCOUNT_VERIFICATION_ENDPOINT = "/api/user/account/verification";
    private static String QEURY_PARAM = "?identifier=%s&confirmationtoken=%s";

    private static String generateVerificationURL(AccountVerification accountVerification) {
        StringBuilder builder = new StringBuilder();
        builder.append(HOST_SERVER).append(ACCOUNT_VERIFICATION_ENDPOINT).append(String.format(QEURY_PARAM, accountVerification.getUserIdentifier(), accountVerification.getToken()));
        return builder.toString();
    }

    public static String generateVerificationTemplate(AccountVerification accountVerification) {
        StringBuilder builder = new StringBuilder();
        builder.append("<h2> Your account has been created succesfully..!!</h2>");
        builder.append("<h3> Click on the below link to verify the account:</h3>");
        builder.append(generateVerificationURL(accountVerification));
        return builder.toString();
    }
}
