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

package configure.test.configurebuilds.activities

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
import configure.test.configurebuilds.R
import configure.test.configurebuilds.activities.test101.Animation101Activity
import configure.test.configurebuilds.application.model.ActivityItem
import kotlinx.android.synthetic.animations.activity_animation_list.*


class AnimationListActivity : AppCompatActivity() {

    private val list: MutableList<ActivityItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_list)
        setSupportActionBar(toolbar)

        initializeUi()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {
        val recyclerView = findViewById<RecyclerView>(R.id
                .AnimationListActivity_list_RecyclerView)

        if (list.isEmpty()) {
            list.add(ActivityItem(Animation101Activity::class.java, "Animation 101"));
        }
        recyclerView.adapter = AnimationAdapter(this, list)


    }

    class AnimationAdapter(val mContext: Context,
                           val list: List<ActivityItem>) :
            RecyclerView.Adapter<AnimationAdapter.ViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(mContext)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mLayoutInflater.inflate(R.layout.single_activity_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val activityItem = list[position]
            holder.activityName.text = activityItem.activityName
            holder.rootLayout.setOnClickListener {
                mContext.startActivity(Intent(mContext, activityItem.activityClass))
            }
        }

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val rootLayout: CardView = itemView!!.findViewById(R.id
                    .single_activity_item_root_CardView)
            val activityName: TextView = itemView!!.findViewById(R.id
                    .single_activity_item_name_textView)
        }
    }

}
