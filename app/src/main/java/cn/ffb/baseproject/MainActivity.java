package cn.ffb.baseproject;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import cn.ffb.base.BaseActivity;
import cn.ffb.base.MessageEvent;


public class MainActivity extends BaseActivity {
    @BindView(R2.id.button1)
    Button mButton1;
    @BindView(R2.id.button2)
    Button mButton2;
    @BindView(R2.id.button3)
    Button mButton3;
    @BindView(R2.id.button4)
    Button mButton4;

    @Override
    protected void onConfig(Config config) {
        super.onConfig(config);
        config.setSwipeBackWrapper(false);
        config.setEventBusEnable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R2.id.button1, R2.id.button2, R2.id.button3, R2.id.button4})
    public void onButtonClick(Button button) {
        switch (button.getId()) {
            case R.id.button1:
                showToast("click button1");
                break;
            case R.id.button2:
                showToast("click button2");
                break;
            case R.id.button3:
                showToast("click button3");
                break;
            case R.id.button4:
                showToast("click button4");
                break;
        }
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        this.setTitle("首页");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void handleMainThreadMessage(MessageEvent event) {
        super.handleMainThreadMessage(event);
        this.showToast("上一个界面" + event.obj.toString());
    }
}
