package uca.edu.brawlcharacters.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BrawlNetworkEntity (
        @SerializedName("id")
        @Expose
        var id: Int,

        @SerializedName("name")
        @Expose
        var name: String,

        @SerializedName("description")
        @Expose
        var description: String,

        @SerializedName("image")
        @Expose
        var image: String,
)