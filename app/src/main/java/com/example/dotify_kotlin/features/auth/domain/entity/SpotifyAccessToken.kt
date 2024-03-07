package com.example.dotify_kotlin.features.auth.domain.entity

import androidx.datastore.preferences.core.Preferences
import java.util.Date

data class AccessToken(
    val token: String ,
//    val scope: List<String> ,
    val createdDate: Date ,
){

}
