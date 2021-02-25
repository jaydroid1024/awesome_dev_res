package id.tix.android.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Jay on 2019/1/24.
 */
public class KeyBoardUtils {

    /**
     * Dynamic display of soft keyboard.
     *
     * @param activity activity
     */
    public static void showKeyboard(Activity activity) {
        InputMethodManager imm =
            (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * Dynamic display of soft keyboard.
     *
     * @param view view
     */
    public static void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
            .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * Dynamic hide of soft keyboard.
     *
     * @param activity activity
     */
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm =
            (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Dynamic hide of soft keyboard.
     *
     * @param view View
     */
    public static void hideKeyboard(final View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
            .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        if (imm.isActive(view)) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Switch the soft keyboard display status.
     */
    public static void toggleKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager)
            activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    /**
     * check the input method whether displayed.
     */
    public static boolean isKeyboardActive(Activity activity) {
        boolean bool = false;
        InputMethodManager inputMethodManager = (InputMethodManager)
            activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            bool = true;
        }
        return bool;
    }
}
