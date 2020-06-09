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
package com.example.android.ranky;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<information>> {
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private String myUrl="http://api.sportradar.us/tennis-t2/en/players/rankings.json?api_key=5jxgmpfx5rskbgnt27kbd6jz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            android.app.LoaderManager loaderManager = getLoaderManager();


            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            TextView mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

    }

    @NonNull
    @Override
    public Loader<List<information>> onCreateLoader(int id, @Nullable Bundle args) {
        return new newsLoader(this, myUrl);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<information>> loader, final List<information> data) {
        if (data == null) {
            return;
        }
        // Find a reference to the {@link ListView} in the layout
        myadapter adapter1 =
                new myadapter(MainActivity.this, data);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setEmptyView(findViewById(R.id.empty_view));

        TextView textView = (TextView) findViewById(R.id.empty_view);
        textView.setText("No earthquakes found");

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading_indicator);
        progressBar.setVisibility(View.GONE);


        listView.setAdapter(adapter1);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<information>> loader) {

    }


}