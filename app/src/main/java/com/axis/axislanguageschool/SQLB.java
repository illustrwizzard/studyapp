package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLB extends SQLiteOpenHelper {


    private static int version=13;
    private static String dbname="mydbnewDB1";
    String role;






    public SQLB(@Nullable Context context) {

        super(context, dbname, null,version);






    }


    public void deletetable(){
        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from student_details");
        DB.execSQL("delete from Role");
        DB.execSQL("delete from Role_admin");
        DB.execSQL("delete from meeting_details");

        DB.execSQL("delete from member_details");

        DB.close();
    }


    public void deletetable_permission(){
        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from Permission_details");
        DB.close();
    }






    public void insertprof_img(Uri profile_img){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("profile_img", String.valueOf(profile_img));

        db.insert("profile_img",null,contentValues);

    }

public ArrayList<StudentDetailsDataClass>getLoginstudentDetails(){
        ArrayList<StudentDetailsDataClass> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from student_details",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(new StudentDetailsDataClass(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9)));
        res.moveToNext();

        }
        return arrayList;
}




////Get Meeting Details


    @SuppressLint("Range")
    public ArrayList<MeetingDetailsDataClass>getMeetingDetails(){
        ArrayList<MeetingDetailsDataClass> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT DISTINCT meet_code from meeting_details",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(new MeetingDetailsDataClass(res.getString(res.getColumnIndex("meet_code"))));
            res.moveToNext();

        }
        return arrayList;
    }


    ///Get Time in Hours

    public String getTime_in_hours(String verify_code){
        String time;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT sum (total_time) from meeting_details where verify_code in ("+"'"+verify_code+"'"+")",null);
        res.move(1);
        time=res.getString(0);
        return time;

    }

    ////////////////
    public String getTime_in_hours_single(String verify_code,String meeting_code){
        String time;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT sum (total_time) from attendance_details where verify_code in ("+"'"+verify_code+"'"+") and meeting_code in ("+"'"+meeting_code+"'"+")",null);
        res.move(1);
        time=res.getString(0);
        return time;

    }





//    @SuppressLint("Range")
//    public ArrayList<MeetingDetailsDataClass>getMeetingTime_In_Hours(String verify_code){
//        ArrayList<MeetingDetailsDataClass> arrayList=new ArrayList<>();
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor res=db.rawQuery("SELECT sum (total_time) from meeting_details where verify_code in ("+verify_code+")",null);
//        res.moveToFirst();
//        while (!res.isAfterLast()){
//            arrayList.add(new MeetingDetailsDataClass(res.getString(res.getColumnIndex("total_time"))));
//            res.moveToNext();
//
//        }
//        return arrayList;
//    }



    ////INSERT STUDENT DETAILS



    public void insert_studentDetails(String role,String batchname,String name,String email,String address,String mobile,String date_of_joining,String verify_code,String dob){

        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("role",role);
        contentValues.put("batch_name",batchname);
        contentValues.put("student_name",name);
        contentValues.put("email",email);
        contentValues.put("address",address);
        contentValues.put("mobile_no",mobile);
        contentValues.put("date_join",date_of_joining);
        contentValues.put("verify_code",verify_code);
        contentValues.put("DOB",dob);
        db.insert("student_details",null,contentValues);
    }


    //////Insert Member Details

    public void insert_memberdetails(String role,String batchname,String name,String email,String address,String mobile,String date_of_joining,String verify_code,String dob){

        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("role",role);
        contentValues.put("batch_name",batchname);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("address",address);
        contentValues.put("mobile_no",mobile);
        contentValues.put("date_join",date_of_joining);
        contentValues.put("verify_code",verify_code);
        contentValues.put("DOB",dob);
        db.insert("member_details",null,contentValues);
    }


    ////INSERT MEETING DETAILS





    public void insert_meetingdetails(String batch,String meet_code,String verify_code,String date,String status,String time,String total_time){

        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("batch",batch);
        contentValues.put("meet_code",meet_code);
        contentValues.put("verify_code",verify_code);
        contentValues.put("date",date);
        contentValues.put("status",status);
        contentValues.put("time",time);
        contentValues.put("total_time",total_time);

        db.insert("meeting_details",null,contentValues);
    }


    public void insert_Permissiondetails(String attendace,String student,String assignment,String test,String video,String live_class,String study_material){

        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("attendance",attendace);
        contentValues.put("student",student);
        contentValues.put("assignment",assignment);
        contentValues.put("test",test);
        contentValues.put("video",video);
        contentValues.put("live_class",live_class);
        contentValues.put("study_material",study_material);
        db.insert("Permission_details",null,contentValues);
    }


    ////GEt Permission Details

    public ArrayList<PermissionDataClass>getPermissionDetails(){
        ArrayList<PermissionDataClass> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from Permission_details",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(new PermissionDataClass(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)));
            res.moveToNext();

        }
        return arrayList;
    }















    public void insertrole(String role){


        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("role",role);
        db.insert("Role",null,contentValues);
    }



    public int role_count(){
        SQLiteDatabase db=getReadableDatabase();
        // String count_string=" SELECT * FROM " + login_hold;
        Cursor c=db.rawQuery("select * from Role",null);
        int count=c.getCount();
        return count;
    }


    /////ADMIN ROLE

    public void insertrole_admin(String role,String verify_code){


        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("role",role);
        contentValues.put("verify_code",verify_code);
        db.insert("Role_admin",null,contentValues);
    }


    //////INSERT ATTENDANCE



    public void insert_attendance_Role(String status,String total_time,String date,String meeting_code){

        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status",status);
        contentValues.put("date",date);
        contentValues.put("total_time",total_time);
        contentValues.put("meeting_code",meeting_code);
        db.insert("attendance_details",null,contentValues);


    }






    public String getrole_admin(){
        String role="Admin";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from Role_admin ",null);
        res.move(1);
        role=res.getString(1);


        return role;

    }


    public Uri getImage(){
        ArrayList<Uri>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from profile_img",null);
        res.moveToFirst();
        arrayList.add(res.getNotificationUri());
        return arrayList.get(1);


    }

    //   public ArrayList<UnvdataClass> getuniv_details_single_bookmark1(String univ_name){
    //
    //        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
    //        SQLiteDatabase db = this.getReadableDatabase();
    //        Cursor res =  db.rawQuery( "select * from univ_details_bookmark1 where university_name in ("+'"'+univ_name+'"'+") ", null );
    //        res.moveToFirst();
    //
    //        while(res.isAfterLast() == false){
    //            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
    //            res.moveToNext();
    //        }
    //
    //        return arrayList;
    //
    //    }
