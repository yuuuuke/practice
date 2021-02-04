package com.example.floatbutton.last;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.floatbutton.R;

/**
 * 提示用的弹窗,替代dialog
 */
public class TipPopupWindow extends PopupWindow {
    private final String layoutId = "layout_tip_popupwindow";
    private final String titleId = "tv_title";
    private final String messageId = "tv_message";
    private final String btnOkId = "btn_ok";

    private View contentView;
    private TextView mTitle;
    private TextView mMessage;
    private TextView mBtnOk;

    private TipPopupWindow(Context context) {
        contentView = LayoutInflater
                .from(context)
                .inflate(R.layout.layout_tip_popupwindow, null);
        mTitle = contentView.findViewById(R.id.tv_title);
        mMessage = contentView.findViewById(R.id.tv_message);
        mBtnOk = contentView.findViewById(R.id.btn_ok);
        setContentView(contentView);
        setWidth(500);
        setHeight(500);
        setBackgroundDrawable(new ColorDrawable());
        setOutsideTouchable(false);
    }

    public static class PopupWindowBuilder {

        private TipPopupWindow popupWindow;

        public PopupWindowBuilder(Context context) {
            popupWindow = new TipPopupWindow(context);

        }

        public PopupWindowBuilder setTitle(String title) {
            popupWindow.mTitle.setText(title);
            return this;
        }

        public PopupWindowBuilder setMessage(String msg) {
            popupWindow.mMessage.setText(msg);
            return this;
        }

        public PopupWindowBuilder setOkListener(final Function clickOk) {
            popupWindow.mBtnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickOk.invoke();
                }
            });
            return this;
        }

        public TipPopupWindow build() {
            return popupWindow;
        }

    }
}