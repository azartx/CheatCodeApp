package com.solo4.cheatcodeapp.mappers

import android.util.Log
import com.solo4.cheatcodeapp.domain.model.PlatformCommand
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheatsheet.UiPlatformCommand
import javax.inject.Inject

class CommandMapper @Inject constructor() {
    fun toDomain(
        preferredPlatform: PreferredPlatform,
        uiPlatformCommands: List<UiPlatformCommand>
    ): List<PlatformCommand> {
        return when (preferredPlatform) {
            PreferredPlatform.XBOX -> {
                uiPlatformCommands.map { cmd ->
                    PlatformCommand.XboxCommand.entries
                        .first { it.name == (cmd as UiPlatformCommand.UiXboxCommand).name }
                }
            }

            PreferredPlatform.PLAY_STATION -> {
                uiPlatformCommands.map { cmd ->
                    PlatformCommand.PlayStationCommand.entries
                        .first { it.name == (cmd as UiPlatformCommand.UiPlayStationCommand).name }
                }
            }

            PreferredPlatform.PC -> {
                uiPlatformCommands.map { cmd ->
                    PlatformCommand.PCCommand.entries
                        .first { it.name == (cmd as UiPlatformCommand.UiPCCommand).name }
                }
            }

            else -> {
                Log.e("CommandMapper", "Failed to map commands, unknown platform")
                listOf()
            }
        }
    }

    fun toUi(
        preferredPlatform: PreferredPlatform,
        platformCommands: List<PlatformCommand>
    ): List<UiPlatformCommand> {
        return when (preferredPlatform) {
            PreferredPlatform.XBOX -> {
                platformCommands.map { cmd ->
                    UiPlatformCommand.UiXboxCommand.entries
                        .first { it.name == (cmd as PlatformCommand.XboxCommand).name }
                }
            }

            PreferredPlatform.PLAY_STATION -> {
                platformCommands.map { cmd ->
                    UiPlatformCommand.UiPlayStationCommand.entries
                        .first { it.name == (cmd as PlatformCommand.PlayStationCommand).name }
                }
            }

            PreferredPlatform.PC -> {
                platformCommands.map { cmd ->
                    UiPlatformCommand.UiPCCommand.entries
                        .first { it.name == (cmd as PlatformCommand.PCCommand).name }
                }
            }

            else -> {
                Log.e("CommandMapper", "Failed to map commands, unknown platform")
                listOf()
            }
        }
    }
}
