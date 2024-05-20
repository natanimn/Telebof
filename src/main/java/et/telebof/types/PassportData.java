package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class PassportData extends JsonSerializable implements Serializable {
    public List<EncryptedPassportElement> data;
    public EncryptedCredentials credentials;
}
