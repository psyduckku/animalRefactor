package com.refactor.animals.beans.entity;

import lombok.Data;

@Data
public class BookmarkList {
//BokmarkList에 다 넣지말고 필요한 것만 넣자.

    private String title;
    private String content;
    private String login_id;
    private String store_id;
    private String store_file_name;
    private boolean bookmark;

}
