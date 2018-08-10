package com.androidlearn.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidlearn.summary.sumarry.R;

import java.util.List;

/**
 * Created by maqiang-pc on 2018/7/23.
 */

public class Item extends BaseAdapter{
    List<String> stringList;
    Context context;

    Item(List<String> lst, Context ctx){
        this.stringList = lst;
        this.context = ctx;
    }


    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return stringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewInfo vInfo = null;
        if(null == view){
            view = LayoutInflater.from(context).inflate(R.layout.item, null);
            vInfo = new ItemViewInfo();
            vInfo.imageView = view.findViewById(R.id.image);
            vInfo.button = view.findViewById(R.id.button);
            vInfo.textView = view.findViewById(R.id.tv);
            view.setTag(vInfo);
        }
        else{
            vInfo = (ItemViewInfo) view.getTag();
        }

        vInfo.textView.setText((String) getItem(i));

        return view;
    }

    class ItemViewInfo{
        ImageView imageView;
        TextView textView;
        Button button;
    }
}

