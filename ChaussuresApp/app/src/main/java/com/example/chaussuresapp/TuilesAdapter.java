package com.example.chaussuresapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaussuresapp.Class.Tuile;

public class TuilesAdapter extends BaseAdapter{
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

            final ImageView imageViewChaussure = (ImageView)convertView.findViewById(R.id.imageview_photo_chaussure);
            final TextView auteurTextView = (TextView) convertView.findViewById(R.id.textview_annonce_auteur);
            final TextView titreTextView = (TextView) convertView.findViewById(R.id.textview_annonce_titre);

            final ViewHolder viewHolder = new ViewHolder(imageViewChaussure, titreTextView, auteurTextView);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.imgView.setImageResource(tuile.getImgId());
        viewHolder.titreAnnonceView.setText(tuile.getTitreAnnonce());
        viewHolder.auteurAnnonceView.setText(tuile.getAuteurAnnonce());

        return convertView;
    }

    private class ViewHolder {
        private final ImageView imgView;
        private final TextView titreAnnonceView;
        private final TextView auteurAnnonceView;

        public ViewHolder(ImageView imgView, TextView titreAnnonceView, TextView auteurAnnonceView) {
            this.imgView = imgView;
            this.titreAnnonceView = titreAnnonceView;
            this.auteurAnnonceView = auteurAnnonceView;
        }
    }
}
