package com.example.lifecyclev2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserForm.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserForm : Fragment() {
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity: UserActivity? = activity as UserActivity?
        val user: String? = activity?.user
        if (user != null) {
            Log.d("user", user)
        }
        val preferences: SharedPreferences? =
            this.activity?.getSharedPreferences("pref_$user", Context.MODE_PRIVATE)
        val editor = preferences?.edit()

        val submitUserInfoBtn = view.findViewById<Button>(R.id.submitUserInfo)
        val nameText = view.findViewById<EditText>(R.id.userNameInput)
        val ageText = view.findViewById<EditText>(R.id.userAgeInput)
        if (preferences != null) {
            nameText.setText(preferences.getString("name", ""), TextView.BufferType.EDITABLE)
            ageText.setText(preferences.getInt("age", 0).toString(), TextView.BufferType.EDITABLE)
        }

        submitUserInfoBtn.setOnClickListener {

            editor?.putString("name", nameText.text.toString())
            editor?.putInt("age", ageText.text.toString().toInt())
            Log.d("shared", "kom hit ")
            editor?.commit()

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserForm.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = UserForm().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}