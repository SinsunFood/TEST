package com.example.test;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;


import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;


public class Login extends AppCompatActivity {
    private EditText et_id,et_pass;
    private Button btn_login,btn_register;
    private static final String TAG = "Login";
    private  View loginButton,logoutButton;
    private  TextView nickName;
    private  ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.login);
        logoutButton = findViewById(R.id.logout);
        nickName = findViewById(R.id.nickname);
        profileImage = findViewById(R.id.profile);
        String keyHash = Utility.INSTANCE.getKeyHash(this);
        Log.i(TAG, "onCreate: keyHash" + keyHash);



        loginButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View view){
               if (LoginClient.getInstance().isKakaoTalkLoginAvailable(Login.this)) {
                   LoginClient.getInstance().loginWithKakaoTalk(Login.this, new Function2<OAuthToken, Throwable, Unit>() {
                       @Override
                       public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                          if(oAuthToken!=null){

                          }
                           if (throwable != null){

                           }
                           updateKakaoLoginUi();
                           return null;
                       }
                   });
               } else {

                   LoginClient.getInstance().loginWithKakaoAccount(Login.this, new Function2<OAuthToken, Throwable, Unit>() {
                       @Override
                       public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                           if(oAuthToken!=null){

                           }
                           if (throwable != null){

                           }
                           updateKakaoLoginUi();
                           return null;
                       }
                   });
               }



           }

        });

        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        updateKakaoLoginUi();
                        return null;
                    }
                });

            }
        });


        updateKakaoLoginUi();
    }

        private void updateKakaoLoginUi() {
            UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                @Override
                public Unit invoke(User user, Throwable throwable) {
                    if (user != null) {
                        Log.i(TAG, "invoke: id=" + user.getId());
                        Log.i(TAG, "invoke: email=" + user.getKakaoAccount().getEmail());
                        Log.i(TAG, "invoke: nickname=" + user.getKakaoAccount().getProfile().getNickname());
                        Log.i(TAG, "invoke: gender=" + user.getKakaoAccount().getGender());
                        Log.i(TAG, "invoke: age=" + user.getKakaoAccount().getAgeRange());
                       nickName.setText(user.getKakaoAccount().getProfile().getNickname());
                        Glide.with(profileImage).load(user.getKakaoAccount().getProfile().getThumbnailImageUrl()).circleCrop().into(profileImage);

                        loginButton.setVisibility(View.GONE);
                        logoutButton.setVisibility(View.VISIBLE);

                    } else {
                       nickName.setText(null);
                        profileImage.setImageBitmap(null);
                        loginButton.setVisibility(View.VISIBLE);
                        logoutButton.setVisibility(View.GONE);

                    }
                    if (throwable != null) {
                        Log.w(TAG, "invoke: " + throwable.getLocalizedMessage());
                    }
                    return null;
                }
            });
        }
}

















