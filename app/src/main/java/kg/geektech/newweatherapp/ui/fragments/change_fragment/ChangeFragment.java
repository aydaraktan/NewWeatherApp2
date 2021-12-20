package kg.geektech.newweatherapp.ui.fragments.change_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kg.geektech.newweatherapp.R;
import kg.geektech.newweatherapp.databinding.FragmentChangeBinding;


public class ChangeFragment extends Fragment {
    private FragmentChangeBinding binding;
    private NavController controller;
    private String lol;

    public String getLol() {
        return lol;
    }

    public void setLol(String lol) {
        this.lol = lol;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NavHostFragment hostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        controller = hostFragment.getNavController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentChangeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pol=binding.etCity.getText().toString();
                setLol(pol);
                controller.navigate(ChangeFragmentDirections.actionChangeFragmentToWeatherFragment(pol));

//                NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
//                controller = navHostFragment.getNavController();
            }
        });
    }
}