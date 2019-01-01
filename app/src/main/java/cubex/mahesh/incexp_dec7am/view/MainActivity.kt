package cubex.mahesh.incexp_dec7am.view

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cubex.mahesh.incexp_dec7am.R

class MainActivity : AppCompatActivity(),ViewAPI {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     override fun saveOutput(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readOutput(c: Cursor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
