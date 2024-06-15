package com.example.flowershop.ui.feedbacks;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.service.controls.actions.FloatAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowershop.R;
import com.example.flowershop.databinding.FragmentFeedbacksBinding;
import com.example.flowershop.ui.addfeedback.AddFeedbackFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FeedbacksFragment extends Fragment {
    FragmentFeedbacksBinding binding;
    NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.floatingActionButton.setOnClickListener(v1 ->{
            navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host);
            navController.navigate(R.id.action_feedbacksFragment_to_addFeedbackFragment);
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedbacks, container, false);
    }
}