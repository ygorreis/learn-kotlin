package airapps.io.learnkotlin

import airapps.io.learnkotlin.Security.Encryption
import airapps.io.learnkotlin.Utils.Constants
import airapps.io.learnkotlin.Utils.ShowSnackbar
import airapps.io.learnkotlin.Utils.StringUtils
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingComponents()
    }

    private fun settingComponents() {
        btn_sign.setOnClickListener { view ->
            if (StringUtils.isValidEmail(et_email.text.toString())) {
                if (StringUtils.checkIsntEmpty(et_password.text.toString())) {
                    callActivity()
                } else {
                    ShowSnackbar.showSnackbar(view, "Email isnt valid", "Action")
                }
            } else {
                ShowSnackbar.showSnackbar(view, "Password isnt valid", "Action")
            }
        }
    }

    private fun callActivity() {
        val intent = Intent(this, AboutActivity::class.java)
        intent.putExtra(Constants.Strings.EMAIL, et_email.text.toString())
        intent.putExtra(Constants.Strings.PASSWORD, Encryption.sha256(et_password.text.toString()))
        startActivity(intent)
    }
}
