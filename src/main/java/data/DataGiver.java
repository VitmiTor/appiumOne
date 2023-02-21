package data;

import model.Credentials;
import model.CredentialsErrorMessage;

public class DataGiver {
    private final ExcelReader excelReader = new ExcelReader();
    private final MapParser mapParser = new MapParser();

    public Credentials getValidCredentials() {
        return mapParser.getCredentials().get("valid");
    }

    public Credentials getInValidCredentials() {
        return mapParser.getCredentials().get("invalid");
    }

    public Credentials getLockedCredentials() {
        return mapParser.getCredentials().get("locked");
    }

    public CredentialsErrorMessage getInvalidErrorText() {
        return mapParser.getErrorsText().get("invalid");
    }

    public String getLockedErrorText() {
        return mapParser.getErrorsText().get("locked").getErrorMessage();
    }
}
