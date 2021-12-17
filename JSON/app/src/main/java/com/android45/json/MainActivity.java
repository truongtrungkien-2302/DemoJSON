package com.android45.json;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android45.json.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String json = "{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null}";
    String jsonArray = "[{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null},{\"id\":\"111\",\"publisher_id\":\"113\",\"content_type\":\"113\",\"tab\":\"110\",\"title\":\"Series Phim\",\"avatar\":\"----------\"}]";
    String json1 = "{\"id\":833,\"name\":\"Ḩeşār-eSefīd\",\"state\":\"\",\"country\":\"IR\",\"coord\":{\"lon\":47.159401,\"lat\":34.330502}}";
    String json2 = "{\"id\":14256,\"coord\":{\"lon\":48.570728,\"lat\":34.790878},\"country\":\"IR\",\"geoname\":{\"cl\":\"P\",\"code\":\"PPL\",\"parent\":132142},\"langs\":[{\"de\":\"AzadShahr\"},{\"fa\":\"آزادشهر\"}],\"name\":\"Azadshahr\",\"stat\":{\"level\":1.0,\"population\":514102},\"stations\":[{\"id\":7030,\"dist\":9,\"kf\":1}],\"zoom\":10}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJson();
            }
        });

        activityMainBinding.btnShowArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonArray();
            }
        });

        activityMainBinding.btnShowJsonLon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonLon();
            }
        });

        activityMainBinding.btnShowJsonLat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonLat();
            }
        });

        activityMainBinding.btnShowJsonStations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonStations();
            }
        });

        activityMainBinding.btnShowJsonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonID();
            }
        });

        activityMainBinding.btnShowJsonDist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonDist();
            }
        });

        activityMainBinding.btnShowJsonkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonKT();
            }
        });
    }

    String stations = "";

    private void getJsonStations(){
        try {
            JSONObject jsonObject = new JSONObject(json2);
            stations = jsonObject.getString("stations");
        } catch (Exception e) {
            e.printStackTrace();
        }
        activityMainBinding.tvShow.setText(stations);
    }

    private void getJsonID(){
        String id = "";
        try {
            JSONArray jArray = new JSONArray(stations);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                id = jsonObject.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        activityMainBinding.tvShow.setText(id);
    }

    private void getJsonDist(){
        String dist = "";
        try {
            JSONArray jArray = new JSONArray(stations);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                dist = jsonObject.getString("dist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        activityMainBinding.tvShow.setText(dist);
    }

    private void getJsonKT(){
        String kf = "";
        try {
            JSONArray jArray = new JSONArray(stations);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                kf = jsonObject.getString("kf");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        activityMainBinding.tvShow.setText(kf);
    }

    String coord = "";

    private void getJsonCoord(){
        try {
            JSONObject jsonObject = new JSONObject(json1);
            coord = jsonObject.getString("coord");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getJsonLat() {
        try {
            getJsonCoord();
            JSONObject jsonObject1 = new JSONObject(coord);
            String lat = jsonObject1.getString("lat");
            activityMainBinding.tvShow.setText(lat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getJsonLon() {
        try {
            getJsonCoord();
            JSONObject jsonObject1 = new JSONObject(coord);
            String lon = jsonObject1.getString("lon");
            activityMainBinding.tvShow.setText(lon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getJson() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.getInt("id");
            int publisher_id = jsonObject.getInt("publisher_id");
            String title = jsonObject.getString("title");
            activityMainBinding.tvShow.setText(id + " - " + publisher_id + " - " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getJsonArray() {
        String title = "";
        try {
            JSONArray jArray = new JSONArray(jsonArray);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                title = jsonObject.getString("title");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        activityMainBinding.tvShow.setText(title);
    }
}