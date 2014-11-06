package com.example.busfsetdroid.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by kenob on 11/6/14.
 */
@Parcel
public class ResultResponse {
        @SerializedName("message")
        private String message;
        public String getMessage() {
            return message;
        }

}
