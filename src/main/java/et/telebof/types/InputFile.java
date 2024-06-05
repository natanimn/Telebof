package et.telebof.types;

import java.io.File;
public class InputFile{
    private File file;
    private String contentType;

    public InputFile(File file, String contentType){
        this.file = file;
        this.contentType = contentType;
    }

    public File getFile() {
        return file;
    }

    public String getContentType() {
        return contentType;
    }
}
