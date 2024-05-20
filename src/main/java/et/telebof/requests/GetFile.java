package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.File;

public class GetFile extends AbstractBaseRequest<GetFile, File> {

    public GetFile(String fileId, RequestSender requestSender) {
        super(requestSender, "getFile");
        add("file_id", fileId);
    }

    public File bind() {
        return Parser.parse(requestSender.makeRequest(this), File.class);

    }
}
