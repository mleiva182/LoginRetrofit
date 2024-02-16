package com.mleiva.loginretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.mleiva.loginretrofit.databinding.ActivityProfileBinding
import com.mleiva.loginretrofit.model.Support
import com.mleiva.loginretrofit.model.User
import com.mleiva.loginretrofit.retrofit.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit
 * Creted by: Marcelo Leiva on 15-02-2024 at 20:47
 ***/
class ProfileActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        loadUserProfile()
    }

    private fun loadUserProfile() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(UserService::class.java)
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val result = service.getSigleUser()
                updateUI(result.data, result.support)
            } catch (e: Exception) {
                showMessage(getString(R.string.main_error_server))
            }
        }
    }

    private suspend fun updateUI(user: User, support: Support) = withContext(Dispatchers.Main){
        with(mBinding) {
            tvFullName.text = user.getFullName()
            tvEmail.text = user.email

            Glide.with(this@ProfileActivity)
                .load(user.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(imgProfile)

            tvSupportMessage.text = support.text
            tvSupportUrl.text = support.url
        }
    }

    private fun showMessage(message: String){
        Snackbar.make(mBinding.root, message, Snackbar.LENGTH_SHORT).show()
    }

}