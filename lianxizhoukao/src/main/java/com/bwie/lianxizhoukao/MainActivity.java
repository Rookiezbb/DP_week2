package com.bwie.lianxizhoukao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bwie.lianxizhoukao.utils.Frist;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    @BindView(R.id.bt4)
    Button bt4;
    @BindView(R.id.bt5)
    Button bt5;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        if(isOnline()){
            EventBus.getDefault().postSticky(new Frist("当前网络已连接"));
        }else {
            EventBus.getDefault().postSticky(new Frist("当前无网络"));
        }
    }
            public boolean isOnline(){
                //得到网络连接的管理者
                ConnectivityManager connMgr=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                //通过网络管理者得到网络信息
                NetworkInfo info = connMgr.getActiveNetworkInfo();
                //判断网络是否连接
                return (info!=null&&info.isConnected());
            }
    public void getData(Fragment fragment) {
        manager.beginTransaction().replace(R.id.framg, fragment).commit();
    }

    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                getData(new Fragment1());
                break;
            case R.id.bt2:
                getData(new Fragment2());
                break;
            case R.id.bt3:
                getData(new Fragment3());
                break;
            case R.id.bt4:
                getData(new Fragment4());
                break;
            case R.id.bt5:
                getData(new Fragment5());
                break;
        }
    }
}
