package com.solo4.cheatcodeapp.data.datasource.database

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.solo4.cheatcodeapp.data.datasource.CheatDatasource
import com.solo4.cheatcodeapp.data.deserializers.CheatDeserializer
import com.solo4.cheatcodeapp.data.model.CheatDto
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FirebaseCheatsDatabase @Inject constructor(private val deserializer: CheatDeserializer) : CheatDatasource {
    override fun getPlatformCheats(preferredPlatform: PreferredPlatform): Single<List<CheatDto>> =
        Single.create { emitter ->
            Firebase.firestore
                .collection(COLLECTION_CHEATS)
                .document(preferredPlatform.name)
                .get()
                .addOnSuccessListener {
                    emitter.onSuccess(deserializer.responseToCheats(it.data!!, preferredPlatform))
                }
                .addOnFailureListener {
                    Log.e("RemoteDB", it.stackTraceToString())
                    emitter.onSuccess(listOf())
                }
        }

    companion object {
        private const val COLLECTION_CHEATS = "cheats"
    }
}
