package et.telebof.types;

import java.io.File;

public class InputFile{
    public File file;
    public String contentType;

    public InputFile(File file, String contentType){
        this.file = file;
        this.contentType = contentType;
    }
}
