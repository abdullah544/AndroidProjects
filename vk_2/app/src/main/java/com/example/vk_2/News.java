package com.example.vk_2;

import android.os.Parcel;

import java.io.Serializable;

public class News implements Serializable {

    private String postHead;
    private String postDate;
    private int accImage;
    private int postPhoto;
    private String postText;
    private int likeNum;
    private int comNum;
    private int replyNum;
    static CharSequence Creator;
    private int liked;

    public News(int accImage, int postPhoto, String postHead, String postDate, String postText, int likeNum, int comNum, int replyNum, int liked) {
        this.accImage = accImage;
        this.postPhoto = postPhoto;
        this.postHead = postHead;
        this.postDate = postDate;
        this.postText = postText;
        this.likeNum = likeNum;
        this.comNum = comNum;
        this.replyNum = replyNum;
        this.liked = liked;
    }

    public void setPostHead(String postHead) {
        this.postHead = postHead;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public void setAccImage(int accImage) {
        this.accImage = accImage;
    }

    public void setPostPhoto(int postPhoto) {
        this.postPhoto = postPhoto;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public void setComNum(int comNum) {
        this.comNum = comNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public int getAccImage() {
        return accImage;
    }

    public int getPostPhoto() {
        return postPhoto;
    }

    public String getPostHead() {
        return postHead;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getPostText() {
        return postText;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public int getComNum() {
        return comNum;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getLiked() {
        return liked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("News{");

        sb.append("postHead='").append(postHead).append('\'');
        sb.append(", postDate='").append(postDate).append('\'');
        sb.append(", accImage='").append(accImage).append('\'');
        sb.append(", postPhoto='").append(postPhoto).append('\'');
        sb.append(", postText='").append(postText).append('\'');
        sb.append(", likeNum='").append(likeNum).append('\'');
        sb.append(", comNum='").append(comNum).append('\'');
        sb.append(", replyNum='").append(replyNum).append('\'');
        sb.append('}');
        return sb.toString();
    }

//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(this.postHead);
//        dest.writeString(this.postDate);
//        dest.writeInt(this.accImage);
//        dest.writeInt(this.postPhoto);
//        dest.writeString(this.postText);
//        dest.writeInt(this.likeNum);
//        dest.writeInt(this.comNum);
//        dest.writeInt(this.replyNum);
//    }

    protected News(Parcel in){
        this.postHead = in.readString();
        this.postDate = in.readString();
        this.accImage = in.readInt();
        this.postPhoto = in.readInt();
        this.postText = in.readString();
        this.likeNum = in.readInt();
        this.comNum = in.readInt();
        this.replyNum = in.readInt();
        this.liked = in.readInt();
    }

//    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>(){
//
//        public News createFromParcel(Parcel source){
//            return new News(source);
//        }
//
//        public News[] newArray(int size){
//            return new News[size];
//        }
//    };
}
