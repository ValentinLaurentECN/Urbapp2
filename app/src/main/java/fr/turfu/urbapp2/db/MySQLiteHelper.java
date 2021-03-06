package fr.turfu.urbapp2.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Class MySQLiteHelper
 * Role : implémentation de la base de données
 * <p>
 * Cette classe comporte :
 * - La déclaration des tables de la base
 * - La déclaration des colonnes de la base
 * - La création des requêtes qui permettent de créer la base
 * - Les méthode de création de la base
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    /**
     * Name of the local database
     */
    public static final String DATABASE_NAME = "local3.db";
    /*
     * NB : upgrading the version force the database to be deleted and recreated
     */
    public static final int DATABASE_VERSION = 9;

    /************************************************
     * Declaration of tables
     ************************************************/

    //--------------------------TABLES----------------------------
    public static final String TABLE_PROJECT = "Project";
    public static final String TABLE_GPSGEOM = "GpsGeom";
    public static final String TABLE_PIXELGEOM = "PixelGeom";
    public static final String TABLE_PHOTO = "Photo";
    public static final String TABLE_MATERIAL = "Material";
    public static final String TABLE_ELEMENTTYPE = "ElementType";
    public static final String TABLE_ELEMENT = "Element";

    //--------------------------TABLES GETTERS----------------------------

    /**
     * get the name of Table project
     *
     * @return String which is the name of table project
     */
    public static String getTableProject() {
        return TABLE_PROJECT;
    }

    /**
     * get the name of Table pixelgeom
     *
     * @return String which is the name of table pixelgeom
     */
    public static String getTablePixelgeom() {
        return TABLE_PIXELGEOM;
    }

    /**
     * get the name of Table photo
     *
     * @return String which is the name of table photo
     */
    public static String getTablePhoto() {
        return TABLE_PHOTO;
    }

    /**
     * get the name f Table material
     *
     * @return String which is the name of table material
     */
    public static String getTableMaterial() {
        return TABLE_MATERIAL;
    }

    /**
     * get the name f Table elementType
     *
     * @return String which is the name of table elementType
     */
    public static String getTableElementtype() {
        return TABLE_ELEMENTTYPE;
    }

    /**
     * get the name f Table element
     *
     * @return String which is the name of table element
     */
    public static String getTableElement() {
        return TABLE_ELEMENT;
    }

    /**
     * get the name f Table gpsgeom
     *
     * @return String which is the name of table gpsgeom
     */
    public static String getTableGpsgeom() {
        return TABLE_GPSGEOM;
    }


    /************************************************
     * Declaration of columns
     ************************************************/

    //-------------------------- Table Project----------------------------
    public static final String COLUMN_PROJECTID = "project_id";
    public static final String COLUMN_PROJECTNAME = "project_name";
    public static final String COLUMN_PROJECTDESCRIPTION = "project_description";
    public static final String COLUMN_PROJECTVERSION = "project_version";
    public static final String COLUMN_PROJECTISAVAILABLE = "project_isavailable";

    //-------------------------- Table GpsGeom----------------------------
    public static final String COLUMN_GPSGEOMID = "gpsGeom_id";
    public static final String COLUMN_GPSGEOMCOORD = "gpsGeom_thegeom";

    //-------------------------- Table Pixel Geom----------------------------
    public static final String COLUMN_PIXELGEOMID = "pixelGeom_id";
    public static final String COLUMN_PIXELGEOMCOORD = "pixelGeom_thegeom";

    //-------------------------- Table Photo----------------------------
    public static final String COLUMN_PHOTOID = "photo_id";
    public static final String COLUMN_PHOTODESCRIPTION = "photo_description";
    public static final String COLUMN_PHOTOAUTHOR = "photo_author";
    public static final String COLUMN_PHOTONAME = "photo_name";
    public static final String COLUMN_PHOTOPATH = "photo_path";
    public static final String COLUMN_PHOTOLASTMODIFICATION = "photo_last_modification";
    public static final String COLUMN_PHOTOPROJECTID = "project_id";

    //-------------------------- Table Material----------------------------
    public static final String COLUMN_MATERIALID = "material_id";
    public static final String COLUMN_MATERIALNAME = "material_name";

    //-------------------------- Table Element----------------------------
    public static final String COLUMN_ELEMENTTYPEID = "elementType_id";
    public static final String COLUMN_ELEMENTTYPENAME = "elementType_name";
    public static final String COLUMN_ELEMENTID = "element_id";
    public static final String COLUMN_ELEMENTCOLOR = "element_color";


    /************************************************
     * QUERIES
     ************************************************/
    /**
     * query to create table GPSGEOM
     */
    private static final String
            DATABASE_CREATE =
            "create table "
                    + TABLE_GPSGEOM + " ("
                    + COLUMN_GPSGEOMID + " INTEGER PRIMARY KEY , "
                    + COLUMN_GPSGEOMCOORD + " text not null"
                    + "); ";

    /**
     * query to create table PIXELGEOM
     */
    private static final String
            DATABASE_CREATE2 =
            "create table "
                    + TABLE_PIXELGEOM + " ("
                    + COLUMN_PIXELGEOMID + " INTEGER PRIMARY KEY , "
                    + COLUMN_PIXELGEOMCOORD + " text not null"
                    + "); ";

    /**
     * query to create table PROJECT
     */
    private static final String
            DATABASE_CREATE3 =
            "create table "
                    + TABLE_PROJECT + " ("
                    + COLUMN_PROJECTID + " INTEGER PRIMARY KEY, "
                    + COLUMN_PROJECTNAME + " text not null, "
                    + COLUMN_PROJECTVERSION + " DATE not null, "
                    + COLUMN_PROJECTISAVAILABLE + " BOOLEAN not null, "
                    + COLUMN_PROJECTDESCRIPTION + " text , "
                    + COLUMN_GPSGEOMID + " INTEGER, "
                    + "FOREIGN KEY(" + COLUMN_GPSGEOMID + ") REFERENCES " + TABLE_GPSGEOM + " (" + COLUMN_GPSGEOMID + ")"
                    + ");";
    /**
     * query to create table PHOTO
     */
    private static final String
            DATABASE_CREATE4 =
            "create table "
                    + TABLE_PHOTO + " ("
                    + COLUMN_PHOTOID + " INTEGER PRIMARY KEY , "
                    + COLUMN_PHOTODESCRIPTION + " text , "
                    + COLUMN_PHOTOAUTHOR + " text not null, "
                    + COLUMN_PHOTONAME + " text , "
                    + COLUMN_PHOTOPATH + " text not null, "
                    + COLUMN_PHOTOPROJECTID + " INTEGER not null, "
                    + COLUMN_PHOTOLASTMODIFICATION + " DATETIME, "
                    + COLUMN_GPSGEOMID + " INTEGER, "
                    + "FOREIGN KEY(" + COLUMN_GPSGEOMID + ") REFERENCES " + TABLE_GPSGEOM + " (" + COLUMN_GPSGEOMID + "),"
                    + "FOREIGN KEY(" + COLUMN_PHOTOPROJECTID + ") REFERENCES " + TABLE_PROJECT + " (" + COLUMN_PROJECTID + ")"
                    + ");";
    /**
     * query to create table MATERIAL
     */
    private static final String
            DATABASE_CREATE5 =
            "create table "
                    + TABLE_MATERIAL + " ("
                    + COLUMN_MATERIALID + " INTEGER PRIMARY KEY , "
                    + COLUMN_MATERIALNAME + " text not null "

                    + ");";
    /**
     * query to create table ELEMENTTYPE
     */
    private static final String
            DATABASE_CREATE6 =
            "create table "
                    + TABLE_ELEMENTTYPE + " ("
                    + COLUMN_ELEMENTTYPEID + " INTEGER PRIMARY KEY , "
                    + COLUMN_ELEMENTTYPENAME + " text not null "
                    + ");";

    /**
     * query to create table ELEMENT
     */
    private static final String
            DATABASE_CREATE8 =
            "create table "
                    + TABLE_ELEMENT + " ("
                    + COLUMN_ELEMENTID + " INTEGER PRIMARY KEY , "
                    + COLUMN_PHOTOID + " INTEGER, "
                    + COLUMN_MATERIALID + " INTEGER, "
                    + COLUMN_GPSGEOMID + " INTEGER, "
                    + COLUMN_PIXELGEOMID + " INTEGER, "
                    + COLUMN_ELEMENTTYPEID + " INTEGER, "
                    + COLUMN_ELEMENTCOLOR + " text not null, "
                    + "FOREIGN KEY(" + COLUMN_PHOTOID + ") REFERENCES " + TABLE_PHOTO + " (" + COLUMN_PHOTOID + "),"
                    + "FOREIGN KEY(" + COLUMN_MATERIALID + ") REFERENCES " + TABLE_MATERIAL + " (" + COLUMN_MATERIALID + "),"
                    + "FOREIGN KEY(" + COLUMN_GPSGEOMID + ") REFERENCES " + TABLE_GPSGEOM + " (" + COLUMN_GPSGEOMID + "),"
                    + "FOREIGN KEY(" + COLUMN_PIXELGEOMID + ") REFERENCES " + TABLE_PIXELGEOM + " (" + COLUMN_PIXELGEOMID + "),"
                    + "FOREIGN KEY(" + COLUMN_ELEMENTTYPEID + ") REFERENCES " + TABLE_ELEMENTTYPE + " (" + COLUMN_ELEMENTTYPEID + ")"
                    + ");";

    //-------------------------QUERIES GETTERS----------------------------

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate() {
        return DATABASE_CREATE;
    }

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate2() {
        return DATABASE_CREATE2;
    }

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate3() {
        return DATABASE_CREATE3;
    }

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate4() {
        return DATABASE_CREATE4;
    }

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate5() {
        return DATABASE_CREATE5;
    }

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate6() {
        return DATABASE_CREATE6;
    }

    /**
     * getter for createquery of related number
     *
     * @return the query as String
     */
    public static String getDatabaseCreate7() {
        return DATABASE_CREATE8;
    }


    /************************************************
     * Construction de la base de données
     ************************************************/
    /**
     * Constructor
     *
     * @param context context of our activity
     */
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Methode onCreate : création des tables lors de la création de la base de données
     *
     * @param database Base de données
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        /**
         * we call each methods to create every table
         */
        database.execSQL(getDatabaseCreate());
        database.execSQL(getDatabaseCreate2());
        database.execSQL(getDatabaseCreate3());
        database.execSQL(getDatabaseCreate4());
        database.execSQL(getDatabaseCreate5());
        database.execSQL(getDatabaseCreate6());
        database.execSQL(getDatabaseCreate7());
    }

    /**
     * Méthode onUpgrade : appelée à chaque changement de version pour la base de données
     *
     * @param db         Base de données
     * @param oldVersion Ancienne version
     * @param newVersion Nouvelle version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version" + oldVersion + " to " + newVersion + ", which will destroy all your data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GPSGEOM + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PIXELGEOM + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHOTO + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATERIAL + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEMENT + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEMENTTYPE + " ;");

        onCreate(db);
    }


}

