package configure.test.configurebuilds.ui.activities.test105

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.dataBinding.single_person_item.view.*

class PersonAdapter(val list: List<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.single_person_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(person: Person) {
            with(itemView) {
                first_name_tv.text = person.firstName
                last_name_tv.text = person.lastName
            }
        }

    }
}