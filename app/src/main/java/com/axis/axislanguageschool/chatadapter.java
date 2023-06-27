package com.axis.axislanguageschool;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class chatadapter extends RecyclerView.Adapter {
    ArrayList<User>arrayList;
    View view;
    String Role;
    RecyclerView.ViewHolder v;
    int type;
    Context context;
    String sender,tutor;

    public chatadapter(ArrayList<User> arrayList,Context context,String sender,String Role,String tutor) {
        this.arrayList = arrayList;
        this.context=context;
        this.sender=sender;
        this.tutor=tutor;
        Log.w("IM A SENDER",sender);
        this.Role=Role;
        Log.w("IM A Role",Role);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.w("Viewtype,hhhh", String.valueOf(viewType));
        Log.w("Role...........eloR",Role+"|");
//Tutor view type=0
        //Admin View type=1

            if ((Role.equals("Tutor"))){
                Log.w("enterddddd","HERERERERE");

                if(viewType==2){
                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_layout,parent,false);
                    Log.w("VIEWTYPE1","VIEWTYPE1");
                    return new sender(view) ;
                }else{
                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reciever,parent,false);
                    Log.w("VIEWTYPE0","VIEWTYPE0");
                    return new reciever(view) ;
                }



            }else if((Role.equals("Admin"))){
                if(viewType==1){
                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_layout,parent,false);
                    Log.w("VIEWTYPEAAAADM","VIEWTYPE1ADM");
                    return new sender(view) ;
                }else{
                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reciever,parent,false);
                    Log.w("VIEWTYPE0ADM","VIEWTYPE0ADM");
                    return new reciever(view) ;
                }



            }
            else{
                if(viewType==1){
                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_layout,parent,false);
                    Log.w("VIEWTYPE1new","VIEWTYPE1new");
                    return new sender(view) ;
                }else{
                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reciever,parent,false);
                    Log.w("VIEWTYPE0new","VIEWTYPE0new");
                    return new reciever(view) ;
                }
            }

        }



    @Override
    public int getItemViewType(int position) {
        if((Role.equals("Tutor"))){
            if (arrayList.get(position).getId().equals(tutor)){
                Log.w("enterddddnhhhhhhh",sender);

                Log.w("ioioiiioii",arrayList.get(position).getId());
                Log.w("ioioiiioii",arrayList.get(position).getMsg());
                return  2;

            }
            else {

                return 0;

            }



        }else {
            if (arrayList.get(position).getId().equals(sender)){
                Log.w("enterdddddggg",sender);

                Log.w("HHHHHHHH",arrayList.get(position).getId());
                Log.w("HHHHHHHHH",arrayList.get(position).getMsg());
                return  1;

            }
            else {
                return 0;
            }

        }




//        else if((arrayList.get(position).getId()+"tut").equals(sender)){
//
//            Log.w("inmnmnmii",arrayList.get(position).getId());
//            Log.w("inmnmnmii",arrayList.get(position).getMsg());
//
//
//            return 2;
//        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        User user = arrayList.get(position);
        if(holder.getClass()==sender.class){
            Log.w("inside sender",user.getId());

            sender snd=(sender) holder;
            snd.textViewsend.setText(user.getMsg());
            Log.w("inside reciever",user.getMsg());

        }
        else{
           // Log.w("inside reciever",user.getRole());

            reciever rec=(reciever) holder;
            rec.textViewrecieve.setText(user.getMsg());

        }

    }


    class sender extends RecyclerView.ViewHolder{
        TextView textViewsend;
        public sender(@NonNull View itemView) {
            super(itemView);
            textViewsend=itemView.findViewById(R.id.textView);
        }
    }

    class reciever  extends RecyclerView.ViewHolder{
        TextView textViewrecieve;
        public reciever(@NonNull View itemView) {
            super(itemView);
            textViewrecieve=itemView.findViewById(R.id.textView2);
        }
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
