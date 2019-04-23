package com.EmailClient.model;

import java.io.Serializable;

public class UserData implements Serializable {


    public String recipient;
    public String title;
    public String content;

    public UserData(final String recipient,
                    final String title,
                    final String content) {

        this.recipient = recipient;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "recipient='" + recipient + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
