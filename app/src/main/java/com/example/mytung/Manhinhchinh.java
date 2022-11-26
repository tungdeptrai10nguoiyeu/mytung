package com.example.mytung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.mytung.DAO.ChuCuaHangDAO;
import com.example.mytung.Fragment.ChinhsuaFrament;
import com.example.mytung.Fragment.DangxuatFragment;
import com.example.mytung.Fragment.DoanhthuFrament;
import com.example.mytung.Fragment.LichsubanhangFragment;
import com.example.mytung.Fragment.LoaisanphamFragment;
import com.example.mytung.Fragment.NhanvienFragment;
import com.example.mytung.Fragment.SanphamFragment;
import com.example.mytung.Fragment.SanphambanchayFragment;
import com.example.mytung.adapter.adapterViewpage;
import com.example.mytung.model.ChuCuaHang;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Manhinhchinh extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ViewPager pager;
    adapterViewpage adapterviewpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navtion);
        pager = findViewById(R.id.page);
        addFragment(pager);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDWR,R.string.closeDWR);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        onContextMenuClosed();
        toolbar.setTitle("Quản Lý Cửa Hàng");

/*
        List<ChuCuaHang> list = new ArrayList<>();
        ChuCuaHangDAO dao = new ChuCuaHangDAO(this);
        ChuCuaHang chucuahang = new ChuCuaHang();
        Intent intent = getIntent();
        String user = intent.getStringExtra("ten_dang_nhap");
        list =  (ArrayList<ChuCuaHang>) dao.getAll();

        if (user.equals("admin")){
            navigationView.getMenu().findItem(R.id.CS).setVisible(true);
        }else {

            navigationView.getMenu().findItem(R.id.CS).setVisible(false);
        }

 */
    }

    private void onContextMenuClosed() {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.SP){
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(0);
            toolbar.setTitle("Sản phẩm");

            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    } else if (item.getItemId() == R.id.LSP) {
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(1);
            toolbar.setTitle("Loại sản phẩm");
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.NV) {
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(2);
            toolbar.setTitle("Nhân viên");
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.HD) {
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(3);
            toolbar.setTitle("Hoá đơn");
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.SPBC) {
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(4);
            toolbar.setTitle("Sản phẩm bán chạy");
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.DT) {
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(5);
            toolbar.setTitle("Doanh thu");
            item.setCheckable(true);
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.CS) {
            pager.setAdapter(adapterviewpage);
            pager.setCurrentItem(6);
            toolbar.setTitle("Chỉnh sửa");
            item.setCheckable(true);
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.DX) {
            Intent intent= new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawers();
            return true;
}

public void addFragment(ViewPager viewPager){
    adapterviewpage = new adapterViewpage(getSupportFragmentManager());
    adapterviewpage.addFragment(new SanphamFragment(),"Sản phẩm");
    adapterviewpage.addFragment(new LoaisanphamFragment(),"Loại sản phẩm");
    adapterviewpage.addFragment(new NhanvienFragment(),"Nhân viên");
    adapterviewpage.addFragment(new LichsubanhangFragment(),"Lịch sử bán hàng");
    adapterviewpage.addFragment(new SanphambanchayFragment(),"Sản phẩm bán chạy");
    adapterviewpage.addFragment(new DoanhthuFrament(),"Doanh thu");
    adapterviewpage.addFragment(new ChinhsuaFrament(),"Chỉnh sửa");
    adapterviewpage.addFragment(new DangxuatFragment(),"Đăng xuất");
    pager.setAdapter(adapterviewpage);
}

}