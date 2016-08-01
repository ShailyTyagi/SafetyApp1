package com.example.shikt.safetyapp;

import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,GoogleSignInApi,GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient client;
    public static final int RC_SIGN_IN = 7;
    String LOG_TAG="YO";
    EditText fname;
    public static final String EX="com.example.safetyapp.NAME";


    GoogleSignInOptions gso;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
// Build a GoogleApiClient with access to the Google Sign-In API and the
// options specified by gso
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  findViewById(R.id.sign_in_button).setOnClickListener( this);
       // findViewById(R.id.sign).setOnClickListener((View.OnClickListener) sign);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().requestProfile().requestId()
                .build();
        client = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, (GoogleApiClient.OnConnectionFailedListener)this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        fname=(EditText)findViewById(R.id.editText);
        EditText lname=(EditText)findViewById(R.id.editText2);
        findViewById(R.id.sign_in_button).setOnClickListener(this);

    }

    public boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }



    @Override
    public  void onClick(View v) {
        if (v.getId() == R.id.sign_in_button) {
            if (isOnline()) {
                startActivityForResult(getSignInIntent(client), RC_SIGN_IN);

            }
            else{
                Toast toast=Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_SHORT);
                toast.show();
            }

        } else if (v.getId() == R.id.sign) {
            if (isOnline()) {
                Intent in = new Intent(this, main2.class);
                String name = fname.getText().toString();
                in.putExtra(EX, name);
                startActivity(in);
            } else {
                Toast toast=Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }


    GoogleSignInAccount acc;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                acc = result.getSignInAccount();
                Intent in=new Intent(this,main2.class);
                 String name=acc.getDisplayName();
                in.putExtra(EX,name);
                startActivity(in);
            }
        }



        }




    @Override
    public Intent getSignInIntent(GoogleApiClient googleApiClient) {
        return Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
    }

    @Override
    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        return null;
    }

    @Override
    public PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return null;
    }

    @Override
    public PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        return null;
    }



    @Override
    public GoogleSignInResult getSignInResultFromIntent(Intent intent){
        return null;
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {


    }
}


