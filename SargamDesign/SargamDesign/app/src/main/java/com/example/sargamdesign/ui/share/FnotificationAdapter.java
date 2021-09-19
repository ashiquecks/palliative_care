package com.example.sargamdesign.ui.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sargamdesign.R;
import com.example.sargamdesign.ui.home.OrderUpload;

import java.util.List;

public class FnotificationAdapter extends RecyclerView.Adapter<FnotificationAdapter.ViewHolder> {

    private Context mContext;
    private List<OrderUpload>MUploads;

    public FnotificationAdapter(FashionNotificationActivity fashionNotificationActivity, List<OrderUpload> mUploads) {

        mContext = fashionNotificationActivity;
        MUploads = mUploads ;

    }

    @NonNull
    @Override
    public FnotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.fashion_notification_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FnotificationAdapter.ViewHolder holder, int position) {
        OrderUpload uploadCurrent = MUploads.get(position);
        holder.pID.setText(uploadCurrent.getID());
        holder.pcategory.setText(uploadCurrent.getCategory());
        holder.pcolor.setText(uploadCurrent.getColor());
        holder.psize.setText(uploadCurrent.getSize());
        holder.pmateriasl.setText(uploadCurrent.getMaterial());
        holder.pqty.setText(uploadCurrent.getQty());
        holder.tprice.setText(uploadCurrent.getAmount());
        holder.cname.setText(uploadCurrent.getCrname());
        holder.cemail.setText(uploadCurrent.getCremail());
        holder.cphone.setText(uploadCurrent.getCrphone());
        holder.cstate.setText(uploadCurrent.getCstate());
        holder.ccity.setText(uploadCurrent.getCrcity());
        holder.cdts.setText(uploadCurrent.getCdts());
        holder.cadress.setText(uploadCurrent.getCraddress());
        holder.cpin.setText(uploadCurrent.getCrpin());
        holder.clandmark.setText(uploadCurrent.getCrlandmark());
    }

    @Override
    public int getItemCount() {
        return MUploads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pID,pcategory,pcolor,psize,pmateriasl,pqty,tprice,cname,cemail,cphone,cstate,ccity,cdts,cadress,cpin,clandmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pID=itemView.findViewById(R.id.item_Id);
            pcategory=itemView.findViewById(R.id.item_name);
            pcolor=itemView.findViewById(R.id.item_color);
            psize=itemView.findViewById(R.id.item_size);
            pmateriasl=itemView.findViewById(R.id.item_material);
            pqty=itemView.findViewById(R.id.item_qty);
            tprice=itemView.findViewById(R.id.item_price);

            cname=itemView.findViewById(R.id.king_name);
            cemail=itemView.findViewById(R.id.king_email);
            cphone=itemView.findViewById(R.id.king_phone);
            cstate=itemView.findViewById(R.id.king_state);
            ccity=itemView.findViewById(R.id.king_city);
            cdts=itemView.findViewById(R.id.king_district);
            cadress=itemView.findViewById(R.id.king_address);
            cpin=itemView.findViewById(R.id.king_pin);
            clandmark=itemView.findViewById(R.id.king_landmark);
        }
    }
}
