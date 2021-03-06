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

    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ListView;

    import java.util.ArrayList;

    /**
     * {@link Fragment} that displays a list of coffee shops.
     */

    public class CoffeeShopsFragment extends Fragment {

        public CoffeeShopsFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.attraction_list, container, false);

            // Create a list of destinations
            final ArrayList<Destination> destinations = new ArrayList<Destination>();
            destinations.add(new Destination(R.string.coffeeshop_name, R.string.coffeeshop_location,
                    R.string.coffeeshop_open, R.string.coffeeshop_close, R.drawable.ic_coffeeshop));
            destinations.add(new Destination(R.string.coffeeshop_name2, R.string.coffeeshop_location2,
                    R.string.coffeeshop_open2, R.string.coffeeshop_close2, R.drawable.ic_coffeeshop));
            destinations.add(new Destination(R.string.coffeeshop_name3, R.string.coffeeshop_location3,
                    R.string.coffeeshop_open3, R.string.coffeeshop_close3, R.drawable.ic_coffeeshop));

            // Create an {@link DestinationAdapter}, whose data source is a list of {@link Destination}s. The
            // adapter knows how to create list items for each item in the list.
            DestinationAdapter adapter = new DestinationAdapter(getActivity(), destinations, R.color.category_coffeeshop);

            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // word_list.xml layout file.
            ListView listView = (ListView) rootView.findViewById(R.id.list);

            // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
            // {@link ListView} will display list items for each {@link Word} in the list.
            listView.setAdapter(adapter);
            return rootView;
        }
    }