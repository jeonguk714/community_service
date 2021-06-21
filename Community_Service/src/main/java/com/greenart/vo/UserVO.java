package com.greenart.vo;

public class UserVO {
    private Integer ui_seq;
    private String ui_id;
    private String ui_pwd;
    private String ui_name;
    private String ui_email;
    private Integer ui_user_type;
    private Integer ui_user_grade;
    private String ui_blog;
    private String ui_profile_img;
    private String ui_introduce;
    private String ui_ip;
    private String confirm_pwd;

    public String getConfirm_pwd() {
		return confirm_pwd;
	}

	public void setConfirm_pwd(String confirm_pwd) {
		this.confirm_pwd = confirm_pwd;
	}

	public Integer getUi_seq() {
        return this.ui_seq;
    }

    public void setUi_seq(Integer ui_seq) {
        this.ui_seq = ui_seq;
    }

    public String getUi_id() {
        return this.ui_id;
    }

    public void setUi_id(String ui_id) {
        this.ui_id = ui_id;
    }

    public String getUi_pwd() {
        return this.ui_pwd;
    }

    public void setUi_pwd(String ui_pwd) {
        this.ui_pwd = ui_pwd;
    }

    public String getUi_name() {
        return this.ui_name;
    }

    public void setUi_name(String ui_name) {
        this.ui_name = ui_name;
    }

    public String getUi_email() {
        return this.ui_email;
    }

    public void setUi_email(String ui_email) {
        this.ui_email = ui_email;
    }

    public Integer getUi_user_type() {
        return this.ui_user_type;
    }

    public void setUi_user_type(Integer ui_user_type) {
        this.ui_user_type = ui_user_type;
    }

    public Integer getUi_user_grade() {
        return this.ui_user_grade;
    }

    public void setUi_user_grade(Integer ui_user_grade) {
        this.ui_user_grade = ui_user_grade;
    }

    public String getUi_blog() {
        return this.ui_blog;
    }

    public void setUi_blog(String ui_blog) {
        this.ui_blog = ui_blog;
    }

    public String getUi_profile_img() {
        return this.ui_profile_img;
    }

    public void setUi_profile_img(String ui_profile_img) {
        this.ui_profile_img = ui_profile_img;
    }

    public String getUi_introduce() {
        return this.ui_introduce;
    }

    public void setUi_introduce(String ui_introduce) {
        this.ui_introduce = ui_introduce;
    }

    public String getUi_ip() {
        return this.ui_ip;
    }

    public void setUi_ip(String ui_ip) {
        this.ui_ip = ui_ip;
    }

}
