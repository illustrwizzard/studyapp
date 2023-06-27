package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterForAdmin extends RecyclerView.Adapter<AdapterForAdmin.MyviewHolder> {
    Context context;
    ArrayList<AdminDataClass>arrayList;
    String url_tutor;
    Boolean flag=true;
    String batch;
    String new_tutor;
    String url_new_batch,new_batch;
    public AdapterForAdmin(AdminPage adminPage, ArrayList<AdminDataClass> arrayList) {
        context=adminPage;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public AdapterForAdmin.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_admin,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForAdmin.MyviewHolder holder, @SuppressLint("RecyclerView") int position) {


        //Boolean flag;
        //
        //    public Boolean add_student_batch (String batch, String new_student){
        //
        //
        //        RequestQueue que= Volley.newRequestQueue(getApplicationContext());
        //        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        //            @Override
        //            public void onResponse(String response) {
        //
        //                if(response.equals("sucess")){
        //                    flag=true;
        //
        //
        //                }
        //
        //            }
        //        }, new Response.ErrorListener() {
        //            @Override
        //            public void onErrorResponse(VolleyError error) {
        //
        //            }
        //        }){
        //            @Nullable
        //            @Override
        //            protected Map<String, String> getParams() throws AuthFailureError {
        //                Map map=new HashMap();
        //                map.put("batch",batch);
        //                map.put("new_student",new_student);
        //
        //                return  map;
        //            }
        //        };


        ///Batch


        holder.batchName.setText(arrayList.get(position).getBatchName());
        holder.DateofJoining.setText(arrayList.get(position).getDateOfJoininig());
        holder.addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                public Boolean add_tutor_batch (String batch, String new_tutor){
//
//
//                    RequestQueue que= Volley.newRequestQueue(context);
//
//                    StringRequest request=new StringRequest(Request.Method.POST, url_tutor, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//
//                            if(response.equals("sucess")){
//                                flag=true;
//
//
//                            }
//
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//
//                        }
//                    }){
//                        @Nullable
//                        @Override
//                        protected Map<String, String> getParams() throws AuthFailureError {
//                            Map map=new HashMap();
//                            map.put("batch",batch);
//                            map.put("new_tutor",new_tutor);
//
//                            return  map;
//                        }
//                    };
//
//                    que.add(request);
//                   // return flag;
//                }


                Intent i = new Intent(context, AddStudent.class);
                i.putExtra("Batch_code", arrayList.get(position).getBatchName());
                i.putExtra("new_student", "yes");
                v.getContext().startActivity(i);
//
            }
        });


//     holder.addTutor.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//
//
////                public boolean add_batch (String new_batch){
////                    RequestQueue que= Volley.newRequestQueue(context);
////
////                    StringRequest request=new StringRequest(Request.Method.POST, url_new_batch, new Response.Listener<String>() {
////                        @Override
////                        public void onResponse(String response) {
////                            if(response.equals("sucess")){
////
////                                flag=true;
////                            }
////
////                        }
////                    }, new Response.ErrorListener() {
////                        @Override
////                        public void onErrorResponse(VolleyError error) {
////
////                        }
////                    }){
////                        @Nullable
////                        @Override
////                        protected Map<String, String> getParams() throws AuthFailureError {
////                            Map map=new HashMap();
////
////                            map.put("new_batch",new_batch);
////                            map.put("date","date");
////
////
////                            return  map;
////                        }
////                    };
////                    que.add(request);
////                   // return flag;
////
////                }
//
//
//
//            }
//       });

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView batchName,DateofJoining;
        Button addStudent;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            batchName=itemView.findViewById(R.id.batchname_id);
            DateofJoining=itemView.findViewById(R.id.DateOfJOINING);
            addStudent=itemView.findViewById(R.id.addStudent_id);

        }
    }
}
