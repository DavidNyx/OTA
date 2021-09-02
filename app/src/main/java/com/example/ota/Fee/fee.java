package com.example.ota.Fee;

public class fee {
    private String title;
    private String content;
    public fee(String content, String title){
        this.content=content;
        this.title=title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String Content) {
        this.content = Content;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
