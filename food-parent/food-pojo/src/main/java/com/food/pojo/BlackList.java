package com.food.pojo;

import java.io.Serializable;

public class BlackList implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blacklist.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blacklist.bid
     *
     * @mbggenerated
     */
    private Integer bid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blacklist.uid
     *
     * @return the value of blacklist.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blacklist.uid
     *
     * @param uid the value for blacklist.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blacklist.bid
     *
     * @return the value of blacklist.bid
     *
     * @mbggenerated
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blacklist.bid
     *
     * @param bid the value for blacklist.bid
     *
     * @mbggenerated
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }
}