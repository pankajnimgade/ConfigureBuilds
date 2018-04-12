package configure.test.configurebuilds.activities.decorator_one;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import configure.test.configurebuilds.R;

/**
 * https://proandroiddev.com/itemdecoration-in-android-e18a0692d848
 */
public class DecoratorOneActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_one);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUI();
    }

    private void initializeUI() {
        mRecyclerView = findViewById(R.id.DecoratorOneActivity_list_RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MyListItem> myListItems = new ArrayList<>();
        myListItems.add(new MyListItem("First Name", "Last Name"));
        myListItems.add(new MyListItem("First Name", "Last Name"));
        myListItems.add(new MyListItem("First Name", "Last Name"));
        myListItems.add(new MyListItem("First Name", "Last Name"));
        myListItems.add(new MyListItem("First Name", "Last Name"));
        myListItems.add(new MyListItem("First Name", "Last Name"));

        MyAdapter adapter = new MyAdapter(this, myListItems);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mRecyclerView.addItemDecoration(new OneItemDecoration(getDrawable(R.drawable.divider_one_drawable)));

    }

    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private Context mContext;
        private List<MyListItem> myListItems;
        private LayoutInflater mLayoutInflater;

        public MyAdapter(Context mContext, List<MyListItem> myListItems) {
            this.mContext = mContext;
            this.myListItems = myListItems;
            this.mLayoutInflater = LayoutInflater.from(mContext);
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(mLayoutInflater.inflate(R.layout.single_name_item, parent,
                    false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            MyListItem myListItem = myListItems.get(position);
            holder.firstNameTextView.setText(myListItem.firstName);
            holder.lastNameTextView.setText(myListItem.lastName);
        }

        @Override
        public int getItemCount() {
            return myListItems.size();
        }

        static class MyViewHolder extends RecyclerView.ViewHolder {
            TextView firstNameTextView;
            TextView lastNameTextView;

            public MyViewHolder(View itemView) {
                super(itemView);
                firstNameTextView = itemView.findViewById(R.id.single_first_name_textView);
                lastNameTextView = itemView.findViewById(R.id.single_last_name_textView);
            }
        }
    }

    private class MyListItem {
        String firstName;
        String lastName;

        public MyListItem(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}