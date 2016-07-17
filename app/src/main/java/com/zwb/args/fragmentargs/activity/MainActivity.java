package com.zwb.args.fragmentargs.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.zwb.args.fragmentargs.R;
import com.zwb.args.fragmentargs.fragment.FragmentA;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA a = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putString("text", "你好");
        a.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, a);
        transaction.commit();
    }
}
