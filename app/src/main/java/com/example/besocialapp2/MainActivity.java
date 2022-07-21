package com.example.besocialapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        ImageView left=findViewById(R.id.right_icon);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.nav_home:
                        Intent i1=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent i2=new Intent(MainActivity.this,Profile.class);
                        startActivity(i2);
                        finish();
                        break;
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();//logout
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        finish();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Hii", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }


}