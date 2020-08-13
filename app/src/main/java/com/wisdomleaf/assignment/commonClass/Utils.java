package com.wisdomleaf.assignment.commonClass;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;

public class Utils {
    private static ProgressDialog mProgressDialog = null;

    @SuppressLint("NewApi")
    public static void displayProgressDialog(final Activity activity, final String message, final Boolean backButtonCancelable) {

        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mProgressDialog == null && activity != null) {
                        mProgressDialog = new ProgressDialog(activity);
                        mProgressDialog.setMessage(message);
                        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        mProgressDialog.setIndeterminate(true);
                        mProgressDialog.show();
                        mProgressDialog.setCanceledOnTouchOutside(false);
                        mProgressDialog.setCancelable(backButtonCancelable);
                    }
                }
            });
        }

    }

    public static void cancelProgressDialog(Activity activity) {

        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mProgressDialog != null && mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                        mProgressDialog.cancel();
                        mProgressDialog = null;
                    }
                }
            });
        }
    }
}
