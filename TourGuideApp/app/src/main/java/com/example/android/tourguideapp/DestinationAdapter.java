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

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link DestinationAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Destination} objects.
 */
public class DestinationAdapter extends ArrayAdapter<com.example.android.tourguideapp.Destination> {

    /**
     * Resource ID for the background color for this list of destinations
     */
    private int mColorResourceId;

    /**
     * Create a new {@link DestinationAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param destinations    is the list of {@link Destination}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list
     */
    public DestinationAdapter(Context context, ArrayList<com.example.android.tourguideapp.Destination>
            destinations, int colorResourceId) {
        super(context, 0, destinations);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Destination} object located at this position in the list
        com.example.android.tourguideapp.Destination currentDestination = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID Destination name.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.destination_name_view);
        // Get the Destination's name from the currentDestination object and set this text on
        // the Destination Name TextView.
        nameTextView.setText(currentDestination.getDestinationNameId());

        // Find the TextView in the list_item.xml layout with the ID Destination location.
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_view);
        // Get the Destination's location from the currentDestination object and set this text on
        // the Destination Location TextView.
        locationTextView.setText(currentDestination.getLocationId());

        // Find the TextView in the list_item.xml layout with the ID Destination opening time.
        TextView openTextView = (TextView) listItemView.findViewById(R.id.opening_time_view);
        // Get the Destination's opening time from the currentDestination object and set this text on
        // the Destination Open TextView.
        openTextView.setText(currentDestination.getOpenId());

        // Find the TextView in the list_item.xml layout with the ID Destination closing time.
        TextView closeTextView = (TextView) listItemView.findViewById(R.id.closing_time_view);
        // Get the Destination's closing time from the currentDestination object and set this text on
        // the Destination Close TextView.
        closeTextView.setText(currentDestination.getCloseId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentDestination.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentDestination.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 4 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}