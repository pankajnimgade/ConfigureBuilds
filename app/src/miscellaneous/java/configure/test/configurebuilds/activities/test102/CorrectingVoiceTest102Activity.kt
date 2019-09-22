package configure.test.configurebuilds.activities.test102

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.miscellaneous.activity_correcting_voice.*
import java.util.*


class CorrectingVoiceTest102Activity : AppCompatActivity() {

    private var textToSpeech: TextToSpeech? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correcting_voice)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUi()
    }

    private fun initializeUi() {

        textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                val ttsLang = textToSpeech?.setLanguage(Locale.US)

                if (ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "The Language is not supported!")
                } else {
                    Log.i("TTS", "Language Supported.")
                }
                Log.i("TTS", "Initialization success.")
            } else {
                Toast.makeText(applicationContext, "TTS Initialization failed!", Toast.LENGTH_SHORT).show()
            }
        })

        val list = mutableListOf<Word>()
        list.add(Word("Saga"))
        list.add(Word("Abbess"))

        recycler_view.adapter = WordAdapter(this, list, textToSpeech)
    }

    class WordAdapter(private val mContext: Context,
                      val list: List<Word>, val textToSpeech: TextToSpeech?) :
            RecyclerView.Adapter<WordAdapter.ViewHolder>() {

        private val mLayoutInflater: LayoutInflater = LayoutInflater.from(mContext)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mLayoutInflater.inflate(R.layout.single_word_item, parent, false)
            val viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                Log.d("Word", ": ${list[viewHolder.adapterPosition].text}")
                val bundle = Bundle()
                bundle.putString(TextToSpeech.Engine.KEY_PARAM_VOLUME, "0.75")
                textToSpeech?.speak(list[viewHolder.adapterPosition].text, TextToSpeech.QUEUE_FLUSH, bundle, null)
            }
            return viewHolder
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val word = list[position]
            holder.word_tv.text = word.text
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val word_tv: TextView = itemView.findViewById(R.id.tv_word)
        }
    }

    class Word(val text: String)
}
