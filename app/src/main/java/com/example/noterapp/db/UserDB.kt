package com.example.noterapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noterapp.dao.NotesDao
import com.example.noterapp.dao.UserDao
import com.example.noterapp.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDB: RoomDatabase() {

    abstract  val userDao: UserDao

    // singleton instances

    companion object{
        // THIS MAKES THE FIELD IMMEDIATELY VISIBILE TO OTHER THREAD
        @Volatile
        private var INSTANCE : UserDB? = null
        fun getInstance (context: Context) : UserDB{
            synchronized(this){
                var instance  = INSTANCE

                if (instance == null){

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDB::class.java,
                        "user_database"


                    ).build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}