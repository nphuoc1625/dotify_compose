

import com.example.dotify_kotlin.features.auth.data.model.ImageDTO
import com.example.dotify_kotlin.features.auth.data.model.OwnerDTO
import com.example.dotify_kotlin.features.playlist.domain.PlaylistEntity
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistDTO(
    val id: String?,
    val images: List<ImageDTO>?,
    val name: String?,
    val owner: OwnerDTO?,
){
    fun toEntity() : PlaylistEntity{
        return PlaylistEntity(
          id = this.id ?:"",
          imageUrl= this.images?.first()?.url ?: "",
          name= this.name ?:"",
          owner = this.owner?.displayName ?:"",
        )
    }


}