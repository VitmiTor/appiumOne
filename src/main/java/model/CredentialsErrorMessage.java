package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Errors")
public class CredentialsErrorMessage {
    @ExcelCellName("Key")
    private String key;
    @ExcelCellName("ErrorMessage")
    private String errorMessage;

    public String getKey() {
        return key;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
