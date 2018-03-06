package at.aau.mamanigrasso.palindromese2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int MIN_LENGTH = 5;

    private TextView tvInfo;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etInput = findViewById(R.id.editText);
        this.tvInfo = findViewById(R.id.tv_info);
        Button btnCheck = findViewById(R.id.button);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = etInput.getText().toString();
                if (isNullOrEmpty(str)) {
                    tvInfo.setText(getString(R.string.info_null_or_empty));
                    tvInfo.setTextColor(getColor(R.color.red));
                } else if (!isLongerThan(str, MIN_LENGTH)) {
                    tvInfo.setText(String.format(getString(R.string.info_not_long_enough), MIN_LENGTH));
                    tvInfo.setTextColor(getColor(R.color.red));
                } else if (isPalindrome(str)) {
                    tvInfo.setText(R.string.info_is_palindrome);
                    tvInfo.setTextColor(getColor(R.color.green));
                } else {
                    tvInfo.setText(R.string.info_is_not_palindrome);
                    tvInfo.setTextColor(getColor(R.color.black));
                }
            }
        });
    }

    /**
     * Checks whether the passed string is longer than the passed length.
     * @param str String to check
     * @param length length as int
     * @return true if <code>str</code> is longer than <code>length</code>, false otherwise
     */
    public static boolean isLongerThan(String str, int length) {
        return str.length() >= length;
    }

    /**
     * Checks whether the passed string is a palindrome.
     * @param str String to check
     * @return true if <code>str</code> is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    /**
     * Checks whether the passed string is null or empty.
     * @param str String to check
     * @return true if <code>str</code> is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
