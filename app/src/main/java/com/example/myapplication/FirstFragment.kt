package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

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
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // We can either use binding or view for this line
        // If binding: binding.randomButton.setOnClickListener
        // If view: view.findViewById<Button>(R.id.random_button).setOnClickListener
        binding.randomButton.setOnClickListener {
            // Get the text view
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

            // Get current count
            val currentCount = showCountTextView.text.toString().toInt()

            // Send Current Count to Fragment 2
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)

            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Get random header until 2
        val random = java.util.Random()
        var randomHeader = random.nextInt(2 + 1)

        // Check random number and random header
        if(randomHeader == 0) {
            view.findViewById<TextView>(R.id.look_first).text = ""
        } else if (randomHeader == 1) {
            view.findViewById<TextView>(R.id.look_first).text = "Don't Look"
        } else {
            view.findViewById<TextView>(R.id.look_first).text = "It's Here"
        }

        // Find a howl_button by id
        view.findViewById<Button>(R.id.howl_button).setOnClickListener {
            // Create a Toast with some text and duration
            val myHowl = Toast.makeText(context, "The Black Moon Howls Tonight",
                Toast.LENGTH_LONG)
            val myBlood = Toast.makeText(context, "Blood is Fuel",
                Toast.LENGTH_LONG)

            // Show Toast
            // myHowl.show()

            // Get random number until 4
            // val random = java.util.Random()
            var randomNumber = random.nextInt(4 + 1)

            // Check random number
            if(randomNumber < 3) {
                // Show Howl
                myHowl.show()
            } else {
                // Show Blood
                myBlood.show()
            }

        }

        // Find a count_button by id
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            // Calls countMe
            countMe(view)
        }


        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // A new function for count_button implementation
    private fun countMe(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

        // Get the count of text view
        val countString = showCountTextView.text.toString()

        // Increment count
        var count = countString.toInt()
        count++

        // Display new count
        showCountTextView.text = count.toString()
    }
}