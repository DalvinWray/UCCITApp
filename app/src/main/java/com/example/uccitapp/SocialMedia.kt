package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SocialMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        val instagram:ImageView=findViewById(R.id.instagram)
        val facebook:ImageView=findViewById(R.id.facebook)
        val twitter:ImageView=findViewById(R.id.twitter)
        val youtube:ImageView=findViewById(R.id.youtube)

        //Open various social media pages to view the university's respective social media pages

        instagram.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/uccjamaica/?hl=en")))
        }

        facebook.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/uccjamaica/?_rdc=1&_rdr")))
        }

        twitter.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/UCCjamaica")))
        }

        youtube.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCZRvkbzlwgpZVHMacb6MtLQ")))
        }


    }
}