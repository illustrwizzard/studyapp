package com.axis.axislanguageschool;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;


public class BatchOverview extends Fragment {
    String studentname;
    String verify_name;
    TextView stuname,batchnme,batchcod,dateofjoining,mail,mob,address;
    String url="http://language.axisjobs.in/api/register/token";







    public void send(String verify_name){
        Log.w("veriffuuuyname",verify_name);




        RequestQueue queue = Volley.newRequestQueue(getContext() );
        StringRequest req=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeeehhshshshs ",response);






                try {
                    JSONObject jsn = new JSONObject(response);
                    Log.w("jjdjdjdjdjdjdjd",response);

                    /// insert into db
                    jsn.getString("role");
                   dateofjoining.setText(jsn.getString("date_join"));
                   mob.setText(jsn.getString("mobile"));
                   mail.setText(jsn.getString("email"));
                   address.setText(jsn.getString("address"));
                   batchnme.setText(jsn.getString("batch"));
                    //sqlb.insert_studentDetails(jsn.getString("role"),jsn.getString("batch"), jsn.getString("name"),jsn.getString("email"),jsn.getString("address"),jsn.getString("mobile"),jsn.getString("date_join"),jsn.getString("verify_code"),jsn.getString("dob"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("token",verify_name);

                return map;

            }
        };
        queue.add(req);


    }







    public BatchOverview(String verify_name, String studentname) {
        this.studentname=studentname;
        this.verify_name=verify_name;
    }

    public BatchOverview() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_batch_overview, container, false);
        stuname=view.findViewById(R.id.stuname1);
        batchcod=view.findViewById(R.id.batchcode1);
        dateofjoining=view.findViewById(R.id.opiiiiii);
        batchnme=view.findViewById(R.id.bachname1);
        mob=view.findViewById(R.id.p_mob);
        mail=view.findViewById(R.id.p_email);
        address=view.findViewById(R.id.p_address);

        stuname.setText(studentname);
        batchcod.setText(verify_name);
        send(verify_name);
        return view;
    }
}