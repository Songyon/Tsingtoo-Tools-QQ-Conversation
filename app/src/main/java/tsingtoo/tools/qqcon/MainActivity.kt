package tsingtoo.tools.qqcon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        button.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button->{
                val inputText= editText.text.toString()
                val qqUrl = "mqqwpa://im/chat?chat_type=wpa&version=1&uin="+inputText
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)


            }
        }
    }
}