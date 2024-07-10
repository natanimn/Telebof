package et.telebof.types;

import java.io.File;
import java.io.Serializable;

public interface InputPaidMedia extends Serializable {
    boolean isFile();
    InputFile getInputFile();
    boolean hasThumbnailFile();
    InputFile getThumbnailFile();
}
