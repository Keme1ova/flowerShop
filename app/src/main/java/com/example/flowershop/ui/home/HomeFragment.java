package com.example.flowershop.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.airbnb.lottie.LottieAnimationView;
import com.example.flowershop.R;
import com.example.flowershop.databinding.FragmentHomeBinding;
import com.example.flowershop.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    List<CategoryModel> list_category = new ArrayList<>();
    CategoryAdapter adapter;
    LottieAnimationView lotty_flowers;
    NavController navController;
    String userName;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//----------------------------------------------------
//        // Получение имени пользователя из Intent
//        Intent intent = getIntent();
//        userName = intent.getStringExtra("userName");
//
//        // Установка приветственного текста
//        if (userName != null && !userName.isEmpty()) {
//            binding.userName.setText( userName);
//        } else {
//            binding.userName.setText("");
//        }
//----------------------------------------------------


        lotty_flowers = binding.lottyFlowers;
        lotty_flowers.setAnimation(R.raw.flowers2);
        createList();
        adapter = new CategoryAdapter();
        adapter.setMain_list(list_category);
        binding.rvCatalogCategory.setAdapter(adapter);
        return root;
    }
    private void createList() {
        list_category.add(new CategoryModel("Houseplants", R.drawable.hauseplants));
        list_category.add(new CategoryModel("Bouquets", R.drawable.bouqet));
        list_category.add(new CategoryModel("Wedding", R.drawable.wedding));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnLogin.setOnClickListener(v->{
            navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host);
            navController.navigate(R.id.action_navigation_home_to_loginFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}