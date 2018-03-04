package cn.glassxx.pullrefresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.glassxx.pullrefresh.basic.BaseActivity;
import cn.glassxx.pullrefresh.principle.PrincipleActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button btnPrinciple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrinciple = findViewById(R.id.principle_btn);
        btnPrinciple.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.principle_btn:
                studyPrinciple();
                break;

                default:
                    break;
        }
    }

    private void studyPrinciple(){
        Intent intent = new Intent(MainActivity.this, PrincipleActivity.class);
        startActivity(intent);
    }
}
