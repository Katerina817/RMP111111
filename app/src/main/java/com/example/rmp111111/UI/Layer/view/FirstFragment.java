package com.example.rmp111111.UI.Layer.view;

import android.app.Application;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.transition.Visibility;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rmp111111.R;
import com.example.rmp111111.UI.Layer.viewmodel.WorkerViewModel;

public class FirstFragment extends Fragment {
    public FirstFragment(){
        super(R.layout.firstfragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TransitionInflater inflater = TransitionInflater.from(requireContext());
        //setExitTransition(inflater.inflateTransition(R.transition.fade));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn1=view.findViewById(R.id.startbutton);
        ImageView imageView=view.findViewById(R.id.imageView);
        AnimatedVectorDrawable drawable= (AnimatedVectorDrawable) imageView.getDrawable();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawable.start();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,
                                R.anim.slide_out
                        ).replace(R.id.fragment_container, new SecondFragment())
                        .addToBackStack(null)
                        .commit();
                WorkerViewModel vm=new WorkerViewModel(new Application());
                vm.apply();getView().setVisibility(View.GONE);

                //Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });
    }
}
