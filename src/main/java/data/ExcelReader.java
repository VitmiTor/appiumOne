package data;

import com.poiji.bind.Poiji;
import model.Credentials;
import model.CredentialsErrorMessage;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String excelPath = "src/test/resources/data/DataTest.xlsx";

    public List<Credentials> getCredentialsModel() {
        return Poiji.fromExcel(new File(excelPath), Credentials.class);
    }

    public List<CredentialsErrorMessage> getErrorMessages() {
        return Poiji.fromExcel(new File(excelPath), CredentialsErrorMessage.class);
    }
}
