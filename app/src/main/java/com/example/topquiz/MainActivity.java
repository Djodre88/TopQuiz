package com.example.topquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Attributs de classe
    private TextView mGreetingTextView;
    private EditText mNameEditText;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = findViewById(R.id.main_edittext_name);
        mPlayButton = findViewById(R.id.main_button_play);

        // On désactive le bouton play tant que l'utilisateur n'a pas saisi son prénom
        mPlayButton.setEnabled(false);

        // Ajout d'un listener sous forme de classe anonyme
        // notifiant que l'utilisateur commence à saisir du texte
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Chaque fois que l'utilisateur saisira une lettre le bouton sera activé
                mPlayButton.setEnabled(!s.toString().isEmpty());

            }
        });
        // Pour détecter que l'utilisateur a cliqué sur le bouton
        // il est nécessaire d'implémenter un listener
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // L'intent est un objet qui sert à préciser quelle activité lancer
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);

                // La méthode startActivity sert à démarrer une activité
                startActivity(gameActivityIntent);
            }
        });
    }
}