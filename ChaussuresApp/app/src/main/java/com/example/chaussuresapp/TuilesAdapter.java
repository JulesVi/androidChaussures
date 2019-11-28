package com.example.chaussuresapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chaussuresapp.Class.Tuile;

public class TuilesAdapter extends BaseAdapter {
    private final Context mContext;
    private final Tuile[] tuiles;

    public TuilesAdapter(Context context, Tuile[] tuiles) {
        this.mContext = context;
        this.tuiles = tuiles;
    }

    @Override
    public int getCount() {
        return tuiles.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView testTextView = new TextView(mContext);
        testTextView.setText(String.valueOf((position)));
        return testTextView;
    }
}
