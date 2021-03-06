package main.java.com.termux.filemanage.filemanager.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;


import com.termux.R;

import androidx.fragment.app.DialogFragment;
import main.java.com.termux.filemanage.filemanager.util.UIUtils;

public class OverwriteFileDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setInverseBackgroundForced(UIUtils.shouldDialogInverseBackground(getActivity()))
                .setTitle(R.string.file_exists)
                .setMessage(R.string.overwrite_question)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        ((Overwritable) getTargetFragment()).overwrite();
                    }
                }).setNegativeButton(android.R.string.cancel, null)
                .create();
    }

    public interface Overwritable {
        public void overwrite();
    }
}
