package com.kennie.views.statemanager.state1;

import android.content.Context;
import android.view.View;

public interface IViewHolder {

    int getLayoutId();

    View getView();

    View onCreateView(Context context);

    void onViewCreated(View view);

    void onDestroyView();

}
