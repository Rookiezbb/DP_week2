package com.bwie.lianxizhoukao;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.lianxizhoukao.Adapter.MyAdapter;
import com.bwie.lianxizhoukao.gen.UserDao;
import com.bwie.lianxizhoukao.utils.Bean;
import com.bwie.lianxizhoukao.utils.Frist;
import com.bwie.lianxizhoukao.utils.MyApplication;
import com.bwie.lianxizhoukao.utils.ServiceURL;
import com.bwie.lianxizhoukao.utils.User;
import com.bwie.lianxizhoukao.utils.UtilsAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by lenovo on 2017/12/2.
 */
public class Fragment1 extends Fragment {
    public MyAdapter adapter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private UserDao mUserDao;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.f1, null);
        unbinder = ButterKnife.bind(this, v);
        EventBus.getDefault().register(this);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsAPI.BASE_HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ServiceURL url = retrofit.create(ServiceURL.class);
        Call<Bean> bean = url.bean();
        bean.enqueue(new Callback<Bean>() {
            public User mUser;

            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                List<Bean.ResultsBean> results = response.body().getResults();

                for (Bean.ResultsBean re:results) {
                    User mUser=new User(null,re.getDesc());
                    mUserDao.insert(mUser);
                }
//                for (int i = 0; i <10; i++) {
//                    User mUser=new User(null,results.get(i).getDesc());
//                    mUserDao.insert(mUser);
//                }
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
            }
        });
        List<User> users = mUserDao.loadAll();

        adapter=new MyAdapter(getActivity(),users);
        recycler.setAdapter(adapter);
        return v;
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void network(Frist f){
        Toast.makeText(getActivity(),"网络类型为："+f.getMasg(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().removeAllStickyEvents();
    }
}
