package com.production.masm.EntryWindows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.production.masm.Helpers.Validator;
import com.production.masm.Models.User;
import com.production.masm.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editPasswordRepeat;
    private Button buttonRegister;

    private User mainUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UIInitialization();
        mainUser = new User();
        buttonRegister.setOnClickListener(v -> register());
    }

    private void UIInitialization() {
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        editPasswordRepeat = findViewById(R.id.edit_password_repeat);
        buttonRegister = findViewById(R.id.button_register);
    }

    private void register() {
        if (!editName.getText().toString().equals("") && !editEmail.getText().toString().equals("") &&
                !editPassword.getText().toString().equals("") && !editPasswordRepeat.getText().toString().equals("")) {
            if ((!(Validator.isFieldNotValidPassword(editPassword.getText().toString().trim()))) && (!(Validator.isFieldNotValidPassword(editPasswordRepeat.getText().toString().trim()))))
                Toast.makeText(this, "Incorrect password", Toast.LENGTH_LONG).show();
            else if (!(editPassword.getText().toString().equals(editPasswordRepeat.getText().toString())))
                Toast.makeText(this, "Password mismatch", Toast.LENGTH_LONG).show();
            else if (((editPassword.length() < 7) && (editPasswordRepeat.length() < 7)))
                Toast.makeText(this, "Password must be more than 7 characters", Toast.LENGTH_LONG).show();
            else {
                mainUser.setName(editName.getText().toString().trim());
                mainUser.setEmail(editEmail.getText().toString().trim());
                mainUser.setPassword(editPassword.getText().toString().trim());
                Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show();
            }
        }
    }
}