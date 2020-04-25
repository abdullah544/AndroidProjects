package com.example.vkpart1kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News (
    var accImage: Int,
    var postHead: String,
    var postPhoto: Int,
    var postDate: String,
    var postText: String,
    var likeNum: Int,
    var comNum: Int,
    var replyNum: Int,
    var liked: Int,
    var like: Int
) : Parcelable