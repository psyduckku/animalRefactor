package com.refactor.animals.beans.dto;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Map;

@Data
public class ReplyParam {

    private int adt_id;
    private int reply_id;
    private String login_id;
    private String orderby;
    private boolean good;
    private boolean bad;
    private int good_count;
    private int bad_count;

}
