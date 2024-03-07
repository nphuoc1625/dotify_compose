package com.example.dotify_kotlin.features.auth.data.model

import kotlinx.serialization.Serializable

@Serializable
class ImageDTO(val url: String?,
               val height: Int?,
               val width: Int?)
