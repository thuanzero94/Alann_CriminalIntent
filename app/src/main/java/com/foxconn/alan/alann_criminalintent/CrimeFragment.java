package com.foxconn.alan.alann_criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.DateFormat;

/**
 * Created by alan on 01/03/2018.
 */

public class CrimeFragment extends Fragment {
    private static final String TAG = CrimeFragment.class.getSimpleName();

    private Crime mCrime;
    private EditText mEditText_TitleField;
    private Button mBtnDate;
    private CheckBox mCheckBoxSolved;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mEditText_TitleField = (EditText)v.findViewById(R.id.EditText_crime_title);
        mEditText_TitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBtnDate = (Button)v.findViewById(R.id.crime_date);
        mBtnDate.setText(DateFormat.getDateInstance(DateFormat.FULL).format(mCrime.getDate()));
        mBtnDate.setEnabled(false);

        mCheckBoxSolved = (CheckBox)v.findViewById(R.id.crime_solved);
        mCheckBoxSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }


}
