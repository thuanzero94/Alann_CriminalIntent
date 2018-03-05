package com.foxconn.alan.alann_criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by alan on 03/03/2018.
 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private crimeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        UpdateUI();
        return view;
    }

    private void UpdateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimeList();

        mAdapter = new crimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    private class crimeHolder extends RecyclerView.ViewHolder{

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        private Crime mCrime;

        public crimeHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
        }

        public void bindCrime(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(DateFormat.getDateInstance(DateFormat.FULL).format(mCrime.getDate()));
            mSolvedCheckBox.setChecked(mCrime.isSolved());
        }
    }

    private class crimeAdapter extends RecyclerView.Adapter<crimeHolder>{
        private List<Crime> mCrimeList;

        public crimeAdapter(List<Crime> crimes){
            mCrimeList = crimes;
        }

        @Override
        public crimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false);

            return new crimeHolder(view);
        }

        @Override
        public void onBindViewHolder(crimeHolder holder, int position) {
            Crime crime = mCrimeList.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimeList.size();
        }
    }
}
