package c.thenewboston.hotnews;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toolbar;

public class SelectNewsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private android.support.v7.widget.Toolbar mToolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_news);



       mToolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.main_page_toolbar);
       setSupportActionBar(mToolbar);
       getSupportActionBar().setTitle("Hot News");

        Spinner spinner=findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.newssource,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       String text=adapterView.getItemAtPosition(i).toString();

       if(text.equals("Espn Cricinfo")){
           String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=espn-cric-info&apiKey=7f114db118f048b0b557ac0570b0d9a8";
           Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
           MainIntent.putExtra("UrltoSite",urlToWebsite);
           MainIntent.putExtra("Title",text);

           startActivity(MainIntent);
       }
        if(text.equals("CNN News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("Verge News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=the-verge&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("National Geographic News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=national-geographic&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("Al-Jazeera")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=al-jazeera-english&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("ESPN News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=espn&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("Google News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("BBC News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("DailyMail News")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=daily-mail&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
        if(text.equals("Medical News Today")){
            String urlToWebsite="https://newsapi.org/v2/top-headlines?sources=medical-news-today&apiKey=7f114db118f048b0b557ac0570b0d9a8";
            Intent MainIntent=new Intent(SelectNewsActivity.this,MainActivity.class);
            MainIntent.putExtra("UrltoSite",urlToWebsite);
            MainIntent.putExtra("Title",text);
            startActivity(MainIntent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
