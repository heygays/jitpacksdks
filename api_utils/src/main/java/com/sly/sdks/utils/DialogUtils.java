package com.sly.sdks.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

public class DialogUtils {
    private Activity context;
    private AlertDialog alertDialog;

    public DialogUtils(Activity context) {
        this.context = context;
        alertDialog = new AlertDialog.Builder(context, R.style.CustomAlertDialog).create();
    }

    public DialogUtils setTitle(String title) {
        alertDialog.setTitle(title);
        return this;
    }

    public DialogUtils setIcon(int resId) {
        alertDialog.setIcon(ContextCompat.getDrawable(context, resId));
        return this;
    }

    public DialogUtils setMsg(String msg) {
        alertDialog.setMessage(msg);
        return this;
    }

    public DialogUtils setLeftBtn(String leftTxt, DialogInterface.OnClickListener listener) {
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, leftTxt, listener);
        return this;
    }

    public DialogUtils setRightBtn(String rightTxt, DialogInterface.OnClickListener listener) {
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, rightTxt, listener);
        return this;
    }

    public DialogUtils setView(View view) {
        alertDialog.setView(view);
        return this;
    }

    public DialogUtils setCancelable(boolean flag) {
        alertDialog.setCancelable(flag);
        return this;
    }


    public void show() {
        alertDialog.show();
    }

    public void showResizeDialog(int w, int h) {
        show();
        WindowManager.LayoutParams params = alertDialog.getWindow().getAttributes();
        params.width = w;
        params.height = h;
        alertDialog.getWindow().setAttributes(params);
    }

    public void showExit() {
        setTitle("提示")
                .setMsg("确定退出吗?")
                .setLeftBtn("否", null)
                .setRightBtn("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        context.finish();
                    }
                })
                .show();
    }

    public void showNotice(String noticeMsg) {
        setTitle("提示")
                .setMsg(noticeMsg)
                .setRightBtn("我知道了", null)
                .show();
    }

    public void dismiss() {
        alertDialog.dismiss();
    }

    public boolean isShowing() {
        return alertDialog != null && alertDialog.isShowing();
    }
}
