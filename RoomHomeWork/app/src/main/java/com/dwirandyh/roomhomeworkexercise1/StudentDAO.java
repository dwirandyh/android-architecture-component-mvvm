package com.dwirandyh.roomhomeworkexercise1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    void insert(Student student);

    @Query("select * from student_table")
    List<Student> getAllStudents();

    @Delete
    void delete(Student student);
}