//
//    public ArrayList<String> get_role(){
//        ArrayList<String> arrayList=new ArrayList<>();
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor res=db.rawQuery("select * from Role",null);
//        res.moveToFirst();
//        while (res.isAfterLast()==false){
//            arrayList.add(new String());
//
//        }
//        return arrayList;
//
//    }

    public String getrole(){
        //String role;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from Role",null);
        res.moveToFirst();
        try {
            role=res.getString(0);
        }catch (CursorIndexOutOfBoundsException e){
            e.printStackTrace();
        }


        return role;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String student="create table profile_img(id integer primary key autoincrement,profile_img uri)";
        db.execSQL(student);



        String student_details="create table student_details (id integer primary key autoincrement,role text,batch_name text,student_name text,email text," +
                "address text,mobile_no text,date_join text,verify_code text,DOB text)";

        String member_details="create table member_details (id integer primary key autoincrement,role text,batch_name text,name text,email text," +
                "address text,mobile_no text,date_join text,verify_code text,DOB text)";



        String permission_details="create table Permission_details (id integer primary key autoincrement,attendance text,student text,assignment text,test text," +
                "video text,live_class text,study_material text)";


        String role="create table Role(role text)";



        String meeting_details="create table meeting_details (id integer primary key autoincrement,batch text,meet_code text,verify_code text,date text,status text,time text,total_time text)";


        String attendance_details="create table attendance_details (id integer primary key autoincrement,status text,date text,total_time text,meeting_code text)";


        String role_admin="create table Role_admin(role text,verify_code text)";
        db.execSQL(student_details);
        db.execSQL(member_details);
        db.execSQL(attendance_details);
        db.execSQL(role_admin);
        db.execSQL(role);
        db.execSQL(meeting_details);
        db.execSQL(permission_details);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS profile_img");
        db.execSQL("DROP TABLE IF EXISTS student_details");
        db.execSQL("DROP TABLE IF EXISTS Role");
        db.execSQL("DROP TABLE IF EXISTS Role_admin");
        db.execSQL("DROP TABLE IF EXISTS meeting_details");
        db.execSQL("DROP TABLE IF EXISTS Permission_details");
        db.execSQL("DROP TABLE IF EXISTS attendance_details");

    }
}
