package data;

import model.Credentials;
import model.CredentialsErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class MapParser {

    private final ExcelReader excelReader = new ExcelReader();

    public Map<String, Credentials> getCredentials() {
        final var map = new HashMap<String, Credentials>();
        final var credentialList = excelReader.getCredentialsModel();
        for (var credentials : credentialList) {
            map.put(credentials.getKey(), credentials);
        }
        return map;
    }

    public Map<String, CredentialsErrorMessage> getErrorsText() {
        final var map = new HashMap<String, CredentialsErrorMessage>();
        final var errorsList = excelReader.getErrorMessages();
        for (var credentialsList : errorsList) {
            map.put(credentialsList.getKey(), credentialsList);
        }
        return map;
    }
}
