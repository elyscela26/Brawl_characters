package uca.edu.brawlcharacters.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BrawlerNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("descripcion")
    @Expose
    var descripcion: String,
)