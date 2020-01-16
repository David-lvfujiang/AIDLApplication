package com.example.flycotablayoutapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/11/28
 * @Describe:
 */
public class User implements Parcelable {
    private String userName;
    private String age;

    public User(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.age);
    }

    protected User(Parcel in) {
        this.userName = in.readString();
        this.age = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}

