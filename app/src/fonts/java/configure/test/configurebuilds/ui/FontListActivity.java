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

package configure.test.configurebuilds.ui;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import configure.test.configurebuilds.R;
import configure.test.configurebuilds.application.model.ActivityItem;
import configure.test.configurebuilds.ui.activities.test101.Font101Activity;
import configure.test.configurebuilds.ui.activities.test102.Font102Activity;

public class FontListActivity extends AppCompatActivity {

    @BindView(R.id.FontListActivity_list_RecyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_list);
        ButterKnife.bind(this);
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
        List<ActivityItem> activityItemList = new ArrayList<>();
        activityItemList.add(new ActivityItem(Font101Activity.class, "Font 101"));
        activityItemList.add(new ActivityItem(Font102Activity.class, "Font 102"));

        FontAdapter fontAdapter = new FontAdapter(activityItemList, this);
        recyclerView.setAdapter(fontAdapter);
        fontAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

class FontAdapter extends RecyclerView.Adapter<FontAdapter.ViewHolder> {

    private List<ActivityItem> activityItems;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public FontAdapter(List<ActivityItem> activityItems, Context mContext) {
        this.activityItems = activityItems;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.mLayoutInflater.inflate(R.layout.single_activity_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ActivityItem item = this.activityItems.get(position);
        holder.activityName.setText(item.getActivityName());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, item.getActivityClass()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.activityItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView rootView;
        private TextView activityName;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.single_activity_item_root_CardView);
            activityName = itemView.findViewById(R.id.single_activity_item_name_textView);
        }
    }
}
