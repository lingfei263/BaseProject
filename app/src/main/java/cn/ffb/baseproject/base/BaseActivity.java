package cn.ffb.baseproject.base;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.ffb.base.FBaseActivity;

/**
 * Created by zyl on 2018/10/9.
 */

public abstract class BaseActivity extends FBaseActivity {
    protected Unbinder mUnbinder;
    private boolean isButterKnifeBind = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isButterKnifeBind) {
            mUnbinder = ButterKnife.bind(this);
        }

    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    public void setButterKnifeBind(boolean isButterKnifeBind) {
        this.isButterKnifeBind = isButterKnifeBind;
    }

    public boolean isButterKnifeBind() {
        return isButterKnifeBind;
    }
}
