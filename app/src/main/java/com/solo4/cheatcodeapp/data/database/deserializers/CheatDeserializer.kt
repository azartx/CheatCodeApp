package com.solo4.cheatcodeapp.data.database.deserializers

import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.Cheat
import com.solo4.cheatcodeapp.model.cheats.CheatCategory
import com.solo4.cheatcodeapp.model.cheats.PCCommand
import com.solo4.cheatcodeapp.model.cheats.PlayStationCommand
import com.solo4.cheatcodeapp.model.cheats.XboxCommand
import javax.inject.Inject

class CheatDeserializer @Inject constructor() {
    fun responseToCheats(responseMap: Map<String, Any>, platform: PreferredPlatform): List<Cheat> {
        val commandsList = if (platform == PreferredPlatform.PLAY_STATION) PlayStationCommand.entries else
            if (platform == PreferredPlatform.XBOX) XboxCommand.entries else PCCommand.entries
        val cheats = responseMap["cheats"] as ArrayList<Map<String, Any>>
        return cheats.map { cheatMap ->
            Cheat(
                id = (cheatMap["id"] as Long).toInt(),
                category = CheatCategory.all.first { it.databaseName == (cheatMap["category"] as String) },
                description = cheatMap["description"] as String,
                guide = (cheatMap["guide"] as ArrayList<String>).map { strCommand ->
                    commandsList.first { it.name == strCommand }
                }
            )
        }
    }
}
