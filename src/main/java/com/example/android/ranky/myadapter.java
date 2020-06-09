package com.example.android.ranky;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class myadapter extends ArrayAdapter<information> {
    public myadapter(Activity context, List<information> newinformation) {

        super(context, 0, newinformation);
    }

    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }
        information currentinformation = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.list_text1);

        title.setText(currentinformation.getName());

        TextView name = (TextView) listItemView.findViewById(R.id.list_text2);

        name.setText(currentinformation.getRank());


        TextView date = (TextView) listItemView.findViewById(R.id.list_text3);

        date.setText(currentinformation.getPoints());


        TextView time = (TextView) listItemView.findViewById(R.id.list_text4);

        time.setText(currentinformation.getTournments());


        return listItemView;
    }
}
