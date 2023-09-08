package com.example.lifecyclev2

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsForm.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserDetailsForm : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity: UserActivity? = activity as UserActivity?
        val user: String? = activity?.user
        if (user != null) {
            Log.d("user", user)
        }
        val preferences : SharedPreferences? =
            this.activity?.getSharedPreferences("pref_$user", Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_user_details_form, container, false)

        val submitUserDetailsBtn = view.findViewById<Button>(R.id.submitUserDetails)
        submitUserDetailsBtn.setOnClickListener(){
            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
            val selectedRadio = radioGroup.checkedRadioButtonId
            editor?.putInt("radioChoice", selectedRadio)
            editor?.commit()

        }
        return inflater.inflate(R.layout.fragment_user_details_form, container, false )
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserDetailsForm.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserDetailsForm().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}