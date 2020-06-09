package com.example.android.ranky;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class newsLoader extends AsyncTaskLoader<List<information>> {

    private String mUrl;

    public newsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<information> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<information> newinformation = Querynews.fetchEarthquakeData(mUrl);
        return newinformation;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

