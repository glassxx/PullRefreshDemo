package cn.glassxx.pullrefresh.principle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import cn.glassxx.pullrefresh.R;
import cn.glassxx.pullrefresh.basic.BaseActivity;

/**
 * show the principle of the Scroller
 * Created by glassx on 3/3/18.
 */

public class PrincipleActivity extends BaseActivity{
    private ScrollLayout scrollLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principle);

        Button btnScrollAdd = findViewById(R.id.scroll_add);
        Button btnScrollMinus = findViewById(R.id.scroll_minus);
        scrollLayout = findViewById(R.id.scroll_layout);


        btnScrollAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollLayout.scrollTo(-300);
            }
        });

        btnScrollMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollLayout.scrollTo(300);
            }
        });
    }
}
