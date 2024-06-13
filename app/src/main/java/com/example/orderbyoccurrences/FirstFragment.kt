package com.example.orderbyoccurrences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.orderbyoccurrences.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val text = binding.editText.text.toString()
            if (text.isEmpty()) {
                binding.editText.error = "Campo obrigatório"
                return@setOnClickListener
            }

            val nav = FirstFragmentDirections.actionFirstFragmentToSecondFragment(text)
            findNavController().navigate(nav)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}