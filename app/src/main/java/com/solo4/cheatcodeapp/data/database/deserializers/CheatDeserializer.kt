package com.solo4.cheatcodeapp.data.database.deserializers

import com.solo4.cheatcodeapp.model.cheats.Cheat
import com.solo4.cheatcodeapp.model.cheats.CheatCategory

class CheatDeserializer {
    fun responseToCheats(responseMap: Map<String, Any>): List<Cheat> {
        val cheats = responseMap["cheats"] as ArrayList<Map<String, Any>>
        return cheats.map { cheatMap ->
            Cheat(
                id = (cheatMap["id"] as Long).toInt(),
                category = CheatCategory.all.first { it.databaseName == (cheatMap["category"] as String) },
                description = cheatMap["description"] as String,
                guide = (cheatMap["guide"] as ArrayList<String>).toList()
            )
        }
    }
}
