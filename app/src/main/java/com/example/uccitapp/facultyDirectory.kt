package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class facultyDirectory : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList:ArrayList<Faculty>
    lateinit var profilePicture:Array<Int>
    lateinit var name:Array<String>
    lateinit var phoneNumber:Array<String>
    lateinit var emailAddress:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_directory)

        //Arrays that stores the information that will be used in the recycler view
        profilePicture= arrayOf(
            R.drawable.portrait___rose,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.woman,
            R.drawable.profile,
            R.drawable.woman,
            R.drawable.woman,
            R.drawable.woman,
            R.drawable.profile,
            R.drawable.profile



        )

        name= arrayOf(
            "Natalie Rose (HOD)",
            "Henry Osbourne",
            "Otis Osbourne",
            "Janet Brown",
            "George Black",
            "Jackie Fly",
            "Nami Grey",
            "Hinata Hyuga",
            "Shikamaru Nara",
            "Sasuke Uchiha"



        )

        phoneNumber = arrayOf(
            "876 000 0000",
            "876 000 0001",
            "876 000 0002",
            "876 000 0003",
            "876 000 0004",
            "876 000 0005",
            "876 000 0006",
            "876 000 0007",
            "876 000 0008",
            "876 000 0009"
        )

        emailAddress= arrayOf(
            "person1HOD@ucc.edu.jm",
            "person2@ucc.edu.jm",
            "person3@ucc.edu.jm",
            "person4@ucc.edu.jm",
            "person5@ucc.edu.jm",
            "person6@ucc.edu.jm",
            "person7@ucc.edu.jm",
            "person8@ucc.edu.jm",
            "person9@ucc.edu.jm",
            "person10@ucc.edu.jm"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Faculty>()
        getUserData()
    }
    private fun getUserData(){
       //Storing data from the respective arrays created above into an array list that will be used to display
        // data in the recycler view
        for (i in profilePicture.indices){
            val facultyList = Faculty(profilePicture[i],name[i],phoneNumber[i],emailAddress[i])
            newArrayList.add(facultyList)
        }

        var adapter=Adapter(newArrayList)
        newRecyclerView.adapter=adapter


        //When a phone number from the recylcer view is clicked it will be displayed in the users
        //phone application
        //When an email address from the recylcer view is clicked it will be displayed in the users
        //email application
        adapter.setOnItemClickListener (
            object:Adapter.PhoneNumberListener{
                override fun phoneNumberClick(position: Int) {

                    val intent = Intent(Intent.ACTION_DIAL).also {
                        it.setData(Uri.parse("tel:${phoneNumber[position]}"))
                        startActivity(it)
                    }
                }


            },

            object:Adapter.EmailAddressListener{
                override fun emailAddressClick(position: Int) {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("${emailAddress[position]}"))
                    intent.type = "message/rfc822"
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"))

                }
            }
        )


    }
}