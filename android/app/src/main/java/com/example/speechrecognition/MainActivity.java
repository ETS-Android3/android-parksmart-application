package com.example.speechrecognition;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private ImageView speechButton;
    private EditText speechText;
    private Button btn;
    private FloatingActionButton optBtn;
    private RelativeLayout parent;          //for the snackbar..
    private EditText setTime;
    private Button setBtn;
    private EditText setAlarm;
    private Button setBtnAlarm;
    private EditText tweet;
    private Button tweetBtn;
    private Button regUser;
    private Button loginUser;
    //View viewPos;
    //private RecyclerView optionsRecView;  --> for final project...

    //WebView browser;

    private static final int RECOGNIZER_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(this, "Welcome to the NY-Smart-Park", Toast.LENGTH_SHORT).show();

        //speechButton = findViewById(R.id.mic_image);
        //speechText = findViewById(R.id.editTxt);
        optBtn = findViewById(R.id.optionsButton);
        parent = findViewById(R.id.parentLayout);
        //btn = findViewById(R.id.insta);
        //optionsRecView = findViewById(R.id.optionsRecView);
        //browser = (WebView) findViewById(R.id.webview);
        //setTime = findViewById(R.id.settime);
        //setBtn = findViewById(R.id.setBtn);
        //setAlarm = findViewById(R.id.setalarm);
        //setBtnAlarm = findViewById(R.id.setBtnAlarm);
       // tweet = findViewById(R.id.settweet);
        //tweetBtn = findViewById(R.id.setBtnTweet);
        regUser = findViewById(R.id.registerUser);
        loginUser = findViewById(R.id.loginUser);

        regUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                finish();
            }
        });

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        //for the set time button
//        setBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String server = "http://fa0c-2607-fb90-5481-697f-84e-4bda-8fce-6974.ngrok.io";
//                String send_url;
//                send_url = server + "/?setTime=" + setTime.getText().toString();
//                gotoUrl(send_url);
//            }
//        });

        //for the set alarm button
//        setBtnAlarm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String server = "http://fa0c-2607-fb90-5481-697f-84e-4bda-8fce-6974.ngrok.io";
//                String send_url;
//                send_url = server + "/?setAlarm" + setAlarm.getText().toString();
//                gotoUrl(send_url);
//            }
//        });

        //for the send tweet button
//        tweetBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String server = "http://fa0c-2607-fb90-5481-697f-84e-4bda-8fce-6974.ngrok.io";
//                String send_url;
//                send_url = server + "/?tweet=" + tweet.getText().toString();
//                gotoUrl(send_url);
//            }
//        });

        //browser.loadUrl("http://www.tutorialspoint.com");



        optBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Options Button Clicked!", Toast.LENGTH_SHORT).show();
                //showSnackBar();
            }
        });


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //gotoUrl("https://www.instagram.com/");
//                //needed to add http legacy to gradle to support HttpClient
////                DefaultHttpClient httpClient = new DefaultHttpClient();
////                HttpGet httpGet = new HttpGet("http://ip-api.com/json");
////                ResponseHandler<String> resHandler = new BasicResponseHandler();
////                try {
////                    String page = httpClient.execute(httpGet, resHandler);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//
//            }
//        });

//        speechButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //in order to use google speech to text API, use intent
//                Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);     //use to connect to API
//                speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);     //extra lang model informs the recognizer which speech model to prefer, land model free form uses free form for the speech input
//                speechIntent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech to text");    // optional text to show to user to ask them to speak
//                try{
//                    startActivityForResult(speechIntent,RECOGNIZER_RESULT);     //when onactivityresult is called, it checks if it same value as the RECOGNIZER_RESULT passed here
//                    speechText.setText("");
//                    //showSnackBar();
//                }catch (ActivityNotFoundException e){
//                    Toast.makeText(getApplicationContext(),"Your device does not support Speech to Text",Toast.LENGTH_SHORT).show();
//                    e.printStackTrace();
//                }
//
//            }
//        });
    }

    //this function is for the menu bar ---> will be utilized in final project
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;

    }

//    private void gotoUrl(String s) {
//        Uri uri = Uri.parse(s);     //uniform resource identifier reference.
//        startActivity(new Intent(Intent.ACTION_VIEW,uri));              //ACTION_VIEW: most common action performed on data. most generic action performed on data with most reasonable outcome.
//        String url ="http://fa0c-2607-fb90-5481-697f-84e-4bda-8fce-6974.ngrok.io";
//
//        //listen back for a response from the url
//        //Toasting the message if the response is an error
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this, "Response is: "+ response.substring(0,500), Toast.LENGTH_SHORT).show();
//                //textView.setText("Response is: "+ response.substring(0,500));
//            }
//        },new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "That didn't work!", Toast.LENGTH_SHORT).show();
//                //textView.setText("That didn't work!");
//            }
//        });
//    }


    //override this method
   // @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RECOGNIZER_RESULT && resultCode == RESULT_OK){
//            assert data != null;
//            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);       //store words into array list
//            speechText.setText(matches.get(0).toString());
//            String server = "http://fa0c-2607-fb90-5481-697f-84e-4bda-8fce-6974.ngrok.io";
//            String send_url;
//            //turn screen on
//            if (matches.get(0).toString().equalsIgnoreCase("display on")){
//                send_url = server + "/?display=on";
//                gotoUrl(send_url);
//            }// turn screen off
//            else if(matches.get(0).toString().equalsIgnoreCase("display off")){
//                send_url = server + "/?display=off";
//                gotoUrl(send_url);
//            }// for location display
//            else if(matches.get(0).toString().equalsIgnoreCase("show location")){
//                send_url = server + "/?show=location";
//                gotoUrl(send_url);
//            }// for the weather
//            else if(matches.get(0).toString().equalsIgnoreCase("show weather")){
//                send_url = server + "/?show=weather";
//                gotoUrl(send_url);
//            }// for the tweet
//            else if(matches.get(0).toString().contains("tweet")){
//                String temp = matches.get(0).toString();
//                String temp2 = temp.substring(5,temp.length()-1);
//                send_url = server + "/?tweet=" + temp2;
//                gotoUrl(send_url);
//            }
//            else if(matches.get(0).toString().equalsIgnoreCase("display time")){
//                send_url = server + "/?display=time";
//                gotoUrl(send_url);
//            }//display last tweet
//            else if(matches.get(0).toString().equalsIgnoreCase("display last tweet")){
//                send_url = server + "/?last_tweet";
//                gotoUrl(send_url);
//            }
//            else{
//                send_url = server + "/?txt=" + matches.get(0).toString();
//                System.out.println(matches.get(0).toString());
//                gotoUrl(send_url);
//                //Toast.makeText(MainActivity.this, "This is not a valid input", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//
//    }

    /*
    snackbar is going to need a constraint layout to position elsewhere
    currently overlapping the copyright
     */
    /*
    private void showSnackBar(){

        Snackbar.make(parent,"snackbar",Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(MainActivity.this, "snackbar closed", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(Color.BLUE)
                .show();

    }

     */
}