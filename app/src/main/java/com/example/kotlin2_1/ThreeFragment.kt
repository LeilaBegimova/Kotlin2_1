package com.example.kotlin2_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlin2_1.databinding.FragmentSecondBinding
import com.example.kotlin2_1.databinding.FragmentThreeBinding


class ThreeFragment : Fragment(), OnClickable {
    private var _binding: FragmentThreeBinding? = null
    private val binding: FragmentThreeBinding get() = _binding!!
    private val adapter = Aadapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        binding.rvThree.adapter = this.adapter
        adapter.setDataAnimeList(
            mutableListOf(
                Data(R.drawable.img_9, "Второй брак императрицы"),
                Data(R.drawable.img_10, "Лунный сад"),
                Data(R.drawable.img_11, "Прелести садизма"),
                Data(R.drawable.img_12, "Любовь - просто Иллюзия Королева"),
                Data(R.drawable.img_13, "Однажды я стала принцессой"),
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(data: Data) {
        findNavController().navigate(R.id.action_firstFragment_to_detalFragment)
    }
}