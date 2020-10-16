package com.example.madlevel3task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_rating.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RatingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        previous_btn.setOnClickListener {
            navigateToSummary()
        }

        showRandomAssessableGame()
    }

    //Take the values of the rating and the game name will be wrapped in a bundle and will then be sent to the SummaryFragment
    private fun navigateToSummary() {
        val args = Bundle()
        args.putFloat(ARG_GAME_RATING, rbBar.rating)
        args.putString(ARG_GAME_NAME, text_game.text.toString())

        findNavController().navigate(R.id.action_ratingFragment_to_summaryFragment, args)
    }

    //Picking a random game name from te list and show it as output on the app
    private fun showRandomAssessableGame() {
        val randomGame = listOf(
            "Red Dead Redemption 2", "Rocket League",
            "Shadow of the Tombraider"
        ).random()

        text_game.text = randomGame
    }
}