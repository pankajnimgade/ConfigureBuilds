/*
 * Copyright 2018 Pankaj Nimgade
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package configure.test.configurebuilds;

import android.app.Application;

import java.util.List;

import configure.test.configurebuilds.activities.RoomListActivity;
import configure.test.configurebuilds.activities.database.AppDatabase;
import configure.test.configurebuilds.application.model.ActivityItem;

/**
 * Created by Pankaj Nimgade on 3/11/2018.
 */

public class StartUp extends Application {

    private static final String TAG = "START_UP";

    private AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        List<ActivityItem> activityItemList = ActivityItem.getActivityItemList();
        activityItemList.add(0, new ActivityItem(RoomListActivity.class, "Room List"));

        initializeRoomDatabase();
    }

    private void initializeRoomDatabase() {

        mAppDatabase = AppDatabase.getAppDatabase(this);
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }
}
