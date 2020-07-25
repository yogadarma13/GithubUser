package com.yogadarma.githubuser.data.db.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import com.yogadarma.githubuser.domain.entity.UserData

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    fun getAllFavorite(): Cursor

    @Query("SELECT * FROM favorite WHERE id = :id")
    fun getFavoriteById(id: Int?): Cursor

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavorite(favorite: UserData?): Long

    @Query("DELETE FROM favorite WHERE id = :id")
    fun deleteFavorite(id: Int?): Int
}