package wdm.java3p6wdm;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.SharedPreferences.Editor;

public class MainActivity extends AppCompatActivity
implements OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button newGameButton;
    private TextView messageTextView;
    private String turn = "";
    private boolean gameOver = false;
    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main_land);
        }

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        turn = "X";
        gameOver = false;
        messageTextView.setText("Player " + turn + "'s turn");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        newGameButton.setOnClickListener(this);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.button1:
                clicked(button1);
                break;
            case R.id.button2:
                clicked(button2);
                break;
            case R.id.button3:
                clicked(button3);
                break;
            case R.id.button4:
                clicked(button4);
                break;
            case R.id.button5:
                clicked(button5);
                break;
            case R.id.button6:
                clicked(button6);
                break;
            case R.id.button7:
                clicked(button7);
                break;
            case R.id.button8:
                clicked(button8);
                break;
            case R.id.button9:
                clicked(button9);
                break;
            case R.id.newGameButton:
                newGame();
                break;
        }
    }

    private void clicked(Button button)
    {
        if (gameOver)
        {
            return;
        }
        if (!button.getText().toString().equals(""))
        {
            return;
        }
        button.setText(turn);
        checkWin();
        turns(turn);


    }

    private void turns(String turn)
    {
        if (gameOver)
            return;
        if (turn.equals("X"))
        {
            this.turn = "O";
        }
        else if (turn.equals("O"))
        {
            this.turn = "X";
        }
        messageTextView.setText("Player " + this.turn + "'s turn");
    }

    private void checkWin()
    {
        if (!button1.getText().toString().equals("") && !button2.getText().toString().equals("") && !button3.getText().toString().equals("")) {
            if (button1.getText().toString().equals(button2.getText().toString()) && button1.getText().toString().equals(button3.getText().toString())) {
                messageTextView.setText("Player " + button1.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button4.getText().toString().equals("") && !button5.getText().toString().equals("") && !button6.getText().toString().equals("")) {
            if (button4.getText().toString().equals(button5.getText().toString()) && button4.getText().toString().equals(button6.getText().toString())) {
                messageTextView.setText("Player " + button4.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button7.getText().toString().equals("") && !button8.getText().toString().equals("") && !button9.getText().toString().equals("")) {
            if (button7.getText().toString().equals(button8.getText().toString()) && button7.getText().toString().equals(button9.getText().toString())) {
                messageTextView.setText("Player " + button7.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button1.getText().toString().equals("") && !button4.getText().toString().equals("") && !button7.getText().toString().equals("")) {
            if (button1.getText().toString().equals(button4.getText().toString()) && button1.getText().toString().equals(button7.getText().toString())) {
                messageTextView.setText("Player " + button1.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button2.getText().toString().equals("") && !button5.getText().toString().equals("") && !button8.getText().toString().equals("")) {
            if (button2.getText().toString().equals(button5.getText().toString()) && button2.getText().toString().equals(button8.getText().toString())) {
                messageTextView.setText("Player " + button2.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button3.getText().toString().equals("") && !button6.getText().toString().equals("") && !button9.getText().toString().equals("")) {
            if (button3.getText().toString().equals(button6.getText().toString()) && button3.getText().toString().equals(button9.getText().toString())) {
                messageTextView.setText("Player " + button3.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button1.getText().toString().equals("") && !button5.getText().toString().equals("") && !button9.getText().toString().equals("")) {
            if (button1.getText().toString().equals(button5.getText().toString()) && button1.getText().toString().equals(button9.getText().toString())) {
                messageTextView.setText("Player " + button1.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button3.getText().toString().equals("") && !button5.getText().toString().equals("") && !button7.getText().toString().equals("")) {
            if (button3.getText().toString().equals(button5.getText().toString()) && button3.getText().toString().equals(button7.getText().toString())) {
                messageTextView.setText("Player " + button3.getText().toString() + " wins");
                gameOver = true;
                return;
            }
        }
        if (!button1.getText().toString().equals("") && !button2.getText().toString().equals("") && !button3.getText().toString().equals("") && !button4.getText().toString().equals("") &&
                !button5.getText().toString().equals("") && !button6.getText().toString().equals("") && !button7.getText().toString().equals("") && !button8.getText().toString().equals("") &&
                !button9.getText().toString().equals(""))
        {
            messageTextView.setText("Draw");
            gameOver = true;
            return;
        }
    }

    private void newGame()
    {
        gameOver = false;
        turn = "X";
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        messageTextView.setText("Player " + turn + "'s turn");
    }

    @Override
    public void onPause()
    {
        Editor editor = savedValues.edit();
        editor.putString("button1", button1.getText().toString());
        editor.putString("button2", button2.getText().toString());
        editor.putString("button3", button3.getText().toString());
        editor.putString("button4", button4.getText().toString());
        editor.putString("button5", button5.getText().toString());
        editor.putString("button6", button6.getText().toString());
        editor.putString("button7", button7.getText().toString());
        editor.putString("button8", button8.getText().toString());
        editor.putString("button9", button9.getText().toString());
        editor.putString("turn", turn);
        editor.putBoolean("gameOver", gameOver);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        button1.setText(savedValues.getString("button1", ""));
        button2.setText(savedValues.getString("button2", ""));
        button3.setText(savedValues.getString("button3", ""));
        button4.setText(savedValues.getString("button4", ""));
        button5.setText(savedValues.getString("button5", ""));
        button6.setText(savedValues.getString("button6", ""));
        button7.setText(savedValues.getString("button7", ""));
        button8.setText(savedValues.getString("button8", ""));
        button9.setText(savedValues.getString("button9", ""));
        turn = savedValues.getString("turn", "X");
        gameOver = savedValues.getBoolean("gameOver", false);
        checkWin();
        if (!gameOver)
        {
            messageTextView.setText("Player " + turn + "'s turn");
        }
    }
}
