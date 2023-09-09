package com.solo4.cheatcodeapp.domain.model

sealed interface PlatformCommand {
    enum class XboxCommand : PlatformCommand {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        SHARE,
        LB,
        RB,
        LT,
        RT,
        HOME,
        MENU,
        X,
        Y,
        A,
        B
    }

    enum class PlayStationCommand : PlatformCommand {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        R1,
        R2,
        L1,
        L2,
        TRIANGLE,
        CIRCLE,
        X,
        SQUARE,
        HOME,
        OPTIONS
    }

    enum class PCCommand : PlatformCommand {
        PHONE,
        CONSOLE
    }

    companion object {
        fun getCommand(commandName: String, preferredPlatform: PreferredPlatform): PlatformCommand {
            return when (preferredPlatform) {
                PreferredPlatform.PC -> PlatformCommand.PCCommand.entries.first { it.name == commandName }
                PreferredPlatform.PLAY_STATION -> PlatformCommand.PlayStationCommand.entries.first { it.name == commandName }
                PreferredPlatform.XBOX -> PlatformCommand.XboxCommand.entries.first { it.name == commandName }
                else -> throw NotImplementedError()
            }
        }
    }
}
