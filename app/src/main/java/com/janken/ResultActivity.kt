package com.janken

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.janken.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    val gu = 0
    val choki = 1
    val pa = 2

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("MY_HAND",0)
        val myHand: Int

        myHand = when(id) {
            R.id.gu -> {
                binding.myHandImage.setImageResource(R.drawable.gu2)
                gu
            }
            R.id.choki -> {
                binding.myHandImage.setImageResource(R.drawable.choki2)
                choki
            }
            R.id.pa -> {
                binding.myHandImage.setImageResource(R.drawable.choki2)
                pa
            }
            else -> gu
        }
        //コンピュータの手を決める
        val comHand = (Math.random() *3).toInt()
        when(comHand){
            R.id.gu -> binding.comHandImage.setImageResource(R.drawable.gu)
            R.id.choki -> binding.comHandImage.setImageResource(R.drawable.choki)
            R.id.pa -> binding.comHandImage.setImageResource(R.drawable.pa)
        }

        //勝敗を決める
        val gameResult = (comHand -myHand +3) %3
        when(gameResult){
            0 -> binding.resultLabel.setText(R.string.result_draw)
            1 -> binding.resultLabel.setText(R.string.result_win)
            2 -> binding.resultLabel.setText(R.string.result_lose)
        }
        binding.backButton.setOnClickListener{ finish() }
    }
}