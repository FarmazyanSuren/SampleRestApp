package com.sf.presentation.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sf.samplerestapp.R

fun FragmentActivity.openFragment(fragment: Fragment, addToBackStack: Boolean = true) {
    val transaction =
        supportFragmentManager.beginTransaction().replace(R.id.singleContainer, fragment)
    if (addToBackStack) {
        transaction.addToBackStack(null)
    }
    transaction.commit()
}