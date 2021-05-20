package com.github.cesar1287.appdaturma2tjdf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.github.cesar1287.appdaturma2tjdf.LoginFragment.Companion.KEY_INTENT_USER
import com.github.cesar1287.appdaturma2tjdf.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //        val name = intent.getStringExtra(KEY_INTENT_NAME)
//        val email = intent.getStringExtra(KEY_INTENT_EMAIL)
//        val password = intent.getStringExtra(KEY_INTENT_PASSWORD)
//        val age = intent.getIntExtra(KEY_INTENT_AGE, 0)
//        val number = intent.getDoubleExtra(KEY_INTENT_NUMBER, 0.0)

        val user = arguments?.getParcelable<User>(KEY_INTENT_USER)

        binding?.tvMainHelloWorld?.text = "Meu nome é ${user?.name}\n" +
                "Meu email é ${user?.email}\n" +
                "Minha senha é ${user?.password}\n" +
                "Minha idade é ${user?.age} - ${user?.number}"

        binding?.btMainTapMe?.setOnClickListener {
            binding?.tvMainHelloWorld?.text = "O número sorteado é ${(Math.random()*100).toInt()}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}