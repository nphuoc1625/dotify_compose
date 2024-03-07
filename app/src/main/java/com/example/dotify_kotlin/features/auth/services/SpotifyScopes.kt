package com.example.dotify_kotlin.features.auth.services

class SpotifyScopes {
    companion object {
        const val UGC_IMAGE_UPLOAD = "ugc-image-upload"

        const val USER_READ_PLAYBACK_STATE = "user-read-playback-state"
        const val USER_MODIFY_PLAYBACK_STATE = "user-modify-playback-state"
        const val USER_READ_CURRENTLY_PLAYING = "user-read-currently-playing"

        const val APP_REMOTE_CONTROL = "app-remote-control"
        const val STREAMING = "streaming"

        const val PLAYLIST_READ_PRIVATE = "playlist-read-private"
        const val PLAYLIST_READ_COLLABORATIVE = "playlist-read-collaborative"
        const val PLAYLIST_MODIFY_PRIVATE = "playlist-modify-private"
        const val PLAYLIST_MODIFY_PUBLIC = "playlist-modify-public"

        const val USER_FOLLOW_MODIFY = "user-follow-modify"
        const val USER_FOLLOW_READ = "user-follow-read"

        const val USER_READ_PLAYBACK_POSITION = "user-read-playback-position"
        const val USER_TOP_READ = "user-top-read"
        const val USER_READ_RECENTLY_PLAYED = "user-read-recently-played"

        const val USER_LIBRARY_MODIFY = "user-library-modify"
        const val USER_LIBRARY_READ = "user-library-read"

        const val USER_READ_EMAIL = "user-read-email"
        const val USER_READ_PRIVATE = "user-read-private"

        const val USER_SOA_LINK = "user-soa-link"
        const val USER_SOA_UNLINK = "user-soa-unlink"
        const val USER_MANAGE_ENTITLEMENTS = "user-manage-entitlements"
        const val USER_MANAGE_PARTNER = "user-manage-partner"
        const val USER_CREATE_PARTNER = "user-create-partner"

        fun playlistScopes(): Array<String> {
            return arrayOf(
                PLAYLIST_READ_PRIVATE,
                PLAYLIST_READ_COLLABORATIVE,
                PLAYLIST_MODIFY_PRIVATE,
                PLAYLIST_MODIFY_PUBLIC
            )
        }
    }
}

