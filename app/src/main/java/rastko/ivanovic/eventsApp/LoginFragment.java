package rastko.ivanovic.eventsApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {


    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText etUsername = view.findViewById(R.id.et_login_username);
        EditText etPassword = view.findViewById(R.id.et_login_password);
        Button btnLoginSubmit = view.findViewById(R.id.btn_login_submit);

        btnLoginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Dozvoljavamo login samo za admin/admin
                if (username.equals("admin") && password.equals("admin")) {
                    Intent intent = new Intent(getActivity(), EventsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("email", "admin@gmail.com");
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Pogresni podaci", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}