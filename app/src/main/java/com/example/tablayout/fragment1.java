package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class fragment1 extends Fragment {



    View v;
    private RecyclerView recyclerView;
    List<Modelclass> modelList;


    private static String JSON_URL = "http://testproject1.indigierp.com/api/retailproducts";



    public fragment1() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_fragment1,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return  v;




        // Inflate the layout for this fragment

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        modelList = new ArrayList<>();

        jsonparse();
    }

    private void jsonparse() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("Resp", "" + response);
//                Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = response.getJSONObject(0);

                    JSONArray jsonArray = jsonObject.getJSONArray("message");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject message = jsonArray.getJSONObject(i);

                        String retailer_id = message.getString("retailer_id");
                        String product_id = message.getString("product_id");
                        String status = message.getString("status");
                        String stock_availability = message.getString("stock_availability");
                        String product_name = message.getString("product_name");
                        String productimage = message.getString("productimage");

                        modelList.add(new Modelclass(retailer_id, product_id, status, stock_availability, product_name, productimage));
                    }
                } catch (Exception e) {
                    Log.e("exceptions", e.getLocalizedMessage());
                    Toast.makeText(getActivity(), "" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getLocalizedMessage());
                Toast.makeText(getActivity(), ""+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);

    }
}