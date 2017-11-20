package airapps.io.learnkotlin.Database

import airapps.io.learnkotlin.Utils.Constants
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by YGORR on 20/11/2017.
 */
class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Mydatabase", null, 1) {

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
                Constants.DATABASE.DB_TABLE, true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                Constants.DATABASE.DB_COLUMN_NAME to TEXT,
                Constants.DATABASE.DB_COLUMN_EMAIL to TEXT + UNIQUE,
                Constants.DATABASE.DB_COLUMN_PASSWORD to TEXT
        )

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(Constants.DATABASE.DB_TABLE, true);
    }

}

val Context.database: MyDatabaseOpenHelper get() = MyDatabaseOpenHelper.getInstance(applicationContext)