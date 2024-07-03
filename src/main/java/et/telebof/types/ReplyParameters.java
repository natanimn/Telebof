package et.telebof.types;

import et.telebof.enums.ParseMode;

import java.io.Serializable;
import java.util.List;

public class ReplyParameters implements Serializable {
    private int message_id;
    private Object chat_id;
    private Boolean allow_sending_without_reply;
    private String quote;
    private ParseMode quote_parse_mode;
    private MessageEntity[] quote_entities;
    private Integer quote_position;

    public ReplyParameters(int message_id){
        this.message_id = message_id;
    }

    public ReplyParameters chatId(Object chat_id){
        this.chat_id = chat_id;
        return this;
    }

    public ReplyParameters allowSendingWithoutReply(boolean allow_sending_without_reply){
        this.allow_sending_without_reply = allow_sending_without_reply;
        return this;
    }

    public ReplyParameters quote(String quote){
        this.quote = quote;
        return this;
    }

    public ReplyParameters quoteParseMode(ParseMode quote_parse_mode){
        this.quote = quote_parse_mode.name().toLowerCase();
        return this;
    }

    public ReplyParameters quoteEntities(MessageEntity[] quote_entities){
        this.quote_entities = quote_entities;
        return this;
    }

    public ReplyParameters quotePosition(Integer quote_position){
        this.quote_position = quote_position;
        return this;
    }

}
