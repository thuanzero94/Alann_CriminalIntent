package com.foxconn.alan.alann_criminalintent;

import java.util.UUID;

/**
 * Created by alan on 01/03/2018.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime(){
        // Generate unique identifier
        mId = UUID.randomUUID();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }
}
