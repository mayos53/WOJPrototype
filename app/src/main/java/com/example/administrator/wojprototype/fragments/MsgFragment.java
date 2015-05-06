package com.example.administrator.wojprototype.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.wojprototype.App;
import com.example.administrator.wojprototype.MainActivity;
import com.example.administrator.wojprototype.R;
import com.example.administrator.wojprototype.model.Spam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yossef on 4/27/15.
 */
public class MsgFragment extends Fragment {

    MyAdapter adapter;
    App app;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        app = (App) getActivity().getApplication();

        View view = inflater.inflate(R.layout.fragment_msg, null);

        ListView listView = (ListView) view.findViewById(R.id.list_spam);


        adapter = new MyAdapter(getActivity(), 0);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                app.removeSpam(adapter.getItem(position).id);
                updateList();
                Toast toast = Toast.makeText(getActivity(), "ההודעה דווחה כספאם.אם אתה הראשון,תקבל 10 שקלים.",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        updateList();
        return view;
    }

    private void updateList() {
        List<Spam> list = new ArrayList<Spam>();
        Spam[] _spams = app.getList();
        for (Spam sp : _spams) {
            list.add(sp);
        }
        adapter.clear();
        adapter.addAll(list);
        //number.setText(""+adapter.getCount());


    }


    class MyAdapter extends ArrayAdapter<Spam> {

        public MyAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.spam_item, null);
                SpamHolder holder = new SpamHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.content = (TextView) convertView.findViewById(R.id.content);
                convertView.setTag(holder);

            }
            SpamHolder holder = (SpamHolder) convertView.getTag();
            holder.title.setText(getItem(position).title);
            holder.content.setText(getItem(position).content);
            return convertView;


        }
    }


    class SpamHolder {
        TextView title;
        TextView content;
    }



}
