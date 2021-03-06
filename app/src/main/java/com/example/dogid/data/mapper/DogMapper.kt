package com.example.dogid.data.mapper

import com.example.dogid.data.datasource.FeedCategoryOption
import com.example.dogid.data.datasource.FeedResponseBody
import com.example.dogid.data.model.Dog
import com.example.dogid.data.model.DogBreed

class DogMapper {
    private val feedCategoryMap: Map<DogBreed, FeedCategoryOption> = mapOf(
        DogBreed.Husky to FeedCategoryOption.husky,
        DogBreed.Hound to FeedCategoryOption.hound,
        DogBreed.Pug to FeedCategoryOption.pug,
        DogBreed.Labrador to FeedCategoryOption.labrador
    )

    fun mapFeedCategoryOption(dogBreed: DogBreed): FeedCategoryOption? {
        return feedCategoryMap[dogBreed]
    }

    fun mapFeedResponse(feedResponseBody: FeedResponseBody): List<Dog> {
        val dogBreed: DogBreed = feedCategoryMap.filterValues { it.name == feedResponseBody.category }.keys.first()

        return feedResponseBody.list.map {
            Dog(
                it,
                dogBreed
            )
        }
    }
}