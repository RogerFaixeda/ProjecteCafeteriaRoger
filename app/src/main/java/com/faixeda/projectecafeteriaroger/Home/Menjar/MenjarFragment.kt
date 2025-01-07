package com.faixeda.projectecafeteriaroger.Home.Menjar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faixeda.projectecafeteriaroger.Home.CustomAdapter
import com.faixeda.projectecafeteriaroger.Home.SharedViewModel
import com.faixeda.projectecafeteriaroger.R
import com.faixeda.projectecafeteriaroger.databinding.FragmentMenjarBinding


class MenjarFragment : Fragment() {
    private lateinit var binding: FragmentMenjarBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: MenjarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenjarBinding.inflate(inflater)

        //ReciclerView
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this.activity)
        viewModel.generarProductes()
        val menjar = viewModel.menjar

        val adapterRecycler = CustomAdapter(menjar) { menuModel ->
            sharedViewModel.afegirAlMenu(menuModel)
        }

        recyclerView.adapter = adapterRecycler
        return binding.root
    }

}