package com.example.chaussuresapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
        final Tuile tuile = tuiles[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_tuile, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_photo_chaussure);
        final TextView titreTextView = (TextView)convertView.findViewById(R.id.textview_annonce_titre);
        final TextView auteurTextView = (TextView)convertView.findViewById(R.id.textview_annonce_auteur);

        imageView.setImageResource(tuile.getImgId());
        titreTextView.setText(tuile.getTitreAnnonce());
        auteurTextView.setText(tuile.getAuteurAnnonce());

        return convertView;
    }
}
