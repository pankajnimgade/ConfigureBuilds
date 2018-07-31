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

package configure.test.configurebuilds.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import configure.test.configurebuilds.R;
import configure.test.configurebuilds.activities.test101.Test101Activity;
import configure.test.configurebuilds.application.model.ActivityItem;

public class VerifyingListActivity extends AppCompatActivity {

    private RecyclerView testingListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifying_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initializeUi();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeUi() {
        testingListRecyclerView = findViewById(R.id.VerifyingListActivity_testing_recyclerView);

        List<ActivityItem> mActivityItems = createList();
        VerifyAdapter verifyAdapter = new VerifyAdapter(this, mActivityItems);
        testingListRecyclerView.setAdapter(verifyAdapter);
        verifyAdapter.notifyDataSetChanged();
    }

    private List<ActivityItem> createList() {
        List<ActivityItem> activityItems = new ArrayList<>();
        activityItems.add(new ActivityItem(Test101Activity.class, "Test 101"));
        return activityItems;
    }


    private static class VerifyAdapter extends RecyclerView.Adapter<VerifyAdapter.ViewHolder> {

        private Context mContext;
        private List<ActivityItem> mActivityItems;
        private LayoutInflater mLayoutInflater;

        public VerifyAdapter(Context mContext, List<ActivityItem> mActivityItems) {
            this.mContext = mContext;
            this.mActivityItems = mActivityItems;
            this.mLayoutInflater = LayoutInflater.from(this.mContext);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = this.mLayoutInflater.inflate(R.layout.single_activity_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final ActivityItem activityItem = this.mActivityItems.get(position);
            holder.activityTitle.setText("" + activityItem.getActivityName());

            holder.rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, activityItem.getActivityClass()));
                }
            });
        }

        @Override
        public int getItemCount() {
            return this.mActivityItems.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {

            private CardView rootLayout;
            private TextView activityTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                rootLayout = itemView.findViewById(R.id.single_activity_item_root_CardView);
                activityTitle = itemView.findViewById(R.id.single_activity_item_name_textView);
            }
        }
    }

}
