package et.telebof.types;

import java.io.File;
import java.io.Serializable;

public interface  InputMedia {
    boolean isFile();
    InputFile getInputFile();
}
