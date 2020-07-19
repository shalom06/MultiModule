package com.shalom.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shalom.login.R
import kotlinx.android.synthetic.main.simple_selection_bottom_sheet.*

class LoginBottomSheet(private val onCLick: TextPickerInterface) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.simple_selection_bottom_sheet, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sign_in.setOnClickListener { onCLick.loginOptionSelected(LoginType.SIGN_IN);dismiss() }
        register.setOnClickListener { onCLick.loginOptionSelected(LoginType.REGISTER);dismiss() }

    }


}

interface TextPickerInterface {
    fun loginOptionSelected(selected: LoginType)
}

enum class LoginType(val text: String) {
    SIGN_IN("Sign In"),
    REGISTER("Register");
}