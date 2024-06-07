package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.UserProfilePhotos;

public class GetUserProfilePhotos extends AbstractBaseRequest<GetUserProfilePhotos, UserProfilePhotos> {

    public GetUserProfilePhotos(long userId, RequestSender requestSender) {
        super(requestSender, "getUserProfilePhotos");
        add("user_id", userId);
    }

    public GetUserProfilePhotos offset(int offset) {
        return add("offset", offset);
    }

    public GetUserProfilePhotos limit(int limit) {
        return add("limit", limit);
    }

    @Override
    public UserProfilePhotos exec() {
        return Util.parse(requestSender.makeRequest(this), UserProfilePhotos.class);
    }
}
