package com.svkhackathon.kkilook

import java.lang.Math.random

class RandomRank {
    fun invoke(): Int {
        val list = listOf(
            R.drawable.tumbleweed,
            R.drawable.cactus,
            R.drawable.palmtree,
            R.drawable.flower
        )
        val randNum = (random() * 1000).mod(list.size.toDouble())
        return list[randNum.toInt()]
    }
    fun randHumidity(): Float{
        val randNum = (random() * 1000).mod(100.0) + 1
        return (randNum / 100).toFloat()
    }
}