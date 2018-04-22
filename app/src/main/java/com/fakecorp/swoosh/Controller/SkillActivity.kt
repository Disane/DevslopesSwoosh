package com.fakecorp.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fakecorp.swoosh.Model.Player
import com.fakecorp.swoosh.R
import com.fakecorp.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity()
{
    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClick(view: View){
        ballerSkillButton.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClick(view: View){
        beginnerSkillButton.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClick(view: View)
    {
        if(player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }
        else
        {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_LONG).show()
        }
    }
}
