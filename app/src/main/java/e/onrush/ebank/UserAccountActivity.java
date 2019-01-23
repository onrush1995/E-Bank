package e.onrush.ebank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAccountActivity extends AppCompatActivity {

    Button logoutButton;
    Button depositButton;
    Button withdrawButton;
    TextView accountBalance;
    TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        findAllViews();
        unpackIntent();
        setupLogoutButton();
        setupDepositButtonListener();
        setWithdrawButtonListener();
    }

    private void findAllViews() {

        logoutButton = (Button) findViewById(R.id.logoutButton);
        depositButton = (Button) findViewById(R.id.depositButton);
        withdrawButton = (Button) findViewById(R.id.withdrawButton);
        accountBalance = (TextView) findViewById(R.id.accountBalance);
        welcomeMessage=(TextView) findViewById(R.id.userAccountWelcome);
    }

    private void unpackIntent()
    {
       welcomeMessage.setText("Welcome " + getIntent().getStringExtra("username"));
    }

    private void setupLogoutButton() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setupDepositButtonListener() {
        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String balance = accountBalance.getText().toString();

                int nullbalance = Integer.valueOf(balance);

                nullbalance += 10;

                final String updatedBalance = String.valueOf(nullbalance);

                accountBalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountBalance.setText(updatedBalance);
                    }
                });
            }
        });
    }

    private void setWithdrawButtonListener() {
        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String balance = accountBalance.getText().toString();

                int nullbalance = Integer.valueOf(balance);

                nullbalance -= 10;

                final String updatedBalance = String.valueOf(nullbalance);

                accountBalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountBalance.setText(updatedBalance);
                    }
                });
            }
        });
    }
}
