package com.example.a01438511.fuckuser;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View Click_me_to_get;
    private String TAG = "Fuck_User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Click_me_to_get = findViewById(R.id.Click_me_to_get);
        Click_me_to_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.Click_me_to_get:
                getAllUserInfo(this);
                break;
            default:
                break;
        }
    }

    public void getAllUserInfo(Context mContext){
        Log.e(TAG,"开始获取 AccountManager下所有应用");
        AccountManager accountManager = AccountManager.get(mContext);
        AuthenticatorDescription[] authenticatorTypes = accountManager.getAuthenticatorTypes();

        try {
            if (authenticatorTypes.length != 0){
                Log.e(TAG,"authenticatorTypes.length --> " + authenticatorTypes.length);
                for (AuthenticatorDescription mAuthenticatorDescription:   authenticatorTypes ){
                    Log.e(TAG,"authenticatorType --> " + mAuthenticatorDescription.toString());
                }

            }else {
                Log.e(TAG,"authenticatorTypes --> == null ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG,"get authenticatorTypes Exception" + e.getMessage());
        }finally {
            Log.e(TAG,"获取 AccountManager下所有应用结束");
        }
    }
}
