package et.telebof.types;

public class PassportElementErrorUnspecified extends PassportElementError {
    private String element_hash;
    public PassportElementErrorUnspecified(String source, String type, String elementHash, String message) {
        super(source, type, message);
        this.element_hash = elementHash;
    }
}
