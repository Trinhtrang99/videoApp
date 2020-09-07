package com.example.videoapp.Context;

import java.io.Serializable;

public class Contect implements Serializable {
    private int id, publisher_id, content_type, tab;
    private String title, avatar;
    private int status, deleted, user_created, user_modified;
    private String date_created, date_modified;
    private int parent_id, lft, rgt, level;
    private int price;
    private String short_code, command_code, finished_message, help_message;
    private int icash;
    private String thumb;
    private String mp4;
    private int size;
    private String linkUtbe;

    public Contect(String title, String avatar, String date_created, String date_modified, String mp4, int size, String linkUtbe) {
        this.title = title;
        this.avatar = avatar;
        this.date_created = date_created;
        this.date_modified = date_modified;
        this.mp4 = mp4;
        this.size = size;
        this.linkUtbe = linkUtbe;
    }

    public Contect(int id, int publisher_id, int content_type, int tab, String title, String avatar, int status, int deleted, int user_created, int user_modified, String date_created, String date_modified, int parent_id, int lft, int rgt, int level, int price, String short_code, String command_code, String finished_message, String help_message, int icash, String thumb) {

        this.id = id;
        this.publisher_id = publisher_id;
        this.content_type = content_type;
        this.tab = tab;
        this.title = title;
        this.avatar = avatar;
        this.status = status;
        this.deleted = deleted;
        this.user_created = user_created;
        this.user_modified = user_modified;
        this.date_created = date_created;
        this.date_modified = date_modified;
        this.parent_id = parent_id;
        this.lft = lft;
        this.rgt = rgt;
        this.level = level;
        this.price = price;
        this.short_code = short_code;
        this.command_code = command_code;
        this.finished_message = finished_message;
        this.help_message = help_message;
        this.icash = icash;
        this.thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getUser_created() {
        return user_created;
    }

    public void setUser_created(int user_created) {
        this.user_created = user_created;
    }

    public int getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(int user_modified) {
        this.user_modified = user_modified;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public String getCommand_code() {
        return command_code;
    }

    public void setCommand_code(String command_code) {
        this.command_code = command_code;
    }

    public String getFinished_message() {
        return finished_message;
    }

    public void setFinished_message(String finished_message) {
        this.finished_message = finished_message;
    }

    public String getHelp_message() {
        return help_message;
    }

    public void setHelp_message(String help_message) {
        this.help_message = help_message;
    }

    public int getIcash() {
        return icash;
    }

    public void setIcash(int icash) {
        this.icash = icash;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLinkUtbe() {
        return linkUtbe;
    }

    public void setLinkUtbe(String linkUtbe) {
        this.linkUtbe = linkUtbe;
    }
}
