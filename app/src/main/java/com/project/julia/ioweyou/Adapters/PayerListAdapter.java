package com.project.julia.ioweyou.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.project.julia.ioweyou.Model.Payer;
import com.project.julia.ioweyou.R;

import java.util.List;


public class PayerListAdapter extends ArrayAdapter<Payer> {

    public PayerListAdapter(Context context, int resource, List<Payer> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.content_payer_row, parent, false);
        }

        Payer payer = getItem(position);

        if (payer != null) {
            TextView row = (TextView) v.findViewById(R.id.payer_row);
            if (row != null) { row.setText(payer.getName()); }
        }

        return v;
    }
}
