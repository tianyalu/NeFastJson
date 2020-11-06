package com.sty.ne.fastjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sty.ne.fastjson.library.JSON;
import com.sty.ne.fastjson.model.OrderInfo;
import com.sty.ne.fastjson.model.UserInfo;

public class MainActivity extends AppCompatActivity {
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serializer();
    }

    public void serializer() {
        UserInfo user = new UserInfo();
        user.setuId("0");
        user.setNickName("sty");
        user.setRealName("天涯路");
        user.setEmail("sty@qq.com");
        user.setAddress("广东省嘻嘻嘻");
        user.setPhoneNumber("187*****257");
        user.setUserType(3);
        user.setHeaderImage("https://www.baidu.com/images/avatar.jpg");

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setoId("S16320190729010001");
        orderInfo.setCategoryId("C163060006");
        orderInfo.setGoodsName("天涯路");
        // orderInfo.setPrice(new BigDecimal("52.163"));
        orderInfo.setCreateDate(System.currentTimeMillis());
        orderInfo.setUserInfo(user);

        Log.e("sty >>> ", "自定义序列化----------------------------------");
        long t1 = System.currentTimeMillis();
        json = JSON.toJSONString(orderInfo);
        Log.e("sty >>> ", json);
        Log.e("sty >>> ", "耗时：" + (System.currentTimeMillis() - t1) + " ms");

        Log.e("sty >>> ", "FastJson序列化----------------------------------");
        long t2 = System.currentTimeMillis();
        json = com.alibaba.fastjson.JSON.toJSONString(orderInfo);
        Log.e("sty >>> ", json);
        Log.e("sty >>> ", "耗时：" + (System.currentTimeMillis() - t2) + " ms");
        deserializer();
    }

    private void deserializer() {
        Log.e("sty >>> ", "自定义反序列化----------------------------------");
        long t1 = System.currentTimeMillis();
        OrderInfo orderInfo1 = JSON.parseObject(json, OrderInfo.class);
        if (orderInfo1 == null) return;
        Log.e("sty >>> ", orderInfo1.toString());
        Log.e("sty >>> ", "耗时：" + (System.currentTimeMillis() - t1) + " ms");


        Log.e("sty >>> ", "FastJson反序列化----------------------------------");
        long t2 = System.currentTimeMillis();
        OrderInfo orderInfo2 = com.alibaba.fastjson.JSON.parseObject(json, OrderInfo.class);
        if (orderInfo2 == null) return;
        Log.e("sty >>> ", orderInfo2.toString());
        Log.e("sty >>> ", "耗时：" + (System.currentTimeMillis() - t2) + " ms");
    }
}