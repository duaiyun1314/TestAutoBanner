package com.example.andy.testautobanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.andy.autoscrollbanner.switchadapter.SwitchAdapter;
import com.andy.autoscrollbanner.views.SwitchView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SwitchView switchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageUtils.initImageLoader(this);
        setContentView(R.layout.activity_main);
        switchView = (SwitchView) findViewById(R.id.switchview);
        switchView.setAdaper(new BannerAdapter(this));
        switchView.update(initData());
    }

    private List initData() {
        List<Banner> banners = new ArrayList<>();
        Banner banner1 = new Banner();
        banner1.setTitle("爱上你是我的错");
        banner1.setUrl("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
        Banner banner2 = new Banner();
        banner2.setTitle("也许放手才是一种解脱");
        banner2.setUrl("http://pic38.nipic.com/20140220/10894663_163128691102_2.jpg");
        Banner banner3 = new Banner();
        banner3.setTitle("世界第一等");
        banner3.setUrl("http://pic29.nipic.com/20130531/3822951_163214746000_2.jpg");
        Banner banner4 = new Banner();
        banner4.setTitle("最后的战役");
        banner4.setUrl("http://pic28.nipic.com/20130421/12105533_205223304174_2.jpg");
        banners.add(banner1);
        banners.add(banner2);
        banners.add(banner3);
        banners.add(banner4);
        return banners;
    }
}
