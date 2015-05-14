package com.yjsoon.jokes;

/**
 * Created by yingjie on 14/5/15.
 */
public class Joke {

    private String mJoke;
    private String mPunchline;

    public Joke(String mJoke, String mPunchline) {
        this.mJoke = mJoke;
        this.mPunchline = mPunchline;
    }

    public String getJoke() {
        return mJoke;
    }

    public void setJoke(String mJoke) {
        this.mJoke = mJoke;
    }

    public String getPunchline() {
        return mPunchline;
    }

    public void setPunchline(String mPunchline) {
        this.mPunchline = mPunchline;
    }
}
