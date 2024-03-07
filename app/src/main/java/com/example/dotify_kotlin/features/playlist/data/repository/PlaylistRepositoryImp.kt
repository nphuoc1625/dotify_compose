
import com.example.dotify_kotlin.features.playlist.data.datasources.PlaylistApi
import com.example.dotify_kotlin.features.playlist.domain.PlaylistEntity
import com.example.dotify_kotlin.features.playlist.domain.PlaylistRepository
import retrofit2.HttpException
import java.io.IOException

class PlaylistRepositoryImp(
    private val  playlistApi: PlaylistApi
) : PlaylistRepository  {

   override  suspend fun getCurrentUserPlaylists(): List<PlaylistEntity>? {
        return try {
            val result =  playlistApi.getCurrentUserPlaylists(10,0).items
            result.map { it.toEntity() }
        } catch (e: IOException) {
            null
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun getPlaylist(): List<PlaylistEntity>? {
        TODO("Not yet implemented")
    }
}