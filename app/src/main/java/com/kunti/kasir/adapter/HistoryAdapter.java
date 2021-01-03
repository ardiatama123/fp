package com.kunti.kasir.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.azhar.kasir.R;
import com.kunti.kasir.activity.HistoryActivity;
import com.kunti.kasir.model.HistoryModel;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter<HistoryModel> {

    public HistoryAdapter( HistoryActivity context, ArrayList<HistoryModel> hasil ) {
            super(context,hasil);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_booking, parent, false);
        }

        HistoryModel current = getItem(position);

        TextView idBook = listItemView.findViewById(R.id.id_booking);
        idBook.setText("ID : " + current.getIdBook());

        TextView tanggal = listItemView.findViewById(R.id.tanggal);
        tanggal.setText(current.getTanggal());

        TextView riwayat = listItemView.findViewById(R.id.riwayat);
        riwayat.setText(current.getRiwayat());

        TextView tvTotal = listItemView.findViewById(R.id.tv_total);
        tvTotal.setText("Total :");

        TextView total = listItemView.findViewById(R.id.total);
        total.setText("Rp. " + current.getTotal());

        ImageView imageIcon = listItemView.findViewById(R.id.image);

        if (current.hasImage()) {
            imageIcon.setImageResource(current.getImageResourceId());
            imageIcon.setVisibility(View.VISIBLE);
        } else {
            imageIcon.setVisibility(View.GONE);
        }

        return listItemView;
    }
}