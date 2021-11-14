package tsingtoo.tools.qqcon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.outline_menu_24)
        }

//        navView.setCheckedItem(R.id.about)
        navView.setNavigationItemSelectedListener{item->
            when(item.itemId){
                R.id.about -> {
                    AlertDialog.Builder(this).apply {
                        setTitle("关于")
                        setMessage("QQ账号强制查找\n© 2021 Tsingtoo Tools\nWritten in Kotlin\nDeveloped in Android Studio\nReinforced by 360 TIANYU")
                        setPositiveButton("好的"){ _, _ -> }
                        setCancelable(false)
                        show()
                    }
                }
            }
            drawerLayout.closeDrawers()
                true
            }
        button.setOnClickListener(this)
    }

    override fun onBackPressed() {
//        DrawerLayout drawerLayout = (drawerLayout) findViewById(R.id.drawerLayout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home->{
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return true
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button->{
                val inputText= editText.text.toString()
                val qqUrl = "mqqwpa://im/chat?chat_type=wpa&version=1&uin=$inputText"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }
    }
}