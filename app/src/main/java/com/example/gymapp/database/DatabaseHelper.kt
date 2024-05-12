package com.example.gymapp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.gymapp.models.TaskListModel

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private val DB_NAME = "task"
        private val DB_VERSION = 1
        private val TABLE_NAME = "tasklist"
        private val ID = "id"
        private val EXERCISE = "exercise"
        private val DAYS = "days"
        private val DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $EXERCISE TEXT, $DAYS INTEGER, $DATE TEXT);"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun getAllTask(): List<TaskListModel> {
        val taskList = ArrayList<TaskListModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            val idxId = cursor.getColumnIndex(ID)
            val idxExercise = cursor.getColumnIndex(EXERCISE)
            val idxDays = cursor.getColumnIndex(DAYS)
            val idxDate = cursor.getColumnIndex(DATE)

            if (idxId != -1 && idxExercise != -1 && idxDays != -1 && idxDate != -1) {
                do {
                    val tasks = TaskListModel().apply {
                        id = cursor.getInt(idxId)
                        exercise = cursor.getString(idxExercise)
                        days = cursor.getInt(idxDays)
                        date = cursor.getString(idxDate)
                    }
                    taskList.add(tasks)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return taskList
    }
    //insert
    fun addTask(tasks: TaskListModel): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(EXERCISE, tasks.exercise)
            put(DAYS, tasks.days)
            put(DATE, tasks.date)
        }
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        return (_success != -1L)
    }
    //select
    fun getTask(_id: Int) : TaskListModel {
        val tasks = TaskListModel()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $ID = $_id"
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            val idxId = cursor.getColumnIndex(ID)
            val idxExercise = cursor.getColumnIndex(EXERCISE)
            val idxDays = cursor.getColumnIndex(DAYS)
            val idxDate = cursor.getColumnIndex(DATE)

            if (idxId != -1 && idxExercise != -1 && idxDays != -1 && idxDate != -1) {
                tasks.id = cursor.getInt(idxId)
                tasks.exercise = cursor.getString(idxExercise)
                tasks.days = cursor.getInt(idxDays)
                tasks.date = cursor.getString(idxDate)
            }
        }
        cursor.close()
        return tasks
    }
    fun deleteTask(_id: Int): Boolean{
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, ID + "=?", arrayOf(_id.toString()))
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun updateTask(tasks: TaskListModel) : Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(EXERCISE,tasks.exercise)
        values.put(DAYS,tasks.days)
        values.put(DATE,tasks.date)
        val _success = db.update(TABLE_NAME,values,ID + "=?", arrayOf(tasks.id.toString()))
        db.close()
        return Integer.parseInt("$_success") != -1
    }
}
