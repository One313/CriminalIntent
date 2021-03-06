package com.example.criminalintent.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.activity.CrimeDetailActivity;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.repository.CrimeRepository;
import com.example.criminalintent.repository.RepositoryInterface;

import java.util.List;

public class CrimeListFragment extends Fragment {

    private CrimeAdapter mAdapter;

    public static CrimeListFragment newInstance() {

        Bundle args = new Bundle();

        CrimeListFragment fragment = new CrimeListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private RecyclerView mRecyclerView;
    private RepositoryInterface<Crime> mRepository;

    public CrimeListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = CrimeRepository.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        findViews(view);
        // positioning in recycler view
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        /*// in LinearLayout Horizontal
        mRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                RecyclerView.HORIZONTAL, false));*/

        /*// in GridLayout with 2 column
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));*/

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new CrimeAdapter(mRepository.getAll());
            mRecyclerView.setAdapter(mAdapter);
        } else
            mAdapter.notifyDataSetChanged();
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_crimes);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder {

        private Crime mCrime;

        private TextView mTextViewTitle;
        private TextView mTextViewDate;
        private ImageView mImageViewSolved;

        public CrimeHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.text_view_title_list_row);
            mTextViewDate = itemView.findViewById(R.id.text_view_date_list_row);
            mImageViewSolved = itemView.findViewById(R.id.image_view_solved_list_row);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Intent intent = new Intent(getActivity(), CrimeDetailActivity.class);
                    intent.putExtra("CrimeId", mCrime.getId());*/

                    Intent intent = CrimeDetailActivity.newIntent(getActivity(), mCrime.getId());
                    startActivity(intent);

                    /*if (mCrime != null)
                        Toast.makeText(getActivity(), "crime : " + mCrime.getTitle(),
                                Toast.LENGTH_LONG).show();*/
                }
            });
        }

        public void bindCrime(Crime crime) {
            mCrime = crime;
            mTextViewTitle.setText(crime.getTitle());
            mTextViewDate.setText(crime.getDate().toString());
            mImageViewSolved.setVisibility(crime.isSolved() ? View.VISIBLE : View.INVISIBLE);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> mCrimes;

        public List<Crime> getCrimes() {
            return mCrimes;
        }

        public void setCrimes(List<Crime> crimes) {
            mCrimes = crimes;
        }

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // in java code!
            /*LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView textViewTitle = new TextView(getActivity());
            textViewTitle.setText("Crime Title");

            layout.addView(textViewTitle);

            return new CrimeHolder(layout);*/

            // in xml code!
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_row_crime, parent, false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}