package com.example.productapi.ui.payment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.productapi.R;
import com.example.productapi.databinding.FragmentPaymentBinding;

public class PaymentFragment extends Fragment {
    FragmentPaymentBinding binding;
    NavController navController;

    public PaymentFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPaymentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cardVisa.setOnClickListener(v -> {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.conferma.trippay.visacommercialpay&hl=ru&gl=US"));
            startActivity(myIntent);
        });
        binding.cardPaypal.setOnClickListener(v -> {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.paypal.android.p2pmobile&hl=ru&gl=US"));
            startActivity(myIntent);
        });
        binding.cardMbank.setOnClickListener(v -> {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=mbank&c=apps&hl=ru&gl=US"));
            startActivity(myIntent);
        });
        binding.cardOdengi.setOnClickListener(v -> {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kg.o.nurtelecom&hl=ru&gl=US"));
            startActivity(myIntent);
        });

        binding.btnBack.setOnClickListener(v -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_navigation_payment_to_navigation_home);
        });

    }
}

