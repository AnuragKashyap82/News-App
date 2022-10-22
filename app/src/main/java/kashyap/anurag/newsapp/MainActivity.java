package kashyap.anurag.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import kashyap.anurag.newsapp.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    PagerAdapter pagerAdapter;
    TabItem mHome, mScience, mHealth, mEntertainment, mSports, mTechnology;
    Toolbar mToolbar;
    TabLayout tabLayout;
    String api = "35a09884347c49d5b942eff15e09f3ba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);

        mHome = findViewById(R.id.home);
        mScience = findViewById(R.id.science);
        mEntertainment = findViewById(R.id.entertainment);
        mSports = findViewById(R.id.sports);
        mTechnology = findViewById(R.id.technology);
        mHealth = findViewById(R.id.health);
        tabLayout = findViewById(R.id.include);
        ViewPager viewPager  =findViewById(R.id.fragmentContainer);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}