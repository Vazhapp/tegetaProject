package ge.vazhapp.myapplication.data.model


import com.squareup.moshi.Json

data class ColorsItem(
    @Json(name = "apiUrl")
    val apiUrl: String? = "",
    @Json(name = "badgeUrl")
    val badgeUrl: String? = "",
    @Json(name = "dateCreated")
    val dateCreated: String? = "",
    @Json(name = "description")
    val description: String? = "",
    @Json(name = "hex")
    val hex: String? = "",
    @Json(name = "hsv")
    val hsv: Hsv? = null,
    @Json(name = "id")
    val id: Int? = -1,
    @Json(name = "imageUrl")
    val imageUrl: String? = "",
    @Json(name = "numComments")
    val numComments: Int? = -1,
    @Json(name = "numHearts")
    val numHearts: Int? = -1,
    @Json(name = "numViews")
    val numViews: Int? = -1,
    @Json(name = "numVotes")
    val numVotes: Int?,
    @Json(name = "rank")
    val rank: Int?,
    @Json(name = "rgb")
    val rgb: Rgb?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "userName")
    val userName: String?
) {
    constructor() : this(
        "apiUrl",
        "badgeUrl",
        "dateCreated",
        "description",
        "hex",
        null,
        -1,
        "imageUrl",
        -1,
        -1,
        -1,
        -1,
        -1,
        null,
        "title",
        "url",
        "userName"
    )

}
