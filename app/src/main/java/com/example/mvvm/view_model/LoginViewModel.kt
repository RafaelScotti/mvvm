package com.example.mvvm.view_model


import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils
import android.util.Patterns


import com.example.mvvm.model.User

class LoginViewModel : BaseObservable() {
    private val user: User


    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @Bindable
    var toastMessage: String? = null
        private set(toastMessage) {

            field = toastMessage
            notifyPropertyChanged(1)
        }

    var userEmail: String?
        @Bindable
        get() = user.email
        set(email) {
            user.email = email
            notifyPropertyChanged(2)
        }

    var userPassword: String?
        @Bindable
        get() = user.password
        set(password) {
            user.password = password
            notifyPropertyChanged(3)
        }

    val isInputDataValid: Boolean
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() && userPassword!!.length > 5

    init {
        user = User("", "")
    }

    fun onLoginClicked() {
        if (isInputDataValid)
            toastMessage = successMessage
        else
            toastMessage = errorMessage
    }
}