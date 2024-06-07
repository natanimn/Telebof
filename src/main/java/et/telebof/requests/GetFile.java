package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.File;

public class GetFile extends AbstractBaseRequest<GetFile, File> {

    public GetFile(String fileId, RequestSender requestSender) {
        super(requestSender, "getFile");
        add("file_id", fileId);
    }

    public File exec() {
        return Util.parse(requestSender.makeRequest(this), File.class);

    }
}
