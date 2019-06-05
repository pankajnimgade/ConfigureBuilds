package configure.test.configurebuilds.activities.test101


import android.os.Bundle
import androidx.core.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import configure.test.configurebuilds.R


class Test101HomeFragment : Fragment() {

    lateinit var goToAccount: Button
    lateinit var goToSetting: Button

    companion object {

        private val TAG = "Test101HomeFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_test101_home, container, false)
        goToAccount = view.findViewById(R.id.goToAccount)
        goToSetting = view.findViewById(R.id.goToSetting)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToAccount.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAccount))
        goToSetting.setOnClickListener {
            it.findNavController().navigate(R.id.toSetting)
        }


    }

}
