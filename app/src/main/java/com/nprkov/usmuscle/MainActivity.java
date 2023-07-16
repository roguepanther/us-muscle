package com.nprkov.usmuscle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import static ie.imobile.extremepush.PushConnector.mPushConnector;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private WebView webView;
    private Button myButton;
    private Button loginLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();
        webView = findViewById(R.id.web_view);

        loginLogoutButton = findViewById(R.id.login_logout_button);

        // Set the click listener for the button
        loginLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Check user authentication status
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser == null) {
                    loginWithWebView();
                } else {
                    logout();
                }
            }
        });

        // Bind the button
        myButton = findViewById(R.id.my_button);

        // Check user authentication status
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            // user is not logged in, hide the button
            myButton.setVisibility(View.GONE);
        } else {
            // User is logged in, show the button
            myButton.setVisibility(View.VISIBLE);
        }



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start the new activity
                Intent intent = new Intent(MainActivity.this, ViewsFord.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ViewsDodge.class);
                startActivity(intent);
            }
        });


    }

    private void loginWithWebView() {
        /* TODO: FIX THE WEBVIEW BEHAVIOUR WHERE WEBVIEW IS IN THE BACKGROUND AND BUTTONS REMAIN ON SCREEN */
        webView.loadUrl("https://americanm-28b3f.firebaseapp.com");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                if(url.contains("<Your success url>")) {
                    return true;
                } else if(url.contains("<Your failure url>")) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void logout() {
        mAuth.signOut();
    }
}