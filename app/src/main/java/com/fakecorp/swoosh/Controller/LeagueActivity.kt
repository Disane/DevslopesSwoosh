package com.fakecorp.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fakecorp.swoosh.Utilities.EXTRA_LEAGUE
import com.fakecorp.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View){
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = "womens"
    }
    fun onCoedClicked(view: View){
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false

        selectedLeague = "co-ed"
    }

    fun leagueNextClicked(view: View)
    {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        }
        else
        {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }


}