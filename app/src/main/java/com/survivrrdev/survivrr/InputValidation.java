package com.survivrrdev.survivrr;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class InputValidation {
    private Context context;

    public InputValidation(Context context){
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText editText, String message){
        String value = editText.getText().toString().trim();
        if (value.isEmpty()){
            editText.setError(message);
            //hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            editText.setError(null);
        }

        return true;
    }

    public boolean isInputEditTextEmail(EditText editText, String message){
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            editText.setError(message);
            //hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            editText.setError(null);
        }

        return true;
    }

    public boolean isInputEditTextMatches(EditText editText, EditText editText2, String message){
        String value1 = editText.getText().toString().trim();
        String value2 = editText2.getText().toString().trim();

        if (!value1.contentEquals(value2)){
            editText.setError(message);
            //hideKeyboardFrom(textInputEditText2);
            return false;
        } else {
            editText.setError(null);
        }

        return true;
    }

    public void hideKeyboardFrom(View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
