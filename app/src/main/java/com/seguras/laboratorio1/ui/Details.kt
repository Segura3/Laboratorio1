package com.seguras.laboratorio1.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.seguras.laboratorio1.R
import com.seguras.laboratorio1.databinding.ActivityDetailsBinding
import com.seguras.laboratorio1.model.Movie

class Details : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val movie = bundle?.getSerializable("selMoview") as Movie

        binding.tvMovieName.text = movie.name
        binding.tvDescription.text = movie.desc
        binding.vvTrailer.setVideoPath("android.resource://"+getPackageName()+"/raw/"+movie.trailer)

        val mc: MediaController = MediaController(this)
        mc.setAnchorView(binding.vvTrailer)
        binding.vvTrailer.setMediaController(mc)
        binding.vvTrailer.start()
    }
}