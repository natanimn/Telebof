package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.File;

public class GetFile extends AbstractBaseRequest<GetFile, File> {

    public GetFile(String fileId, RequestSender requestSender) {
        super(requestSender, "getFile", File.class);
        add("file_id", fileId);
    }

}
