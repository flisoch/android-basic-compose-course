package com.example.gridlist.data

import com.example.gridlist.R
import com.example.gridlist.model.Topic

class Datasource {
    fun loadTopics(): List<Topic> {
        return listOf<Topic>(
            Topic(R.string.name_architecture, R.string.count_architecture, R.drawable.architecture),
            Topic(R.string.name_business, R.string.count_business, R.drawable.business),
            Topic(R.string.name_design, R.string.count_design, R.drawable.design),
            Topic(R.string.name_film, R.string.count_film, R.drawable.film),
            Topic(R.string.name_drawing, R.string.count_drawing, R.drawable.drawing),
            Topic(R.string.name_music, R.string.count_music, R.drawable.music),
            Topic(R.string.name_photography, R.string.count_photography, R.drawable.photography),
            Topic(R.string.name_crafts, R.string.count_crafts, R.drawable.crafts),
            Topic(R.string.name_culinary, R.string.count_culinary, R.drawable.culinary),
            Topic(R.string.name_fashion, R.string.count_fashion, R.drawable.fashion),
            Topic(R.string.name_gaming, R.string.count_gaming, R.drawable.gaming),
            Topic(R.string.name_lifestyle, R.string.count_lifestyle, R.drawable.lifestyle),
            Topic(R.string.name_painting, R.string.count_painting, R.drawable.painting),
            Topic(R.string.name_tech, R.string.count_tech, R.drawable.tech),
            )
    }
}