package com.greenart.vo;

public class CategoryVO {
    private Integer bi_seq;
    private String bi_name;
    private Integer bi_parent_seq;
    private String bi_url;

    public String getBi_url() {
        return this.bi_url;
    }

    public void setBi_url(String bi_url) {
        this.bi_url = bi_url;
    }

    public Integer getBi_seq() {
        return this.bi_seq;
    }

    public void setBi_seq(Integer bi_seq) {
        this.bi_seq = bi_seq;
    }

    public String getBi_name() {
        return this.bi_name;
    }

    public void setBi_name(String bi_name) {
        this.bi_name = bi_name;
    }

    public Integer getBi_parent_seq() {
        return this.bi_parent_seq;
    }

    public void setBi_parent_seq(Integer bi_parent_seq) {
        this.bi_parent_seq = bi_parent_seq;
    }

}
