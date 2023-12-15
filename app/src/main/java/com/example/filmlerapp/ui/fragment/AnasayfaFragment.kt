package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.filmlerapp.R
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter
import com.example.filmlerapp.ui.viewmodel.AnasayfaViewmodel



class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewmodel: AnasayfaViewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaToolbarBaslik= "Filmler"

        viewmodel.filmlerListesi.observe(viewLifecycleOwner){

            val filmlerAdapter = FilmlerAdapter(requireContext(),it)
            binding.filmlerAdapter = filmlerAdapter

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewmodel by viewModels()
        viewmodel= tempViewModel
    }
}