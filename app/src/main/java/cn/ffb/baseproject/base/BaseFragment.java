package cn.ffb.baseproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.ffb.base.FBaseFragment;

/**
 * Created by zyl on 2018/10/9.
 */

public abstract class BaseFragment extends FBaseFragment {
    private Unbinder mUnbinder;
    private boolean isButterKnifeBind = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (isButterKnifeBind) {
            mUnbinder = ButterKnife.bind(this, view);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        if (mUnbinder != null) {
            this.mUnbinder.unbind();
        }
        super.onDestroyView();
    }
}
