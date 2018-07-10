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

package configure.test.configurebuilds.services.test102

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.services.activity_service_test102.*
import kotlinx.android.synthetic.services.content_service_test102.*


class ServiceTest102Activity : AppCompatActivity() {

    private val TAG = "ServiceTest102Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_test102)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUi()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {
        ServiceTest102Activity_start_button.setOnClickListener {
            Log.d(TAG, ": before calling service")
            for (index in 1..10) {
                startService(Intent(this, MyIntentServiceTest102::class.java))
            }
            for (index in 1..5) {
                Log.d(TAG, ": after calling service")
            }
        }
    }

}
