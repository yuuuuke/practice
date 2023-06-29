package com.example.floatbutton.function13;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.floatbutton.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorCardAdapter extends RecyclerView.Adapter<DoctorCardAdapter.DoctorHolder> {

    private final ArrayList<DoctorBean.ResultDTO.DatalistDTO> mData = new ArrayList<>();

    public void setData(List<DoctorBean.ResultDTO.DatalistDTO> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DoctorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor_card_small, parent, false);
        return new DoctorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorHolder holder, int position) {
        if(mData.size()!=0){
            holder.bindView(mData.get(position % mData.size()));
        }
    }

    @Override
    public int getItemCount() {
        return 1000;
    }

    static class DoctorHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private TextView price;
        private ImageView avatar;
        private TextView rank;
        private TextView city;
        private TextView hospital;
        private TextView office;

        public DoctorHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_doctor_name);
            price = itemView.findViewById(R.id.tv_price);
            avatar = itemView.findViewById(R.id.iv_avatar);
            rank = itemView.findViewById(R.id.tv_doctor_rank);
            city = itemView.findViewById(R.id.tv_city);
            hospital = itemView.findViewById(R.id.tv_hospital);
            office = itemView.findViewById(R.id.tv_doctor_office);
        }

        public void bindView(DoctorBean.ResultDTO.DatalistDTO bean) {
            name.setText(bean.getRealName());
            price.setText("问诊￥" + bean.getImgTextPrice() + "/次");
            rank.setText(bean.getTitle());
            city.setText(bean.getHospitalCity());
            hospital.setText(bean.getHospitalName());
            office.setText(bean.getDepartmentName());
            Glide.with(avatar.getContext()).load(bean.getHalflengthUrl()).into(avatar);
        }
    }
}
