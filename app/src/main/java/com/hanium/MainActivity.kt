package com.hanium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hanium.login.joinFragment
import com.hanium.login.loginFragment
import com.hanium.login.menuFragment

class MainActivity : AppCompatActivity() {
    // 머티리얼 아이콘
    var loginFragment = com.hanium.login.loginFragment()
    var joinFragment = com.hanium.login.joinFragment()
    var menuFragment = com.hanium.login.menuFragment()
    var idPassFragment = com.hanium.login.idPassFragment()
    var current = LOGIN

    companion object{
        val LOGIN = 0
        val JOIN = 1
        val IDPASS = 2
        val MENU = 3
    }

    override fun onBackPressed() {
        if(current == LOGIN){
            finish()
        }else if(current == JOIN){
            setFragment(LOGIN)
        }
        else if(current == IDPASS){
            setFragment(LOGIN)
        }
        else if(current == MENU){
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        setFragment(LOGIN)
    }

    fun setFragment(idx:Int){
        current = idx
        val transaction = supportFragmentManager.beginTransaction()
        if(idx==LOGIN){
            transaction.replace(R.id.main,loginFragment)
        }
        else if(idx==JOIN){
            transaction.replace(R.id.main,joinFragment)
        }
        else if(idx==IDPASS){
            transaction.replace(R.id.main,idPassFragment)
        }
        else if(idx==MENU){
            transaction.replace(R.id.main,menuFragment)
        }
        transaction.commit()
    }


    fun setFragment2(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.main,fragment)

        transaction.commit()
    }
}