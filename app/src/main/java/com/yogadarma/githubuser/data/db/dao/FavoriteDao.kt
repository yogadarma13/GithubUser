package com.yogadarma.githubuser.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yogadarma.githubuser.domain.entity.UserData

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    fun getAllFavorite(): LiveData<List<UserData>>

    @Query("SELECT * FROM favorite WHERE id = :id")
    fun getFavoriteById(id: Int): UserData

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorite(favorite: UserData)

    @Delete
    suspend fun deleteFavorite(favorite: UserData)
}