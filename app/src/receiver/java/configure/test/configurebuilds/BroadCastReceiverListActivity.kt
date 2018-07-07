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

package configure.test.configurebuilds

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.application.model.ActivityItem
import configure.test.configurebuilds.receiver.activites.BroadExample101Activity
import kotlinx.android.synthetic.receiver.activity_broad_cast_receiver_list.*


class BroadCastReceiverListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast_receiver_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUi()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {
        val list: MutableList<ActivityItem> = mutableListOf()

        list.add(ActivityItem(BroadExample101Activity::class.java, "Broad Example 101"))

        val listRecyclerView: RecyclerView = findViewById(R.id.BroadCastReceiverListActivity_list_RecyclerView)
        val listAdapter: ListAdapter = ListAdapter(this, list)
        listRecyclerView.adapter = listAdapter
        listAdapter.notifyDataSetChanged()
    }

    private class ListAdapter(val context: Context,
                              val list: List<ActivityItem>) :
            RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context);

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(mLayoutInflater.inflate(R.layout.single_activity_item, parent,
                    false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val activityItem = list[position]
            holder.activityName.text = activityItem.activityName
            holder.rootLayout.setOnClickListener {
                context.startActivity(Intent(context, activityItem.activityClass))
            }
        }

        private class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val rootLayout: ViewGroup = itemView!!.findViewById(R.id.single_activity_item_root_CardView)
            val activityName: TextView = itemView!!.findViewById(R.id
                    .single_activity_item_name_textView)
        }
    }

}
