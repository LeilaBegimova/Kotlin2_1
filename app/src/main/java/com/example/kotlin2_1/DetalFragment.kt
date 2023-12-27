package com.example.kotlin2_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kotlin2_1.databinding.FragmentDetalBinding
import com.example.kotlin2_1.databinding.FragmentFirstBinding


class DetalFragment : Fragment() {
    private var _binding: FragmentDetalBinding? = null
    private val binding: FragmentDetalBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val data = HandOfData.getData()

        data?.let {
            _binding?.imeg?.setImageResource(data.image)
            _binding?.tvAnimeName?.text = data.name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}