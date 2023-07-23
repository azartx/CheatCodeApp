package com.solo4.cheatcodeapp.model.cheats

import com.solo4.cheatcodeapp.R

interface Command {
    val imageResId: Int
}

enum class XboxCommand(override val imageResId: Int) : Command {
    /*LEFT(1),
    RIGHT,
    UP,
    DOWN,*/
    LB(R.drawable.xbox_lb),
    RB(R.drawable.xbox_rb),
    LT(R.drawable.xbox_lt),
    RT(R.drawable.xbox_rt),
    /*XBOX,
    MENU,
    X,
    Y,
    A,
    B*/
}

enum class PlayStationCommand(override val imageResId: Int) : Command {
    LEFT(1),
//    RIGHT,
//    UP,
//    DOWN,
//    R1,
//    R2,
//    L1,
//    L2,
//    TRIANGLE,
//    CIRCLE,
//    X,
//    SQUARE,
//    START,
//    SELECT
}

enum class PCCommand(override val imageResId: Int) : Command {
    PHONE(1),
    CONSOLE(2)
}
