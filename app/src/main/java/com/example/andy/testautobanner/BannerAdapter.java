package com.example.andy.testautobanner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andy.autoscrollbanner.switchadapter.SwitchAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by andy.wang on 2016/11/25.
 */

public class BannerAdapter extends SwitchAdapter<Banner> {
    public BannerAdapter(Activity context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        View view;
        Banner banner = datas.get(getPosition(position));
        String title = banner.getTitle();
        BannerItemHolder itemHolder;
        if (convertView == null) {
            itemHolder = new BannerItemHolder();
            view = View.inflate(context, R.layout.layout_banner_item, null);
            itemHolder.img = (SimpleDraweeView) view.findViewById(R.id.img);
            itemHolder.tv = (TextView) view.findViewById(R.id.title);
            view.setTag(itemHolder);
        } else {
            view = convertView;
            itemHolder = (BannerItemHolder) convertView.getTag();
        }
        itemHolder.tv.setText(title);
        String imageUrl = banner.getUrl();
        itemHolder.img.setAspectRatio(430 / 230f);
        new ImageLoadFresco.LoadImageFrescoBuilder(context, itemHolder.img, imageUrl)
                .build();
        return view;
    }

    private static class BannerItemHolder {
        public SimpleDraweeView img;
        public TextView tv;
    }
}
