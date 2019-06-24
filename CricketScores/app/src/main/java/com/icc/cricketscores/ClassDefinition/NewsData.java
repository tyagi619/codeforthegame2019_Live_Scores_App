package com.icc.cricketscores.ClassDefinition;

import java.io.Serializable;

public class NewsData implements Serializable {
    String title,description,source;
    String url,urlImage;
    String published,content;

    public NewsData() {
    }

    public NewsData(String title, String description, String source, String url, String urlImage, String published, String content) {
        this.title = title;
        this.description = description;
        this.source = source;
        this.url = url;
        this.urlImage = urlImage;
        this.published = published;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
