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
import com.movie.moviestreamingapp.model.CategoryItem;

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
        getSupportActionBar().hide();
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

//        allCategoryList = new ArrayList<>();
//        allCategoryList.add(new AllCategory(1, "Hollywood"));
//        allCategoryList.add(new AllCategory(2, "Kids"));
//        setMainRecycler(allCategoryList);

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
        //List thể loại phim ĐẮM MÌNH VÀO THẾ GIỚI GAME
        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1, "Dị thế ma vương", "https://zingtv-photo.zmdcdn.me/tv_media_470_272/4/c/0/3/4c03033028c790a8dca02d1bf55efee7.jpg", ""));
        homeCatListItem1.add(new CategoryItem(2, "Chiến hữu của tôi", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/6/c/6c71587c21a9e4fefc5a8d15ae6a9f15_1507718959.jpg", ""));
        homeCatListItem1.add(new CategoryItem(3, "Log Horizon", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/2014/0528/0c/65dbeab9ec77b038653f695c0ec8df32_2.jpg", ""));
        homeCatListItem1.add(new CategoryItem(4, "No game no life", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/c/1/f/9/c1f9063c24a52b04899522610300e460.jpg", ""));
        homeCatListItem1.add(new CategoryItem(5, "Đạo kiếm thần vực", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/a/f/4/0/af40e86eea111f0fd67a1a605e4ec262.jpg", ""));
        //List thể loại phim CHO TÔI XIN MỘT VÉ ĐI TUỔI THƠ
        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1, "Tóc hai bím", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/1/8/186b2d767f0382fd8f0558ee400a10fe_1508788953.jpg", ""));
        homeCatListItem2.add(new CategoryItem(2, "Thiên tài sạch sẽ", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/0/a/0a99b3b1f8d777e8f2929019c1fda4f9_1499338125.jpg", ""));
        homeCatListItem2.add(new CategoryItem(3, "Cross game", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/5/6/56be2ced911972f5395d6d0f76cb1ce7_1460885870.jpg", ""));
        homeCatListItem2.add(new CategoryItem(4, "Trận chiến E-Sport", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/1/1/f/0/11f0da66d8aa491febe2eb33d1f5e031.jpg", ""));
        homeCatListItem2.add(new CategoryItem(5, "Dance with Devils", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/b/d/bddb4fb37634081a70082f9a10f69499_1445265687.jpg", ""));
        //List thể loại phim PHIM ĐÀI LOAN CHỌN LỌC
        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1, "Chỉ cần anh yêu em","https://zingtv-photo.zmdcdn.me/tv_program_275_275/2/3/e/6/23e6b1e8d5c846841fe849eea5378cec.jpg",""));
        homeCatListItem3.add(new CategoryItem(2, "Muốn gặp anh","https://zingtv-photo.zmdcdn.me/tv_program_275_275/5/0/e/e/50eeafc45036fb2d55e16632c6418651.jpg",""));
        homeCatListItem3.add(new CategoryItem(3, "Cô đầu bếp cá tính","https://zingtv-photo.zmdcdn.me/tv_program_275_275/3/7/0/9/3709d87f7367b84f0a2119346ad73c70.jpg",""));
        homeCatListItem3.add(new CategoryItem(4, "Tình yêu và vật chất","https://zingtv-photo.zmdcdn.me/tv_program_275_275/3/d/b/7/3db7d9c33e073d0038ca667799e30a1d.jpg",""));
        homeCatListItem3.add(new CategoryItem(5, "Định luật tình yêu của Murphy","https://zingtv-photo.zmdcdn.me/tv_program_275_275/0/f/0f7ab2bdb40e91464ca22bfd2f503fba_1430898974.jpg",""));
        //List thể loại phim PHIM THÁI ĐẶC SẮC NHẤT
        List<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1, "Hoàng cung", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/0/c/0c4e0ad694a5d40b77b34957c3293903_1497578860.jpg",""));
        homeCatListItem4.add(new CategoryItem(2, "Sóng gió cuộc đời", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/b/6/b6802ebfdba3a9ee7d72fa3dd649549e_1489744501.jpg",""));
        homeCatListItem4.add(new CategoryItem(3, "Ngôi nhà hạnh phúc", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/c/6/7/7/c67748f83fca8739e44078ce037a2adf.jpg",""));
        homeCatListItem4.add(new CategoryItem(4, "Kiêu hãnh và định kiến", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/b/0/1/d/b01dcd5395663f750431196f2abf19ea.jpg",""));
        homeCatListItem4.add(new CategoryItem(5, "Vì sao đưa anh tới", "https://zingtv-photo.zmdcdn.me/tv_program_275_275/4/3/9/f/439f4365c8adfa54181cb7a8a187801a.jpg",""));
        //List thể loại phim GÓC NHỎ CHO BÉ
        List<CategoryItem> homeCatListItem5 = new ArrayList<>();
        homeCatListItem5.add(new CategoryItem(1,"Hoàng tử gấu trắng", "https://zingtv-photo.zmdcdn.me/tv_media_470_272/d/1/9/d/d19dd44cf74f3b8d78c27398cf70407e.jpg", ""));
        homeCatListItem5.add(new CategoryItem(2,"Bước nhảy của châu chấu", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/b/4/3/7/b437c3632bb92c30a487760cb87b0862.jpg", ""));
        homeCatListItem5.add(new CategoryItem(3,"Cô gái chăm chỉ", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/c/6/5/a/c65af8c91ab7e73c9209d142988af0b2.jpg", ""));
        homeCatListItem5.add(new CategoryItem(4,"Bàn tay mẹ", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/e/3/2/d/e32dfc6572d724d65f6b3199e904ef02.jpg", ""));
        homeCatListItem5.add(new CategoryItem(5,"Đánh cắp nỏ thần", "https://zingtv-photo.zmdcdn.me/tv_media_225_126/0/b/d/7/0bd7f43a633931c8d8c627e1228df1eb.jpg", ""));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "ĐẮM MÌNH VÀO THẾ GIỚI GAME", homeCatListItem1));
        allCategoryList.add(new AllCategory(2, "CHO TÔI XIN MỘT VÉ ĐI TUỔI THƠ", homeCatListItem2));
        allCategoryList.add(new AllCategory(3, "PHIM ĐÀI LOAN CHỌN LỌC", homeCatListItem3));
        allCategoryList.add(new AllCategory(4, "PHIM THÁI ĐẶC SẮC NHẤT", homeCatListItem4));
        allCategoryList.add(new AllCategory(5, "GÓC NHỎ CHO BÉ",homeCatListItem5));

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