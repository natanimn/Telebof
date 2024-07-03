package et.telebof.types;

import et.telebof.enums.TypeReaction;

import java.io.Serializable;

public class ReactionType implements Serializable {
    public String type;
    public String emoji;
    public String custom_emoji_id;

    public ReactionType(TypeReaction reaction){
        this.type = reaction.name().toLowerCase();
    }

    public void emoji(String emoji){
        this.emoji = emoji;
    }

    public void customEmojiId(String custom_emoji_id){
        this.custom_emoji_id = custom_emoji_id;
    }
}
