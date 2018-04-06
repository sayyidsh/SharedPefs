package pro.nanosystems.sharedpefs.model;

/**
 * Created by sayyid on 05/04/2018.
 */

public class Items {
    private String code;
    private String title;

    public Items() {
    }

    public Items(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
