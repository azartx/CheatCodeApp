package com.solo4.cheatcodeapp.data.deserializers

import com.solo4.cheatcodeapp.data.model.CheatDto
import com.solo4.cheatcodeapp.domain.model.PlatformCommand
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import javax.inject.Inject

class CheatDeserializer @Inject constructor() {
    fun responseToCheats(responseMap: Map<String, Any>, platform: PreferredPlatform): List<CheatDto> {
        /*val commandsList = if (platform == PreferredPlatform.PLAY_STATION) PlayStationCommand.entries else
            if (platform == PreferredPlatform.XBOX) XboxCommand.entries else PCCommand.entries*/
        val cheats = responseMap["cheats"] as ArrayList<Map<String, Any>>
        return cheats.map { cheatMap ->
            CheatDto(
                id = (cheatMap["id"] as Long).toInt(),
                category = (cheatMap["category"] as String),
                description = cheatMap["description"] as String,
                platform = platform,
                guide = (cheatMap["guide"] as ArrayList<String>).map { strCommand ->
                    PlatformCommand.getCommand(strCommand, platform)
                }
            )
        }
    }
}
