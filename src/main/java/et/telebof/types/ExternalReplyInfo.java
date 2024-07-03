package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class ExternalReplyInfo implements Serializable {
    public MessageOrigin origin;
    public Chat chat;
    public Integer message_id;
    public LinkPreviewOptions link_preview_options;
    public Animation animation;
    public Audio audio;
    public Document document;
    public List<PhotoSize> photo;
    public Sticker sticker;
    public Story story;
    public Video video;
    public VideoNote video_note;
    public Voice voice;
    public Contact contact;
    public Dice dice;
    public Game game;
    public Poll poll;
    public Venue venue;
    public Location location;
    public Invoice invoice;
    public Boolean has_media_spoiler;


}
