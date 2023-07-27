package com.solo4.cheatcodeapp.data.database

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.solo4.cheatcodeapp.data.database.deserializers.CheatDeserializer
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.Cheat
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RemoteDB @Inject constructor(private val deserializer: CheatDeserializer) {
    suspend fun getPlatformCheats(preferredPlatform: PreferredPlatform) =
        suspendCoroutine<List<Cheat>> { cont ->
            Firebase.firestore
                .collection(COLLECTION_CHEATS)
                .document(preferredPlatform.name)
                .get()
                .addOnSuccessListener {
                    cont.resume(deserializer.responseToCheats(it.data!!, preferredPlatform))
                }
                .addOnFailureListener {
                    Log.e("RemoteDB", it.stackTraceToString())
                    cont.resume(listOf())
                }
        }

    companion object {
        private const val COLLECTION_CHEATS = "cheats"
    }
}
