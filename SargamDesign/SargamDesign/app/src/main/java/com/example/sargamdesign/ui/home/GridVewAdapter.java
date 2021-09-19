package com.example.sargamdesign.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargamdesign.R;

public class GridVewAdapter extends BaseAdapter {
    private Context mContext;

    private final String[] web;
    private final int[] Imageid;

    public GridVewAdapter(Context mContext, String[] web, int[] imageid) {
        this.mContext = mContext;
        this.web = web;
        Imageid = imageid;
    }

    public GridVewAdapter(String[] web, int[] imageid) {
        this.web = web;
        Imageid = imageid;
    }

    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid ;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_gridview, null);

            TextView textView = (TextView) grid.findViewById(R.id.nam);
            ImageView imageView = (ImageView)grid.findViewById(R.id.img);

            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        }
        else{
            grid=(View)convertView;
        }
        return grid;
    }

}
