package airapps.io.learnkotlin.Utils

import android.util.Patterns

/**
 * Created by YGORR on 20/11/2017.
 */

class StringUtils{

    companion object {

        fun checkIsntEmpty(text: String): Boolean {
            return !text.isEmpty()
        }

        fun isValidEmail (email: String): Boolean{
            return checkIsntEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}