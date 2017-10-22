package com.example.it.mytestapplication;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, MainPageFragment.OnFragmentInteractionListener {

    // メニュー識別用のID
    private static final int MENU_SAMPLE = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // アプリケーションバーの設定
        // ActionBar actionBar = getSupportActionBar();

        // アプリケーションアイコンの制御の有効化（戻る）
        // actionBar.setDisplayHomeAsUpEnabled(true);

        // ツールバーの設定
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // xmlからTabLayoutの取得
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // xmlからViewPagerを取得
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        // 表示Pageに必要な項目を設定
        MainFragmentPagerAdapter pagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), this);
        pagerAdapter.tabTitles.add("HOME");
        pagerAdapter.tabTitles.add("TOOLS");
        pagerAdapter.tabTitles.add("SETTING");

        // ViewPagerにページを設定
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);

        // ViewPagerをTabLayoutを設定
        tabLayout.setupWithViewPager(viewPager);

//        // TOOLSのリストビューの設定
//        String[] strColors = {"red", "blue", "green", "yellow", "orange"};
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strColors);
//        ToolsPageFragment toolsPageFragment = new ToolsPageFragment();
//        toolsPageFragment.setListAdapter(arrayAdapter);
//
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction tx = manager.beginTransaction();
//        tx.add(R.id.tools_list, toolsPageFragment, "list_fragment");
//        tx.commit();

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//
//        // メニューのレイアウトファイルを読み込む
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        // 動的にメニューを追加
//        MenuItem item = menu.add(Menu.NONE, MENU_SAMPLE, 200, "動的なメニュー");
//        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                Toast.makeText(this, "アプリケーションアイコンの選択", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public void onClickButtonSubMain(View view) {
        Intent intent = new Intent(this, CameraView.class);
        startActivity(intent);
    }

    public void onClickButtonActionBar(View view) {

        // クリップボードに設定
        ClipData.Item item = new ClipData.Item("MyTest");
        String[] mimeType = new String[1];
        mimeType[0] = ClipDescription.MIMETYPE_TEXT_PLAIN;
        ClipData clipData = new ClipData(new ClipDescription("text_plain",mimeType), item);
        ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        cm.setPrimaryClip(clipData);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar.isShowing()) {
            actionBar.hide();
        } else {
            actionBar.show();
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
