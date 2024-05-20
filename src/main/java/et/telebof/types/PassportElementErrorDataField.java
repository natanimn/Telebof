package et.telebof.types;

public class PassportElementErrorDataField extends PassportElementError {
    private String data_hash, field_name;
    public PassportElementErrorDataField(String source, String type, String fieldName, String dataHash, String message) {
        super(source, type, message);
        this.data_hash = dataHash;
        this.field_name = fieldName;
    }

}
