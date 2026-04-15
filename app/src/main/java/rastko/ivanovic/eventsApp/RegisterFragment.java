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


public class RegisterFragment extends Fragment {


    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText etUsername = view.findViewById(R.id.et_register_username);
        EditText etEmail = view.findViewById(R.id.et_register_email);
        EditText etPassword = view.findViewById(R.id.et_register_password);
        Button btnRegisterSubmit = view.findViewById(R.id.btn_register_submit);

        btnRegisterSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "Sva polja su obavezna", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), EventsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("email", email);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}