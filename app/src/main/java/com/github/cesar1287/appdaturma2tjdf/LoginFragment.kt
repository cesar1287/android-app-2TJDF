package com.github.cesar1287.appdaturma2tjdf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.cesar1287.appdaturma2tjdf.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            with(it) {
                btLoginContinue.setOnClickListener {
                    val name = tieLoginName.text.toString()
                    val email = tieLoginEmail.text.toString()
                    val password = tieLoginPassword.text.toString()

                    if (name.isBlank()) {
                        tilLoginName.error = getString(R.string.error_empty_invalid_field)
                    } else {
                        tilLoginName.isErrorEnabled = false
                    }

                    Toast.makeText(
                        activity,
                        getString(R.string.user_saved_successfully),
                        Toast.LENGTH_SHORT
                    ).show()

                    val user = User(
                        number = 100.0,
                        password = password,
                        name = name,
                        age = 26,
                        email = email
                    )

                    val args = Bundle()
                    args.putParcelable(KEY_INTENT_USER, user)

                    findNavController().navigate(
                        R.id.action_loginFragment_to_mainFragment,
                        args
                    )
                }

                btLogin.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_loginFragment_to_aboutMeFragment
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val KEY_INTENT_NAME = "name"
        const val KEY_INTENT_EMAIL = "email"
        const val KEY_INTENT_PASSWORD = "password"
        const val KEY_INTENT_AGE = "age"
        const val KEY_INTENT_NUMBER = "number"
        const val KEY_INTENT_USER = "user"
    }
}