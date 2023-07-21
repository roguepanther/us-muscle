package com.nprkov.usmuscle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import static ie.imobile.extremepush.PushConnector.mPushConnector;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser user;
    private Button myButton;
    private Button loginLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        if(user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
        loginLogoutButton = findViewById(R.id.login_logout_button);

        // Set the click listener for the button
        loginLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Check user authentication status
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser == null) {
                    // Implement Login Functionality on click
                    login();
                } else {
                    mAuth.signOut();
                    Toast.makeText(MainActivity.this, "Logged Out Successfully!", Toast.LENGTH_SHORT).show();
                    updateLoginButton();
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

        updateLoginButton();



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

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start the new activity
                Intent intent = new Intent(MainActivity.this, ViewsJeep.class);
                startActivity(intent);
            }
        });


    }

//    private void loginWithWebView() {
//        /* TODO: FIX THE WEBVIEW BEHAVIOUR WHERE WEBVIEW IS IN THE BACKGROUND AND BUTTONS REMAIN ON SCREEN */
//        webView.loadUrl("https://americanm-28b3f.firebaseapp.com");
//
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                if(url.contains("<Your success url>")) {
//                    return true;
//                } else if(url.contains("<Your failure url>")) {
//                    return true;
//                }
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
//    }

    private void login(){
        /* TODO: Login functionality for a Firebase authentication */
        // Create an intent to start LoginActivity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
//    This method is not needed as mAuth provides signOut method
    /* TODO: Refactor this bit of code */
//    private void logout() {
//        mAuth.signOut();
//
//    }

    private void updateLoginButton(){
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            loginLogoutButton.setText("Logout");
        } else {
            loginLogoutButton.setText("Login");
        }
    }
}