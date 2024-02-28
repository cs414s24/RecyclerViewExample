package com.example.recyclerviewexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Store the the recyclerView widget in a variable
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // specify an viewAdapter for the dataset (we use dummy data containing 20 contacts)
        recyclerView.adapter = MyRecyclerAdapter(generateContact(20))

        // use a linear layout manager, you can use different layouts as well
        recyclerView.layoutManager = LinearLayoutManager(this)

        // if you want, you can make the layout of the recyclerview horizontal as follows
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        // Add a divider between rows -- Optional
        //val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        //recyclerView.addItemDecoration(dividerItemDecoration)

        // use this setting to improve performance if you know the size of the RecyclerView is fixed
        //recyclerView.setHasFixedSize(true)
    }

    // A helper function to create specified amount of dummy contact data
    private fun generateContact(size: Int) : ArrayList<Contact>{

        val contacts = ArrayList<Contact>()

        // The for loop will generate [size] amount of contact data and store in a list
        for (i in 1..size) {
            val person = Contact("John Doe-$i", i, R.drawable.baseline_account_circle_24)
            contacts.add(person)
        }
        // return the list of contacts
        return contacts
    }
}