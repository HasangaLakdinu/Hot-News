package c.thenewboston.hotnews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity implements ExapmpleAdapter.OnItemClickListener {
    String loginurl;
    String appBartitle;


    private RecyclerView mRecyclerView;
    private ExapmpleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;
    private android.support.v7.widget.Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        loginurl= intent.getStringExtra("UrltoSite");
        appBartitle=intent.getStringExtra("Title");

        mToolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(appBartitle);





        mRecyclerView=findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mExampleList=new ArrayList<>();
        mRequestQueue= Volley.newRequestQueue(this);
        parseJSON();

    }
    private void parseJSON(){
        //Calling List End point

        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, loginurl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            JSONArray jsonArray=response.getJSONArray("articles");
                            for(int i=0;i<jsonArray.length();i++){
                              JSONObject article=jsonArray.getJSONObject(i);
                              String articleTitle=article.getString("title");
                              String imageUrl=article.getString("urlToImage");
                              String date=article.getString("publishedAt");
                              String author=article.getString("author");
                              String Description=article.getString("description");
                              String Urle=article.getString("url");

                              mExampleList.add(new ExampleItem(imageUrl,articleTitle,date,Description,author,Urle));
                            }
                           mExampleAdapter=new ExapmpleAdapter(MainActivity.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(MainActivity.this);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
       ExampleItem clickedItem=mExampleList.get(position);
        String postUrl=clickedItem.getmUrl1();
        Intent browserIntent=new Intent(Intent.ACTION_VIEW,Uri.parse(postUrl));
        startActivity(browserIntent);

    }
}
