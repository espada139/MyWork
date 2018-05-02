package com.zero.bless

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import com.zero.bless.demo.fragment.MyFragmentActivity
import com.zero.bless.demo.test.DemoOne
import com.zero.bless.mvp.ui.home.HomeActivity
import com.zero.library_z_pub.sys.db.DBManager
import com.zero.library_z_pub.sys.provider.ContactsHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Build.VERSION.SDK_INT >= 23)
        {

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.UPDATE_DEVICE_STATS) != PackageManager.PERMISSION_GRANTED)
            {

                requestPermissions(arrayOf(Manifest.permission.UPDATE_DEVICE_STATS), 1)

            }

        }

        testContact();
        testDB();
        testDemo();

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1){

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){

                this.reportFullyDrawn();

            }

        }

    }

    fun testContact() {

        var contactHelper : ContactsHelper = ContactsHelper.getInstance();

        contactHelper.init(applicationContext);

        contactHelper.getContacts();

    }

    fun testDB(){

        DBManager.getInstance().init(applicationContext);

    }

    fun testDemo(){

        var demoOneBtn : Button = findViewById(R.id.demo_one_btn);

        demoOneBtn.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

                var intent : Intent = Intent();
                intent.setClass(this@MainActivity, DemoOne::class.java);
//                intent.setClass(this@MainActivity, HomeActivity::class.java);
                startActivity(intent);

            }

        })


        var myFragmentBtn : Button = findViewById(R.id.my_fragment);

        myFragmentBtn.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

                var intent : Intent = Intent();
//                intent.setClass(this@MainActivity, MyFragmentActivity::class.java);
                intent.setClass(this@MainActivity, HomeActivity::class.java);
                startActivity(intent);

            }

        })


    }

}
