package com.grozziie.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class MessageLibrary {
    public static  void  mymessage(Context context,String message) {
        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
    }
}
