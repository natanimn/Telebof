package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class EncryptedPassportElement extends JsonSerializable implements Serializable {
    public String type, data, phone_number, email;
    public List<PassportFile> files;
    public PassportFile front_side, reverse_side, selfie;
    public List<PassportFile> translation;
    public String hash;

}
