/* @license
 * This file is part of the Game Closure SDK.
 *
 * The Game Closure SDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * The Game Closure SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with the Game Closure SDK.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tealeaf;

import com.tealeaf.AppFinder;
import com.tealeaf.AppInfo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tealeaf.test_app.TestAppActivity;

public class AppListView extends ListView implements View.OnClickListener, AdapterView.OnItemClickListener {
	private TestAppActivity activity;
	private String host = "";
	private int port = 0;
	private AppFinder finder;

	public AppListView(TestAppActivity activity) {
		super(activity);
		this.activity = activity;

		//setBackgroundColor(Color.WHITE);

		setOnItemClickListener(this);
	}

	public void refresh() {
		this.finder = new AppFinder(activity, activity, this.activity.getHost(), this.activity.getPort());
		host = this.activity.getHost();
		port = this.activity.getPort();
	}

	@Override
	public void onClick(View v) {
	}

	@Override
	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		// Prevent two fast mouse clicks from starting game twice causing a crash
		AppInfo app = finder.getApp(position);
		activity.setAppInfo(app);
		activity.setHost(host);
		activity.setPort(port);
		activity.setIsTestApp(true);
		activity.downloadDebugAppResources();
	}


}
