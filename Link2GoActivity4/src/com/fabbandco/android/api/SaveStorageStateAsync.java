package com.fabbandco.android.api;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.os.AsyncTask;

import com.fabbandco.android.application.Link2GoApplication;

public class SaveStorageStateAsync extends AsyncTask<Link2GoApplication, Integer, Void>{
	@Override
	protected Void doInBackground(Link2GoApplication... params) {
		Link2GoApplication application = params[0];

		try {
			FileOutputStream fichier = application.openFileOutput("storage.ser", Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(application.getStorageRequest().getHashTable());
			oos.flush();
			oos.close();
		}
		catch (java.io.IOException e) {
				e.printStackTrace();
		}
		return null;
	}
}
