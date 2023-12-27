package com.example.kotlin2_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin2_1.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), OnClickable {
    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val adapter = Aadapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        binding.rvFirst.adapter = this.adapter
        adapter.setDataAnimeList(
            mutableListOf(
                Data(R.drawable.anime, "Смотреть Провожающая в последний путь Фрирен "),
                Data(R.drawable.img, "Хантер х хантер"),
                Data(R.drawable.img_1, "Атака титанов"),
                Data(R.drawable.img_2, "Очень приятно бог"),
                Data(R.drawable.img_3, "Президент студсовета горничная персонажи")

            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(data: Data) {
        findNavController().navigate(R.id.action_firstFragment_to_detalFragment)
        HandOfData.setData(data)
    }
}

