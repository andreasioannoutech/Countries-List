package com.kikkos.retrofit.ui;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.kikkos.retrofit.R;
import com.kikkos.retrofit.data.Country;

import java.io.InputStream;
import java.util.List;

/**
 * Created by kikkos on 31/03/2017.
 */

public class CountriesRecyclerAdaptor extends RecyclerView.Adapter<CountriesRecyclerAdaptor.ViewHolder> {

    List<Country> mCountries;
    private Context mContext;
    private final GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mCountryName;
        private final ImageView mFlagImage;

        public ViewHolder(View view) {
            super(view);
            mCountryName = (TextView) view.findViewById(R.id.country_name);
            mFlagImage = (ImageView) view.findViewById(R.id.flag);
        }
    }

    public CountriesRecyclerAdaptor(Context context) {
        this.mContext = context;
        requestBuilder = Glide.with(mContext)
                .using(Glide.buildStreamModelLoader(Uri.class, mContext), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .placeholder(R.color.colorPrimary)
                .listener(new SvgSoftwareLayerSetter<Uri>());
    }

    public void swapItems(List<Country> list) {
        this.mCountries = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mCountryName.setText(mCountries.get(position).getName());

        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .load(Uri.parse(mCountries.get(position).getFlag()))
                .into(holder.mFlagImage);
    }

    @Override
    public int getItemCount() {
        if (mCountries != null && mCountries.size() > 0) {
            return mCountries.size();
        }
        return 0;
    }
}
