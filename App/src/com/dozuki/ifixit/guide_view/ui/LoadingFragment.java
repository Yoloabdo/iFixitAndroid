package com.dozuki.ifixit.guide_view.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.WazaBe.HoloEverywhere.LayoutInflater;
import com.WazaBe.HoloEverywhere.sherlock.SFragment;
import com.dozuki.ifixit.R;

public class LoadingFragment extends SFragment {
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
      return inflater.inflate(R.layout.loading_fragment, container, false);
   }
}
