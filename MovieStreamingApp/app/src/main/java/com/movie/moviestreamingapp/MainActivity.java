package com.movie.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.movie.moviestreamingapp.adapter.BannerMoviePagerAdapter;
import com.movie.moviestreamingapp.adapter.MainRecyclerAdapter;
import com.movie.moviestreamingapp.model.AllCategory;
import com.movie.moviestreamingapp.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviePagerAdapter bannerMoviePagerAdapter;
    TabLayout tabIndicator;
    TabLayout tabCategory;
    ViewPager bannerMovieViewPager;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecyclerView;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> showsBannerList;
    List<BannerMovies> moviesBannerList;
    List<BannerMovies> kidsBannerList;
    List<AllCategory> allCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabIndicator = findViewById(R.id.tab_indicator);
        tabCategory = findViewById(R.id.tabLayout);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "Iron man", "https://wallpapers.com/images/high/iron-man-logo-movie-banner-7iwbb535sxko4a34.jpg", ""));
        homeBannerList.add(new BannerMovies(2, "The last ship", "https://4.bp.blogspot.com/-FApRuSIZLRA/W-i2luTZnlI/AAAAAAAB3e0/Aq7ZQ1BRhc0ADHEUa2tuate8RS8b5iWWQCLcBGAs/s1600/The%2BLast%2BShip%2B-%2BSeries%2BFinale%2B-%2BInterview%2Bwith%2BJocko%2BSims%2Ba.jpg", ""));
        homeBannerList.add(new BannerMovies(3, "Dr Strange", "https://whatsondisneyplus.com/wp-content/uploads/2020/04/doctorstrange-1024x576.jpg", ""));
        homeBannerList.add(new BannerMovies(4, "Lion King", "https://jccdallas.org/wp-content/uploads/2019/10/lion-king-banner.jpg", ""));
        homeBannerList.add(new BannerMovies(5, "Spider man", "https://ephoto360.com/uploads/worigin/2019/07/06/banner_1-min5d2016cb2f52f_bf8e0aa1ab695fd74e3deb674eb1a2e0.jpg", ""));
        setBannerMoviePagerAdapter(homeBannerList);

        showsBannerList = new ArrayList<>();
        showsBannerList.add(new BannerMovies(1, "7 nu cuoi xuan", "https://img.hplus.com.vn/728x409/banner/2018/04/23/120828-7-nu-cuoi-xuan-800.jpg", ""));
        showsBannerList.add(new BannerMovies(2, "Nguoi bi an", "https://upload.wikimedia.org/wikipedia/vi/thumb/1/1c/Nguoi_bi_an_%28logo%29.jpg/300px-Nguoi_bi_an_%28logo%29.jpg", ""));
        showsBannerList.add(new BannerMovies(3, "On gioi cau day roi", "https://upload.wikimedia.org/wikipedia/vi/f/f1/C%E1%BA%A3nh_t%E1%BB%B1a_%C4%91%E1%BB%81_c%E1%BB%A7a_%C6%A0n_gi%E1%BB%9Di_c%E1%BA%ADu_%C4%91%C3%A2y_r%E1%BB%93i.png", ""));
        showsBannerList.add(new BannerMovies(4, "7 nu cuoi xuan", "https://upload.wikimedia.org/wikipedia/vi/e/e8/RapViet2020.jpeg", ""));
        showsBannerList.add(new BannerMovies(5, "Sieu tri tue", "https://image.thanhnien.vn/w980/Uploaded/2022/wpdhnwejw/2020_11_14/viechannelhtv2photosgioithieusieutrituevietnam25_knjh.jpg", ""));

        moviesBannerList = new ArrayList<>();
        moviesBannerList.add(new BannerMovies(1, "Iron man", "https://wallpapers.com/images/high/iron-man-logo-movie-banner-7iwbb535sxko4a34.jpg", ""));
        moviesBannerList.add(new BannerMovies(2, "The last ship", "https://4.bp.blogspot.com/-FApRuSIZLRA/W-i2luTZnlI/AAAAAAAB3e0/Aq7ZQ1BRhc0ADHEUa2tuate8RS8b5iWWQCLcBGAs/s1600/The%2BLast%2BShip%2B-%2BSeries%2BFinale%2B-%2BInterview%2Bwith%2BJocko%2BSims%2Ba.jpg", ""));
        moviesBannerList.add(new BannerMovies(3, "Dr Strange", "https://whatsondisneyplus.com/wp-content/uploads/2020/04/doctorstrange-1024x576.jpg", ""));
        moviesBannerList.add(new BannerMovies(4, "Lion King", "https://jccdallas.org/wp-content/uploads/2019/10/lion-king-banner.jpg", ""));
        moviesBannerList.add(new BannerMovies(5, "Spider man", "https://ephoto360.com/uploads/worigin/2019/07/06/banner_1-min5d2016cb2f52f_bf8e0aa1ab695fd74e3deb674eb1a2e0.jpg", ""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "Kinh van hoa", "https://kenh14cdn.com/thumb_w/660/2019/10/3/156663348895513300-1570113053534655915637.jpg",""));
        kidsBannerList.add(new BannerMovies(2, "Tom and jerry", "https://o.rada.vn/data/image/2021/04/15/Bo-phim-tom-and-jerry.jpg",""));
        kidsBannerList.add(new BannerMovies(3, "Meo Oggy", "https://teddy.vn/wp-content/uploads/2019/04/meo-oggy-va-nhung-chu-gian-tinh-nghich-8-min.jpg",""));
        kidsBannerList.add(new BannerMovies(2, "Doraemon", "https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_thumbnails/doraemons9_07_horizontalposter-6c4d708980d3-1609395243354-9fo2xUfP.png",""));
        kidsBannerList.add(new BannerMovies(2, "Conan", "https://gamek.mediacdn.vn/133514250583805952/2021/10/13/photo-1-16341006858381776570478.jpeg",""));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "Hollywood"));
        allCategoryList.add(new AllCategory(2, "Kids"));
        setMainRecycler(allCategoryList);

        tabCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerMoviePagerAdapter(showsBannerList);
                        return;
                    case 2:
                        setBannerMoviePagerAdapter(moviesBannerList);
                        return;
                    case 3:
                        setBannerMoviePagerAdapter(kidsBannerList);
                        return;
                    default:
                        setBannerMoviePagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "Hollywood"));
        allCategoryList.add(new AllCategory(2, "Kids"));
        setMainRecycler(allCategoryList);
    }
    private void setBannerMoviePagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMovieViewPager = findViewById(R.id.banner_ViewPager);
        bannerMoviePagerAdapter = new BannerMoviePagerAdapter(this, bannerMoviesList);
        bannerMovieViewPager.setAdapter(bannerMoviePagerAdapter);
        tabIndicator.setupWithViewPager(bannerMovieViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        tabIndicator.setupWithViewPager(bannerMovieViewPager, true);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMovieViewPager.getCurrentItem() < homeBannerList.size() - 1){
                        bannerMovieViewPager.setCurrentItem(bannerMovieViewPager.getCurrentItem() + 1);
                    }else{
                        bannerMovieViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    public void setMainRecycler(List<AllCategory> allCategoryList){
        mainRecyclerView = findViewById(R.id.mainRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);
    }
}