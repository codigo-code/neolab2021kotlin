package edu.neo.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import edu.neo.model.Persona
import java.lang.Exception

class DbHelper(
    context: Context, factory:
    SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {


    companion object {
        private val DATABASE_NAME = "persona.db"
        private val DATABASE_VERSION = 1

        val TABLE_NAME = "personas"
        val COLUMN_ID = "id"
        val COLUMN_NOMBRE = "nombre"
        val COLUMN_APELLIDO = "apellido"
        val COLUMN_MAIL = "mail"
        val COLUMN_FECHA_NACIMIENTO = "fechanac"
        val COLUMN_SEXO = "sexo"
        val COLUMN_FUMA = "fuma"
        val COLUMN_TRABAJO = "trabajo"

    }


    override fun onCreate(db: SQLiteDatabase?) {

        var createTable =
            ("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NOMBRE + " TEXT, " +
                    COLUMN_APELLIDO + " TEXT, " +
                    COLUMN_MAIL + " TEXT, " +
                    COLUMN_FECHA_NACIMIENTO + " TEXT, " +
                    COLUMN_SEXO + " TEXT, " +
                    COLUMN_FUMA + " TEXT, " +
                    COLUMN_TRABAJO + " TEXT ) ")





        db?.execSQL(createTable)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }


    fun savePerson(persona: Persona): Boolean {
        try {

            // recuperamos el objeto db para escritura en la base de datos
            val db = this.writableDatabase


            // armo los valores que voy a insertar en mi tabla persona
            val values = ContentValues()

            values.put(COLUMN_NOMBRE, persona.nombre)
            values.put(COLUMN_APELLIDO, persona.apellido)
            values.put(COLUMN_FECHA_NACIMIENTO, persona.fechaNacimiento)
            values.put(COLUMN_FUMA, persona.fuma)
            values.put(COLUMN_MAIL, persona.mail)
            values.put(COLUMN_TRABAJO, persona.trabajo)
            values.put(COLUMN_SEXO, persona.sexo)


            // query insert

            db.insert(TABLE_NAME, null, values)

            return true
        } catch (e: Exception) {
            Log.e("ERROR DATABASE:", e.message.toString())
            return false
        }
    }

    fun getAllPersonas(): ArrayList<Persona> {

        val db = this.readableDatabase
        val listapersonas: ArrayList<Persona> = ArrayList<Persona>()
        val query = "SELECT * FROM " + TABLE_NAME

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val apellido = cursor.getString(cursor.getColumnIndex(COLUMN_APELLIDO))
                val fechaNac = cursor.getString(cursor.getColumnIndex(COLUMN_FECHA_NACIMIENTO))
                val fuma = cursor.getString(cursor.getColumnIndex(COLUMN_FUMA))
                val mail = cursor.getString(cursor.getColumnIndex(COLUMN_MAIL))
                val sexo = cursor.getString(cursor.getColumnIndex(COLUMN_SEXO))
                val trabajo = cursor.getString(cursor.getColumnIndex(COLUMN_TRABAJO))
                var fumarb: Boolean = false
                if (fuma.equals("true")) {
                    fumarb = true
                }

                listapersonas.add(
                    Persona(
                        id,
                        nombre,
                        apellido,
                        fechaNac,
                        mail,
                        sexo,
                        fumarb,
                        trabajo
                    )
                )
            } while (cursor.moveToNext())

        }
        return listapersonas
    }

    fun modificarPersona(nombre: String, mail: String, id: Int): Boolean {
        var b: Boolean = false
        try {

            val db = this.writableDatabase

            val values = ContentValues()

            values.put(COLUMN_NOMBRE, nombre)
            values.put(COLUMN_MAIL, mail)

            val whereclause = "$COLUMN_ID=?"
            val whereargs = arrayOf(id.toString())

            db.update(TABLE_NAME, values, whereclause, whereargs)
            b = true
        } catch (e: Exception) {
            Log.e("Error al modificar", e.message.toString())
        }
        return b

    }

}