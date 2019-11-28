package com.example.tp1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.Collection;
import java.util.List;

public class MeteoAdapter extends ArrayAdapter<Jour> {

    public MeteoAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getPosition(Jour item) {
        return super.getPosition(item);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Jour getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public void addAll(Collection<? extends Jour> collection) {
        super.addAll(collection);
    }
}
