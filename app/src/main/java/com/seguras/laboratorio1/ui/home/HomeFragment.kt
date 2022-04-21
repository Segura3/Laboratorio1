package com.seguras.laboratorio1.ui.home

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import com.seguras.laboratorio1.R
import com.seguras.laboratorio1.databinding.FragmentHomeBinding
import java.util.regex.Pattern

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReg.setOnClickListener {

            if(validaCampos()){
                Toast.makeText(context, getString(R.string.success)+binding.tietName.text, Toast.LENGTH_SHORT).show()
                binding.tietName.setText("")
                binding.tietMail.setText("")
                binding.tietPass.setText("")
            }
        }
    }

    fun validaCampos(): Boolean{

        val pswRegex = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=[^A-Za-z]*[A-Za-z])" +        //at least 1 letter
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$")
        var res = true

        with(binding){
            if(tietName.text.toString().isEmpty()){
                tietName.error = getString(R.string.required)
                res = false
            }else tietName.error = null
            if(tietMail.text.toString().isEmpty()){
                tietMail.error = getString(R.string.required)
                res = false
            }else if(!Patterns.EMAIL_ADDRESS.matcher(tietMail.text.toString()).matches()){
                tietMail.error = getString(R.string.validemail)
                res = false
            }else tietMail.error = null
            if(tietPass.text.toString().isEmpty()){
                tietPass.error = getString(R.string.required)
                res = false
            }else if(!pswRegex.matcher(tietPass.text).matches()){
                tietPass.error = getString(R.string.validpass)
                res = false
            } else tietPass.error = null
        }
        return res
    }
}