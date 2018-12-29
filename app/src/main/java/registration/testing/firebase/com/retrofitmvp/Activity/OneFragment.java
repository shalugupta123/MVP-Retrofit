package registration.testing.firebase.com.retrofitmvp.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import registration.testing.firebase.com.retrofitmvp.R;

public class OneFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sectionNumber = getArguments() != null ? getArguments().getInt(ARG_SECTION_NUMBER) : 1;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        TextView textView = view.findViewById(R.id.txtTabItemNumber);
        textView.setText("TAB " + sectionNumber);


        return  view;
    }

    public static OneFragment newInstance(int sectionNumber) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}