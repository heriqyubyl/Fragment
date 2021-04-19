package com.example.blue_fire

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    // Initialise the DrawerLayout, NavigationView and ToggleBar
    private lateinit var drawerLayout       : DrawerLayout
    private lateinit var actionBarToggle    : ActionBarDrawerToggle
    private lateinit var navDrawerView      : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.activity_main)

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Call syncState() on the action bar so it'll automatically
        // change to the back button when the drawer layout is open
        actionBarToggle.syncState()


        // Call findViewById on the NavigationView
        navDrawerView = findViewById(R.id.navDrawer)

        // Call setNavigationItemSelectedListener on the NavigationView
        // to detect when items are clicked
        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(
                        this, "Go to My Profile", Toast.LENGTH_SHORT
                    ).show()
                    true
                }
                R.id.myEmployee -> {
                    Toast.makeText(this, "Go to Our Employee", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.register -> {
                    val intent = Intent(applicationContext, Register::class.java)
                    startActivity(intent)
                    true
                }
                else -> {
                    false
                }
            }
        }



    }

    // override the onSupportNavigateUp() function to open and close
    // the Drawer
    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)   // close drawer
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)   // open drawer
        }
        return true
    }


    //Call inflate toolbar Menu to Main Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
    //Clicked item toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.favourite){
            Toast.makeText(
                this,
                "Thank you make me your Favourite",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        else if(id == R.id.search){
            Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
            return true
        }
        else if(id == R.id.setting) {
            Toast.makeText(this, "Go to Setting", Toast.LENGTH_SHORT).show()
            return true
        }
        else if(id == R.id.logout) {
            Toast.makeText(this, "Logout and go to login form", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }






}
