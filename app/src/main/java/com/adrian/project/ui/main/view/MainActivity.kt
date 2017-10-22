package com.adrian.project.ui.main.view

import android.widget.Button
import com.adrian.project.R
import com.adrian.project.ui.main.MapPageActivity
import com.adrian.project.ui.main.model.MainModel
import javax.inject.Inject

class MainActivity : android.support.v7.app.AppCompatActivity(), MainRouter {

    @Inject
    lateinit var mainModel: MainModel

    lateinit var btnPostsPage: android.widget.Button

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        dagger.android.AndroidInjection.inject(this)
        setContentView(com.adrian.project.R.layout.activity_main)

        mainModel.callApiService()

        btnPostsPage = findViewById<Button>(R.id.btnPostsPage) as Button
        btnPostsPage.setOnClickListener { openPostsPage() }
    }

    fun openPostsPage() {
        val intent = android.content.Intent(this, MapPageActivity::class.java)
        startActivity(intent)
    }
}
