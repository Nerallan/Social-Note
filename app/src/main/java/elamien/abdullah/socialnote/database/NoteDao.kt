package elamien.abdullah.socialnote.database

import androidx.room.*
import io.reactivex.Flowable

/**
 * Created by AbdullahAtta on 7/19/2019.
 */
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note): Long

    @Query("SELECT * FROM Notes ORDER BY date_created DESC")
    fun getNotes(): Flowable<List<Note>>

    @Query("SELECT * FROM Notes WHERE note_id =:id")
    fun getNote(id: Long?): Flowable<Note>

    @Update
    fun updateNote(note: Note): Int

    @Delete
    fun deleteNote(note: Note): Int
}