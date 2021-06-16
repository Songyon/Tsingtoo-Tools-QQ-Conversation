package tsingtoo.tools.qqcon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
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
        navView.setNavigationItemSelectedListener{

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
            R.id.about -> {
                Toast.makeText(this,"You click Delete!",Toast.LENGTH_SHORT).show()
            }
            R.id.AliPay -> {
                val alipay = packageManager.getLaunchIntentForPackage("com.eg.android.AlipayGphone")
                startActivity(alipay)
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