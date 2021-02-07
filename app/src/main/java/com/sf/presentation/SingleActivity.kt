package com.sf.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sf.presentation.ext.openFragment
import com.sf.presentation.fragment.NewsFragment
import com.sf.samplerestapp.R

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        if (savedInstanceState == null) {
            openFragment(NewsFragment.newInstance())
        }
    }
}