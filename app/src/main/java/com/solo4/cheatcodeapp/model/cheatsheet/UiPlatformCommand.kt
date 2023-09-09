package com.solo4.cheatcodeapp.model.cheatsheet

import com.solo4.cheatcodeapp.R

sealed interface UiPlatformCommand {

    abstract val imageResId: Int
    enum class UiXboxCommand(override val imageResId: Int) : UiPlatformCommand {
        LEFT(R.drawable.xbox_left),
        RIGHT(R.drawable.xbox_right),
        UP(R.drawable.xbox_up),
        DOWN(R.drawable.xbox__down),
        SHARE(R.drawable.xbox_share),
        LB(R.drawable.xbox_lb),
        RB(R.drawable.xbox_rb),
        LT(R.drawable.xbox_lt),
        RT(R.drawable.xbox_rt),
        HOME(R.drawable.xbox_home),
        MENU(R.drawable.xbox_menu),
        X(R.drawable.xbox_x),
        Y(R.drawable.xbox_y),
        A(R.drawable.xbox_a),
        B(R.drawable.xbox_b)
    }

    enum class UiPlayStationCommand(override val imageResId: Int) : UiPlatformCommand {
        LEFT(R.drawable.ps_left),
        RIGHT(R.drawable.ps_right),
        UP(R.drawable.ps_up),
        DOWN(R.drawable.ps_down),
        R1(R.drawable.ps_r1),
        R2(R.drawable.ps_r2),
        L1(R.drawable.ps_l1),
        L2(R.drawable.ps_l2),
        TRIANGLE(R.drawable.pc_triangle),
        CIRCLE(R.drawable.ps_circle),
        X(R.drawable.ps_cross),
        SQUARE(R.drawable.ps_square),
        HOME(R.drawable.ps_home),
        OPTIONS(R.drawable.ps_options)
    }

    enum class UiPCCommand(override val imageResId: Int) : UiPlatformCommand {
        PHONE(R.drawable.pc_phone),
        CONSOLE(R.drawable.pc_console)
    }
}
