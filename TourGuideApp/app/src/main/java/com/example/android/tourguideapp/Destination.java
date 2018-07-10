/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.tourguideapp;

/**
 * {@link Destination} represents a destination that the user wants to go to.
 * It contains resource IDs for the destination's name, location, opening time, closing time and
 * optional image file for that destination.
 */
public class Destination {

    /**
     * String resource ID for the destination's name
     */
    private int mDestinationNameId;

    /**
     * String resource ID for the destination's location
     */
    private int mLocationId;

    /**
     * String resource ID for the destination's opening time
     */
    private int mOpenId;

    /**
     * String resource ID for the destination's closing time
     */
    private int mCloseId;

    /**
     * Image resource ID for the destination
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Destination object.
     *
     * @param destinationNameId is the string resource ID for the destination's name
     * @param locationId        is the string resource ID for the destination's location
     * @param openId            is the string resource ID for the destination's opening time
     * @param closeId           is the string resource ID for the destination's closing time
     */
    public Destination(int destinationNameId, int locationId, int openId, int closeId) {
        mDestinationNameId = destinationNameId;
        mLocationId = locationId;
        mOpenId = openId;
        mCloseId = closeId;
    }

    /**
     * Create a new Destination object.
     *
     * @param destinationNameId is the string resource ID for the destination's name
     * @param locationId        is the string resource ID for the destination's location
     * @param openId            is the string resource ID for the destination's opening time
     * @param closeId           is the string resource ID for the destination's closing time
     * @param imageResourceId   is the drawable resource ID for the image associated with the word
     */
    public Destination(int destinationNameId, int locationId, int openId, int closeId, int imageResourceId) {
        mDestinationNameId = destinationNameId;
        mLocationId = locationId;
        mOpenId = openId;
        mCloseId = closeId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the destination's name.
     */
    public int getDestinationNameId() {
        return mDestinationNameId;
    }

    /**
     * Get the string resource ID for the destination's location.
     */
    public int getLocationId() {
        return mLocationId;
    }

    /**
     * Get the string resource ID for the destination's opening time.
     */
    public int getOpenId() {
        return mOpenId;
    }

    /**
     * Get the string resource ID for the destination's closing time.
     */
    public int getCloseId() {
        return mCloseId;
    }

    /**
     * Return the image resource ID of the destination.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}