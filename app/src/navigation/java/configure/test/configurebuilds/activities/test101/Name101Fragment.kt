package configure.test.configurebuilds.activities.test101


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.navigation.fragment_account_101.*
import kotlinx.android.synthetic.navigation.fragment_name101.*


class Name101Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name101, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_name.text = arguments?.getString("nameArg")
    }




}
