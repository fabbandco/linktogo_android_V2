package com.fabbandco.link2goactivity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.link2goactivity4.R;
import com.fabbandco.android.model.DummyItem;
import com.fabbandco.link2goactivity4.dummy.DummyContent;

/**
 * A fragment representing a single Home detail screen. This fragment is either
 * contained in a {@link HomeListActivity} in two-pane mode (on tablets) or a
 * {@link HomeDetailActivity} on handsets.
 */
public class HomeDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	
	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public HomeDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home_detail,container, false);

		if (mItem != null) {
			LinearLayout linearL  = ((LinearLayout) rootView.findViewById(R.id.home_detail));
			if (mItem.havePicture()){
				ImageView imgV = new ImageView(getActivity());
				imgV.setBackgroundResource(R.drawable.cloud_synch);
				linearL.addView(imgV);
			}else{
				TextView tw = new TextView(getActivity());
				tw.setText(mItem.contentDummy);
				tw.setTextAppearance(getActivity(),R.style.AppBaseTheme);
				tw.setTextSize(20);
				tw.setTextColor(Color.BLACK);
				linearL.addView(tw);
			}
		}

		return rootView;
	}
	
	// Méthodes de callBack
}
