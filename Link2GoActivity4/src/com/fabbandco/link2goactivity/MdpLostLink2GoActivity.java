package com.fabbandco.link2goactivity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fabbandco.android.application.PersistanceApplication;
import com.fabbandco.common.Constante;

public class MdpLostLink2GoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdp_lost_link2_go);
        
    }
    
    public void sendMdpLost(View view){
    	Context context = this.getApplicationContext();
    	Toast toast = Toast.makeText(context, R.string.label_requete_envoye, Constante.duration_toast);
    	toast.show();
    	Intent i = new Intent(this,LoginLink2GoActivity.class);
    	PersistanceApplication.getInstance().setConnecte(false);
    	PersistanceApplication.getInstance().setUser(null);
    	startActivity(i);
    }
}
