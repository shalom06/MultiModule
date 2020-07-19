package com.shalom.multimodule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.shalom.login.ui.LoginBottomSheet
import com.shalom.login.ui.LoginType
import com.shalom.login.ui.TextPickerInterface
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), TextPickerInterface {
    lateinit var loginBottomSheet: LoginBottomSheet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_button.setOnClickListener {
            loginBottomSheet = LoginBottomSheet(this)
            loginBottomSheet.show(childFragmentManager, "login_sheet")
        }
    }

    override fun loginOptionSelected(selected: LoginType) {
        Snackbar.make(first_fragment, selected.text, Snackbar.LENGTH_LONG).show()
    }
}