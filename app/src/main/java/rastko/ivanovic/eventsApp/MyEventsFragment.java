package rastko.ivanovic.eventsApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MyEventsFragment extends Fragment {

    public MyEventsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_events, container, false);

        Button btnInterested = view.findViewById(R.id.btn_interested);
        Button btnAttending = view.findViewById(R.id.btn_attending);
        Button btnMyProfile = view.findViewById(R.id.btn_my_profile);

        btnInterested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InterestedEventsActivity.class);
                startActivity(intent);
            }
        });

        btnAttending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttendingEventsActivity.class);
                startActivity(intent);
            }
        });

        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", getActivity().getIntent().getExtras().getString("username", ""));
                bundle.putString("email", getActivity().getIntent().getExtras().getString("email", ""));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }
}