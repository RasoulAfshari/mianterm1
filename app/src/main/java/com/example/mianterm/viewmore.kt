package com.example.mianterm

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class viewmore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmore)
        setStateLogin(this, true)

//        val btn_edit:Button=findViewById(R.id.btn_editmore)
//
//        btn_edit.setOnClickListener {
//            val builder=AlertDialog.Builder(this).create()
//            val view=layoutInflater.inflate(R.layout.dialog,null)
//            builder.setView(view)
//            builder.setCancelable(false)
//            builder.show()
//        }

        val tv_name=findViewById<TextView>(R.id.ac_main_frm2_tvname)
        val tv_family=findViewById<TextView>(R.id.ac_main_frm2_tvfamily)
        val tv_fathe=findViewById<TextView>(R.id.ac_main_frm2_tvfather)
        val tv_phone=findViewById<TextView>(R.id.ac_main_frm2_tvphone)
        val tv_jens=findViewById<TextView>(R.id.ac_main_frm2_tvJens)
        val tv_account=findViewById<TextView>(R.id.ac_main_frm2_tvacc)
        val tv_alaghe=findViewById<TextView>(R.id.ac_main_frm2_tvalghe)

        val frm1=findViewById<FrameLayout>(R.id.ac_main_frm1)
        val frm2=findViewById<FrameLayout>(R.id.ac_main_frm2)
        val edt_name=findViewById<EditText>(R.id.ac_main_edt_name)
        val edt_family=findViewById<EditText>(R.id.ac_main_edt_family)
        val edt_namefather=findViewById<EditText>(R.id.ac_main_edt_namefather)
        val edt_phone=findViewById<EditText>(R.id.ac_main_edt_phone)
        val rgb=findViewById<RadioGroup>(R.id.ac_main_rgb)
        val cb_Qoran=findViewById<CheckBox>(R.id.ac_main_cb_Qoran)
        val cb_Varzesh=findViewById<CheckBox>(R.id.ac_main_cb_Varzesh)
        val cb_Riazi=findViewById<CheckBox>(R.id.ac_main_cb_Riazi)
        val cb_Honar=findViewById<CheckBox>(R.id.ac_main_cb_Honar)
        val btn_confirm=findViewById<Button>(R.id.ac_main_btn_confirm)
        val btn_edit:Button=findViewById(R.id.btn_editMore)
        btn_edit.setOnClickListener {

            frm2.visibility= View.GONE
            frm1.visibility= View.VISIBLE
        }
        val sp_1= arrayOf("انتخاب کنید","حساب عادی","حساب برنزه","حساب طلایی")
        val sp_2=findViewById<Spinner>(R.id.ac_main_sp)
        val sp_adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_1)
        sp_2.adapter=sp_adapter



        btn_confirm.setOnClickListener {
            if(edt_name.text.toString()==""|| edt_family.text.toString()=="" || edt_namefather.text.toString()=="" || edt_phone.text.toString()==""){
                Toast.makeText(this,"قیلدها خالی میباشد", Toast.LENGTH_SHORT).show()
            }
            else if(!edt_phone.text.toString().startsWith("09")){
                Toast.makeText(this,"شماره موبایل باید از 09 شروع شود", Toast.LENGTH_SHORT).show()
            }
            else if(edt_phone.text.toString().length!=11){
                Toast.makeText(this,"شماره موبایل 11 رقمی است", Toast.LENGTH_SHORT).show()
            }

            else if(rgb.checkedRadioButtonId==-1){
                Toast.makeText(this,"جنسیت انتخاب نشده است.", Toast.LENGTH_SHORT).show()
            }

            else if(sp_2.selectedItemPosition==0){
                Toast.makeText(this, "حساب کاربری را انتخاب کنید", Toast.LENGTH_SHORT).show()
            }
            else if(!cb_Qoran.isChecked && !cb_Varzesh.isChecked && !cb_Riazi.isChecked && !cb_Honar.isChecked){
                Toast.makeText(this ,"گزینه مورد نظر خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Qoran.isChecked && cb_Varzesh.isChecked && cb_Riazi.isChecked && cb_Honar.isChecked){
                Toast.makeText(this ,"بیشتر از 2 گزینه نمیتواند انتخاب کرد", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Qoran.isChecked && cb_Varzesh.isChecked && cb_Riazi.isChecked){
                Toast.makeText(this ,"بیشتر از 2 گزینه نمیتواند انتخاب کرد", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Qoran.isChecked && cb_Varzesh.isChecked && cb_Honar.isChecked){
                Toast.makeText(this ,"بیشتر از 2 گزینه نمیتواند انتخاب کرد", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Qoran.isChecked && cb_Riazi.isChecked && cb_Honar.isChecked){
                Toast.makeText(this ,"بیشتر از 2 گزینه نمیتواند انتخاب کرد", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Varzesh.isChecked && cb_Riazi.isChecked && cb_Honar.isChecked){
                Toast.makeText(this ,"بیشتر از 2 گزینه نمیتواند انتخاب کرد", Toast.LENGTH_SHORT).show()
            }

            else{
                if(sp_2.selectedItemPosition==1){
                    tv_account.text="نوع اکانت : اکانت عادی"
                }
                if(sp_2.selectedItemPosition==2){
                    tv_account.text="نوع اکانت : اکانت برنزه"
                }
                if(sp_2.selectedItemPosition==3){
                    tv_account.text="نوع اکانت : اکانت طلایی"
                }
                if(cb_Qoran.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString()
                }
                if(cb_Varzesh.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString()
                }
                if(cb_Riazi.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString()
                }
                if(cb_Honar.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString()
                }
                if(cb_Qoran.isChecked && cb_Varzesh.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString() +" , "+cb_Varzesh.text.toString()
                }
                if(cb_Qoran.isChecked && cb_Riazi.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString() +" , "+cb_Riazi.text.toString()
                }
                if(cb_Qoran.isChecked && cb_Honar.isChecked){
                    tv_alaghe.text=cb_Qoran.text.toString() +" , "+cb_Honar.text.toString()
                }

                if(cb_Varzesh.isChecked && cb_Riazi.isChecked){
                    tv_alaghe.text=cb_Varzesh.text.toString() +" , "+cb_Riazi.text.toString()
                }
                if(cb_Varzesh.isChecked && cb_Honar.isChecked){
                    tv_alaghe.text=cb_Varzesh.text.toString() +" , "+cb_Honar.text.toString()
                }

                if(cb_Riazi.isChecked && cb_Honar.isChecked){
                    tv_alaghe.text=cb_Riazi.text.toString() +" , "+cb_Honar.text.toString()
                }


                frm1.visibility= View.GONE
                frm2.visibility=View.VISIBLE
                tv_name.text=edt_name.text.toString()
                tv_family.text=edt_family.text.toString()
                tv_fathe.text=edt_namefather.text.toString()
                tv_phone.text="  شماره موبایل:  "+edt_phone.text.toString()
                val rb=findViewById<RadioButton>(rgb.checkedRadioButtonId)
                tv_jens.text="جنسیت :   "+rb.text.toString()

                btn_edit.setOnClickListener {
                    frm1.visibility= View.GONE
                    frm2.visibility=View.VISIBLE
                }

            }
        }

    }
    private fun setStateLogin(context: Context, state: Boolean) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putBoolean("state",state)
        editor.apply()

    }
}