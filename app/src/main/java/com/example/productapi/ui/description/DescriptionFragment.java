package com.example.productapi.ui.description;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.productapi.R;
import com.example.productapi.databinding.FragmentDescriptionBinding;
import com.example.productapi.databinding.FragmentNotificationsBinding;
import com.example.productapi.models.ModelM;

import java.util.ArrayList;

public class DescriptionFragment extends Fragment {
        FragmentDescriptionBinding binding;

        ArrayList<ModelM> d_list = new ArrayList<>();
        DescAdapter adapter;
        NavController navController;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            adapter = new DescAdapter(requireActivity());

            if(getArguments()!= null){
                d_list = getArguments().getParcelableArrayList("see more");
            }else{
                Toast.makeText(requireActivity(),"the are nothing", Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {

            binding = FragmentDescriptionBinding.inflate(inflater,
                    container, false);
            View root = binding.getRoot();

//        if(getArguments()!= null){
//            d_list = getArguments().getParcelableArrayList("favorite");
//        }else{
//            Toast.makeText(requireActivity(),"the are nothing", Toast.LENGTH_LONG).show();
//        }
//        adapter = new DescAdapter(requireActivity(),d_list)
            return root;
        }





        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
            if(d_list!=null){
                adapter.setListD(d_list);
            }else {
                Toast.makeText(requireActivity(), "Вы не выбрали товар", Toast.LENGTH_SHORT).show();
            }
            binding.rvDescription.setAdapter(adapter);

            binding.btnBack.setOnClickListener(v2->{
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.action_navigation_description_to_navigation_home);
            });
        }



    }