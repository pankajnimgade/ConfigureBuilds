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
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import configure.test.configurebuilds.application.model.ActivityItem
import configure.test.configurebuilds.services.test101.ServiceTest101Activity
import configure.test.configurebuilds.services.test102.ServiceTest102Activity
import kotlinx.android.synthetic.services.activity_services_list.*


class ServicesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUi()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {
        val list = mutableListOf<ActivityItem>()
        list.add(ActivityItem(ServiceTest101Activity::class.java, "Service test 101"))
        list.add(ActivityItem(ServiceTest102Activity::class.java, "Intent Service 102"))

        val serviceAdapter = ServiceListAdapter(this, list)

        val recyclerView = findViewById<RecyclerView>(R.id.ServicesListActivity_list_RecyclerView)
        recyclerView.adapter = serviceAdapter

        serviceAdapter.notifyDataSetChanged()

    }

    class ServiceListAdapter(val mContext: Context,
                             val list: List<ActivityItem>) :
            RecyclerView.Adapter<ServiceListAdapter.ServiceViewHolder>() {

        private val mLayoutInflater = LayoutInflater.from(mContext)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
            val view = mLayoutInflater.inflate(R.layout.single_activity_item, parent, false)
            return ServiceViewHolder(view)
        }

        override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
            val activityItem = list[position]
            holder.activityName.text = activityItem.activityName
            holder.rootLayout.setOnClickListener {
                mContext.startActivity(Intent(mContext, activityItem.activityClass))
            }
        }

        override fun getItemCount(): Int {
            return list.size
        }

        class ServiceViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val rootLayout: CardView = itemView!!
                    .findViewById(R.id.single_activity_item_root_CardView)
            val activityName: TextView = itemView!!
                    .findViewById(R.id.single_activity_item_name_textView)
        }
    }
}