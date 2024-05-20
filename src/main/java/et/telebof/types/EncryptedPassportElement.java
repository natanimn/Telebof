package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class EncryptedPassportElement extends JsonSerializable implements Serializable {
    private String type, data, phone_number, email;
    private List<PassportFile> files;
    private PassportFile front_side, reverse_side, selfie;
    private List<PassportFile> translation;
    private String hash;

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public List<PassportFile> getFiles() {
        return files;
    }

    public PassportFile getFrontSide() {
        return front_side;
    }

    public PassportFile getSelfie() {
        return selfie;
    }

    public List<PassportFile> getTranslation() {
        return translation;
    }

    public String getHash() {
        return hash;
    }

    public PassportFile getReverseSide() {
        return reverse_side;
    }

    public String getEmail() {
        return email;
    }

}
