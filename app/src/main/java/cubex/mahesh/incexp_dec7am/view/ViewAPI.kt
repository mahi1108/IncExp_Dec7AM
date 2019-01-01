package cubex.mahesh.incexp_dec7am.view

import android.database.Cursor

interface ViewAPI {
    fun saveOutput(msg:String)
    fun readOutput(c:Cursor)
}