package com.example.kotlin2_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlin2_1.databinding.FragmentFirstBinding
import com.example.kotlin2_1.databinding.FragmentSecondBinding

class SecondFragment : Fragment(), OnClickable {
    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private val adapter = Aadapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        binding.rvSecond.adapter = this.adapter
        adapter.run {
            setDataAnimeList(
                mutableListOf(
                    Data(R.drawable.img_4, "Хваюги"),
                    Data(R.drawable.img_5, "Школа 2017"),
                    Data(R.drawable.img_6, "Потомки солнца"),
                    Data(R.drawable.img_7, "Наступила ночь дора"),
                    Data(R.drawable.img_8, "Давай дерзай"),
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(data: Data) {
        findNavController().navigate(R.id.action_firstFragment_to_detalFragment)
    }
}

