package com.permutassep.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by lalongooo on 01/03/15.
 */
public class Post {

    @SerializedName("user")
    private User mUser;
    @SerializedName("post")
    private String postText;
    @SerializedName("place_from_state")
    private short stateFrom;
    @SerializedName("place_from_city")
    private short cityFrom;
    @SerializedName("place_from_town")
    private short townFrom;
    @SerializedName("place_from_lat")
    private double latFrom;
    @SerializedName("place_from_lon")
    private double lonFrom;
    @SerializedName("place_to_state")
    private short stateTo;
    @SerializedName("place_to_city")
    private short cityTo;
    @SerializedName("place_to_town")
    private short townTo;
    @SerializedName("place_to_lat")
    private double latTo;
    @SerializedName("place_to_lon")
    private double lonTo;
    @SerializedName("workday_type")
    private String mWorkdayType;
    @SerializedName("position_type")
    private String mPositionType;
    @SerializedName("post_date")
    private Date mPostDate;
    @SerializedName("is_teaching_career")
    private boolean mIsTeachingCareer;


    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        this.mUser = user;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public short getStateFrom() {
        return stateFrom;
    }

    public void setStateFrom(short stateFrom) {
        this.stateFrom = stateFrom;
    }

    public short getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(short cityFrom) {
        this.cityFrom = cityFrom;
    }

    public short getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(short townFrom) {
        this.townFrom = townFrom;
    }

    public double getLatFrom() {
        return latFrom;
    }

    public void setLatFrom(double latFrom) {
        this.latFrom = latFrom;
    }

    public double getLonFrom() {
        return lonFrom;
    }

    public void setLonFrom(double lonFrom) {
        this.lonFrom = lonFrom;
    }

    public short getStateTo() {
        return stateTo;
    }

    public void setStateTo(short stateTo) {
        this.stateTo = stateTo;
    }

    public short getCityTo() {
        return cityTo;
    }

    public void setCityTo(short cityTo) {
        this.cityTo = cityTo;
    }

    public short getTownTo() {
        return townTo;
    }

    public void setTownTo(short townTo) {
        this.townTo = townTo;
    }

    public double getLatTo() {
        return latTo;
    }

    public void setLatTo(double latTo) {
        this.latTo = latTo;
    }

    public double getLonTo() {
        return lonTo;
    }

    public void setLonTo(double lonTo) {
        this.lonTo = lonTo;
    }

    public String getPositionType() {
        return mPositionType;
    }

    public void setPositionType(String positionType) {
        this.mPositionType = positionType;
    }

    public String getWorkdayType() {
        return mWorkdayType;
    }

    public void setWorkdayType(String workdayType) {
        this.mWorkdayType = workdayType;
    }

    public boolean isTeachingCareer() {
        return mIsTeachingCareer;
    }

    public void setIsTeachingCareer(boolean isTeachingCareer) {
        this.mIsTeachingCareer = isTeachingCareer;
    }

    public Date getPostDate() {
        return mPostDate;
    }

    public void setPostDate(Date postDate) {
        this.mPostDate = postDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "mUser=" + mUser +
                ", postText='" + postText + '\'' +
                ", stateFrom=" + stateFrom +
                ", cityFrom=" + cityFrom +
                ", townFrom=" + townFrom +
                ", latFrom=" + latFrom +
                ", lonFrom=" + lonFrom +
                ", stateTo=" + stateTo +
                ", cityTo=" + cityTo +
                ", townTo=" + townTo +
                ", latTo=" + latTo +
                ", lonTo=" + lonTo +
                ", mWorkdayType='" + mWorkdayType + '\'' +
                ", mPositionType='" + mPositionType + '\'' +
                ", mPostDate=" + mPostDate +
                ", mIsTeachingCareer=" + mIsTeachingCareer +
                '}';
    }
}