package airapps.io.learnkotlin.Utils

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by YGORR on 20/11/2017.
 */

class ShowSnackbar {

    companion object {
        fun showSnackbar(view: View, text: String, textAction: String): Unit {
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).setAction(textAction, null).show()
        }
    }
}