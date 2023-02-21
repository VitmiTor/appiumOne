package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Credentials")
public class Credentials {
    @ExcelCellName("Key")
    private String key;
    @ExcelCellName("username")
    private String username;
    @ExcelCellName("Password")
    private String password;

    public String getKey() {
        return key;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
