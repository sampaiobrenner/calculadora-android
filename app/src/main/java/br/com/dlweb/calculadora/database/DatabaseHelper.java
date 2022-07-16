package br.com.dlweb.calculadora.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.dlweb.calculadora.R;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "calculadora";

    private static final String TABLE_HISTORICO = "historico";

    private static final String CREATE_TABLE_HISTORICO = "CREATE TABLE " + TABLE_HISTORICO + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "descricao VARCHAR(100)); ";

    private static final String DROP_TABLE_HISTORICO = "DROP TABLE IF EXISTS " + TABLE_HISTORICO;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HISTORICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_HISTORICO);
        onCreate(db);
    }

    public long createHistorico (String descricao) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("descricao", descricao);
        long id = db.insert(TABLE_HISTORICO, null, cv);
        db.close();
        return id;
    }

    public void getAllHistorico (Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "descricao"};
        Cursor data = db.query(TABLE_HISTORICO, columns, null, null,null, null, "descricao");
        int[] to = {R.id.textViewIdListarHistorico, R.id.textViewDescricaoListarHistorico, };
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context, R.layout.historico_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }
}
