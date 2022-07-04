package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSecondBinding
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    // Probably arguments from navArgs
    val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        // Get count and apply to header
        val count = args.myArg
        val countText = getString(R.string.random_text, count)
        view.findViewById<TextView>(R.id.textview_second).text = countText

        // Get random header until 4
        val random = java.util.Random()
        var randomHeader = random.nextInt(4 + 1)

        // Check random header
        if(randomHeader == 0) {
            view.findViewById<TextView>(R.id.textview_second).text = "Mankind is Dead"
        } else if (randomHeader == 1) {
            view.findViewById<TextView>(R.id.textview_second).text = "Blood if Fuel"
        } else if (randomHeader == 2) {
            view.findViewById<TextView>(R.id.textview_second).text = "Hell is Full"
        }

        // Get random number
        // val random = java.util.Random()
        var randomNumber = 0
        if (count > 0) {
            randomNumber = random.nextInt(count + 1)
        }

        // Check random number and random header
        if(randomNumber == 0) {
            // Set random Header
            view.findViewById<TextView>(R.id.textview_random).text = "Death"
        }
        else if(randomHeader > 2) {
            // Set random header
            view.findViewById<TextView>(R.id.textview_random).text = randomNumber.toString()
        } else {
            // Generate a random character
            val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            val randomChar = source.get((randomNumber - 1) % 26)

            // Set random header
            view.findViewById<TextView>(R.id.textview_random).text = randomChar.toString()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}