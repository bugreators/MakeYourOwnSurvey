package com.bugcreators.makeyourownsurvey.Controller.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bugcreators.makeyourownsurvey.Controller.Adapters.TabsAdapter;
import com.bugcreators.makeyourownsurvey.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class SurveysFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabsAdapter tabsAdapter;

    public SurveysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_surveys, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = getView().findViewById(R.id.tabs);
        viewPager = getView().findViewById(R.id.view_pager_tabs);
        tabsAdapter = new TabsAdapter(getChildFragmentManager());

        tabsAdapter.AddFragment(new ChooseExistingSurveyFragment(), "Choose Existing");
        tabsAdapter.AddFragment(new CreateNewSurveyFragment(), "Create New");

        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.hand_pointer_regular);
        tabLayout.getTabAt(1).setIcon(R.drawable.plus_solid);

    }
}
