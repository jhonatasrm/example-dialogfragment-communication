package com.jhonatasrm.example_dialogfragment_communication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class ExitDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private ExitListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(!(context instanceof ExitListener)) {
            throw new RuntimeException("You must implement the interface ExitDialog.ExitListener");
        }
        listener = (ExitListener) context;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder( getActivity())
                .setTitle(R.string.question)
                .setPositiveButton(R.string.yes, this)
                .setNegativeButton(R.string.no, this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if(which == dialogInterface.BUTTON_POSITIVE && listener != null){
            listener.onExit();
        }
    }

    public interface ExitListener {
        void onExit();
    }
}
