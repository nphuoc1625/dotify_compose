package com.example.dotify_kotlin.features.auth.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerDTO(
    @SerialName("external_urls")
    val externalUrls: ExternalUrlsDTO?,
//    val followers: FollowersDTO?,
    val href: String?,
    val id: String?,
    val type: String?,
    val uri: String?,
    @SerialName("display_name")
    val displayName: String?
)
