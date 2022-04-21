package com.seguras.laboratorio1.model

import java.io.Serializable

data class Movie(var id: Int, var name: String, var genre: String, var rdate: String, var image: String, var trailer: String, var desc: String): Serializable
