package e.onrush.ebank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    final String correctUsername="hello";
    final String correctPassword="1234";
    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllViews();
        setuploginButtonListener();


    }

    private void findAllViews()
    {
        usernameInput=(EditText) findViewById(R.id.userNameInput);
        passwordInput=(EditText) findViewById(R.id.passwordInput);
        loginButton=(Button) findViewById(R.id.loginButton);
    }

    private void setuploginButtonListener()
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (username.equals(correctUsername) && password.equals(correctPassword))
                {
                    Toast logInSuccessToast= Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG);
                    logInSuccessToast.show();
                    Log.d("BUTTON", "Correct password");
                    Log.d("BUTTON", "username: " + username);
                    Log.d("BUTTON", "password: " + password);
                } else
                    {
                        Toast logInSuccessToast= Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG);
                        logInSuccessToast.show();
                    Log.d("BUTTON", "INCORRECT PASSWORD");
                }
            }
        });

    }
}
