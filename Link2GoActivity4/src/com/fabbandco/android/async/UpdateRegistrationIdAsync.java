package com.fabbandco.android.async;

import android.os.AsyncTask;

import com.fabbandco.android.api.CallRestWeb;
import com.fabbandco.android.application.PersistanceApplication;
import com.fabbandco.link2goactivity.HomeDetailFragment;

public class UpdateRegistrationIdAsync extends AsyncTask<String, String, Boolean> {
	private HomeDetailFragment linkActivite;

	public UpdateRegistrationIdAsync(final HomeDetailFragment _linkActivity) {
		this.linkActivite = _linkActivity;
	}

	protected Boolean doInBackground(String... params) {
		String resultWebServ = CallRestWeb.callWebService(PersistanceApplication.getInstance().getCurrentApplication(), "?action=updateRegistratione&login="+PersistanceApplication.getInstance().getUser().getEmail()+"&mdp="+PersistanceApplication.getInstance().getUser().getMdp()
				+"&registretionId=" + params[0]);
		try{
			if ("ok".equalsIgnoreCase(resultWebServ)){
				return true;
			}
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
		return false;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
    protected void onPostExecute(final Boolean _isOk) {
		this.linkActivite.updateRegistrationIdCallBackUpdateSynchro(_isOk);
    }

}
