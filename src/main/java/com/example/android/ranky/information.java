package com.example.android.ranky;

public class information {
    private String name;
    private String rank;
    private String points;
    private String tournments;

    public information(String n, String r, String p, String t) {
        name = n;
        rank = r;
        points = p;
        tournments = t;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getPoints() {
        return points;
    }

    public String getTournments() {
        return tournments;
    }
}
