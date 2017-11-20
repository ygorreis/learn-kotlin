package airapps.io.learnkotlin.Security

import airapps.io.learnkotlin.Utils.Constants
import java.security.MessageDigest

/**
 * Created by YGORR on 20/11/2017.
 */
object Encryption{

    fun sha512(password: String) = hashString("SHA-512", password)

    fun sha256(password: String) = hashString("SHA-256", password)

    fun sha1(password: String) = hashString("SHA-1", password)

    private fun hashString(type: String, password: String): String{
        val bytes = MessageDigest.getInstance(type).digest(password.toByteArray())
        val result = StringBuilder(bytes.size * 2)

        bytes.forEach {
            val i = it.toInt()
            result.append(Constants.ENCRYPTION.HEX_CHARS[i shr 4 and 0x0f])
            result.append(Constants.ENCRYPTION.HEX_CHARS[i and 0x0f])
        }

        return result.toString()
    }
}