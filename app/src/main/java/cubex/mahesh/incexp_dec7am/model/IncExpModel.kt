package cubex.mahesh.incexp_dec7am.model

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

        dBase!!.execSQL("create table if not exists incexp(_id int primary key autoincrement,date varchar(20),money int,_desc varchar(500),type varchar(50)) ")

    }

    override fun save(bean: IncExpBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun read() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}