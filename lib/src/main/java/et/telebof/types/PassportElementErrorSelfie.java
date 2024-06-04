package et.telebof.types;

public class PassportElementErrorSelfie extends PassportElementError {
    public PassportElementErrorSelfie(String source, String type, String fileHash, String message) {
        super(source, type, fileHash, message);
    }
}
