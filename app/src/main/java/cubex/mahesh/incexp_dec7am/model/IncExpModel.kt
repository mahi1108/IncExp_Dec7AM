package cubex.mahesh.incexp_dec7am.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import cubex.mahesh.incexp_dec7am.beans.IncExpBean
import cubex.mahesh.incexp_dec7am.presenter.PresenterAPI
import cubex.mahesh.incexp_dec7am.view.MainActivity
import cubex.mahesh.incexp_dec7am.view.ViewAPI

class IncExpModel : PresenterAPI {

    var dBase : SQLiteDatabase? = null
    var mActivity : MainActivity? = null

    constructor(view_api:ViewAPI){

       mActivity  = view_api as MainActivity

        dBase = mActivity!!.openOrCreateDatabase(
            "IncExpDB", Context.MODE_PRIVATE,
            null)

        dBase!!.execSQL("create table if not exists incexp(_id integer primary key autoincrement,date varchar(20),money integer,_desc varchar(500),type varchar(50)) ")

    }

    override fun save(bean: IncExpBean) {
        var cv = ContentValues( )
        cv.put("date",bean.date)
        cv.put("money",bean.money)
        cv.put("_desc",bean.desc)
        cv.put("type",bean.type)

    var status = dBase!!.insert("incexp",
        null,cv)

     if(status!=-1L){
         mActivity!!.saveOutput("Record is Inserted....")
     }else{
         mActivity!!.saveOutput("Record  Insertion is Failed....")
     }

    }

    override fun read() {

        var c = dBase!!.query("incexp",null,null,
            null,null,null,null)
        mActivity!!.readOutput(c)
    }


}