package cubex.mahesh.incexp_dec7am.view

import android.app.DatePickerDialog
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import cubex.mahesh.incexp_dec7am.R
import cubex.mahesh.incexp_dec7am.beans.IncExpBean
import cubex.mahesh.incexp_dec7am.model.IncExpModel
import cubex.mahesh.incexp_dec7am.presenter.PresenterAPI
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),ViewAPI {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePicker.setOnClickListener {
            var cal = Calendar.getInstance()
            var listener = object:DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    sd.setText(p3.toString() + "/"+(p2+1).toString()+"/"+p1.toString())
                }
            }

            var dpd = DatePickerDialog(
                this@MainActivity,listener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)
                ,cal.get(Calendar.DAY_OF_MONTH))
            dpd.show()
        }

        var api:PresenterAPI  = IncExpModel(this)

        save.setOnClickListener {
            var bean = IncExpBean(sd.text.toString(),
                money.text.toString().toInt(),
                desc.text.toString(),
                type.selectedItem.toString())
            api.save(bean)
        }

        read.setOnClickListener {
            api.read()
        }



    }

     override fun saveOutput(msg: String) {
        Toast.makeText(this@MainActivity,msg,
            Toast.LENGTH_LONG).show()

    }

    override fun readOutput(c: Cursor) {

        var from = arrayOf("date","money","_desc","type")
        var to = intArrayOf(R.id.date,R.id.money,R.id.desc,R.id.type)

        var cadapter = SimpleCursorAdapter(
            this@MainActivity,R.layout.indiview,
            c,from,to,0)
        lview.adapter = cadapter

        var inc_sum = 0
        var exp_sum = 0

        while(c.moveToNext()){
                    if(c.getString(4).equals("Income")){
                            inc_sum = inc_sum + c.getInt(2)
                    }else{
                            exp_sum = exp_sum + c.getInt(2)
                    }
        }

        tv_incsum.setText("Income sum : $inc_sum");
        tv_expsum.setText("Expense Sum : $exp_sum")

    }
}
