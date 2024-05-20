package et.telebof.types;

import java.io.Serializable;

public class EncryptedCredentials implements Serializable {
    private String data, hash, secret;

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

    public String getSecret() {
        return secret;
    }
}
