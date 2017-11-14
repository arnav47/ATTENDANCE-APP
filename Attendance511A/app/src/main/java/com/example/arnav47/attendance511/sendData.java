package com.example.arnav47.attendance511;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

/**
 * Created by AKASH on 07/11/2017.
 */

public class sendData implements AsyncResponse {

     private String usn, subject, teacher;
     private Context context;
    public sendData(Context content, String usn) {
        this.context = context;
        this.usn = usn;
    }

    public sendData(Context context, String usn, String subject, String teacher) {
        this.context = context;
        this.usn = usn;
        this.subject = subject;
        this.teacher = teacher;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    HashMap postData = new HashMap();

    void pushData()
    {

        postData.put("subject", subject);
        postData.put("usn", usn);
        postData.put("teacher", teacher);

        //You pass postData as the 2nd argument of the constructor
        PostResponseAsyncTask nfcInput =
                new PostResponseAsyncTask(context, postData, sendData.this);

        nfcInput.execute("https://attendance611.000webhostapp.com/nfc.php");
    }

    @Override
    public void processFinish(String output) {
        Log.d("attendance log",output);
        if (output.equals("success")) {
            Toast.makeText(context, "Updated successfully!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "failure"+output, Toast.LENGTH_LONG).show();
        }

    }
}
