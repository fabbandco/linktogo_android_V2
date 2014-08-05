package com.fabbandco.android.async;

import android.os.AsyncTask;

import com.fabbandco.android.api.CallRestWeb;
import com.fabbandco.android.application.PersistanceApplication;
import com.fabbandco.link2goactivity.HomeDetailFragment;

public class ValidateMessageSynchronisationAsync extends AsyncTask<String, String, Boolean> {
	private HomeDetailFragment linkActivite;

	public ValidateMessageSynchronisationAsync(final HomeDetailFragment _linkActivity) {
		this.linkActivite = _linkActivity;
	}

	protected Boolean doInBackground(String... params) {
		String resultWebServ = CallRestWeb.callWebService(PersistanceApplication.getInstance().getCurrentApplication(), "?action=validsynchromessage&login="+PersistanceApplication.getInstance().getUser().getEmail()+"&mdp="+PersistanceApplication.getInstance().getUser().getMdp()
				+"&messagekey=" + params[0]);
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
		this.linkActivite.validateMessageSynchronisationCallBackSynchro(_isOk);
    }

}
