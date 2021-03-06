package com.fabbandco.link2goactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class HomeListActivity extends FragmentActivity implements
		HomeListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_list);

		if (findViewById(R.id.home_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((HomeListFragment) getSupportFragmentManager().findFragmentById(
					R.id.home_list)).setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link HomeListFragment.Callbacks} indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(HomeDetailFragment.ARG_ITEM_ID, id);
			HomeDetailFragment fragment = new HomeDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.home_detail_container, fragment).commit();
		} else {
			Intent detailIntent = new Intent(this, HomeDetailActivity.class);
			detailIntent.putExtra(HomeDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
