package et.telebof.enums;

public enum Updates{

    MESSAGE,
    CHANNEL_POST,
    EDITED_MESSAGE,
    EDITED_CHANNEL_POST,
    CALLBACK_QUERY,
    INLINE_QUERY,
    POLL,
    POLL_ANSWER,
    CHOSEN_INLINE_RESULT,
    SHIPPING_QUERY,
    PRE_CHECKOUT_QUERY,
    MY_CHAT_MEMBER,
    CHAT_MEMBER,
    CHAT_JOIN_REQUEST;

    public static final Updates[] ALL = {
            MESSAGE,
            CHANNEL_POST,
            EDITED_MESSAGE,
            EDITED_CHANNEL_POST,
            CALLBACK_QUERY,
            INLINE_QUERY,
            POLL,
            POLL_ANSWER,
            CHOSEN_INLINE_RESULT,
            SHIPPING_QUERY,
            PRE_CHECKOUT_QUERY,
            MY_CHAT_MEMBER,
            CHAT_MEMBER,
            CHAT_JOIN_REQUEST
    };
}
