package com.example.test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<ItemDataBastket> m_oData = null;
    private int nListCnt = 0;

    public ListAdapter(ArrayList<ItemDataBastket> _oData) {
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount() {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final Context context = parent.getContext();
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.item_layout_basket, parent, false);
        }


        TextView oTextDate = (TextView) convertView.findViewById(R.id.textMenu);
        TextView oTextCount = (TextView) convertView.findViewById(R.id.textCount);
        TextView oTextCost = (TextView) convertView.findViewById(R.id.textCost);
        Button oBtn = (Button) convertView.findViewById(R.id.deleteButton);
        ImageButton upBtn = (ImageButton) convertView.findViewById(R.id.upButton);
        ImageButton downBtn = (ImageButton) convertView.findViewById(R.id.downButton);

        oTextDate.setText(m_oData.get(position).strMenu);
        oTextCount.setText(m_oData.get(position).strCount);
        oTextCost.setText(m_oData.get(position).strCost);
        oBtn.setOnClickListener(m_oData.get(position).onClickListener);

        convertView.setTag(""+position);
        return convertView;
    }
}
