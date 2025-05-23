package com.example.notes.Database;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notes.Models.Notes;

import java.util.List;

@Dao
public interface mainDAO {

    //Метод,позволяющий вставлять данные в таблицу
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    //Метод,позволяющий получать данные
    @Query("SELECT * FROM notes ORDER BY id DESC")//Последняя заметка будет в начале списка
    List<Notes> getAll();

    //Обновление данных
    @Query("UPDATE notes SET title =:title, notes = :notes WHERE ID = :id ")
    void uppdate (int id, String title, String notes);

    @Delete
    void delete(Notes notes);


}
