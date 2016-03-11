package com.example.asus.se7enapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout relLay_item1,
            relLay_item2,
            relLay_item3;

    private TextView tv_headTextView1,
            tv_headTextView2,
            tv_headTextView3;

    private ImageView img_und_menu_im1,
            img_und_menu_im2,
            img_und_menu_im3;

    private TextView  tv_TextView1,
            tv_TextView2,
            tv_TextView3;

    private String tittle, text;
    public static int ItemEnable;

    private int order_checked_item = Constant.UNCHECKED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAllElements();
        setListenersSmallMenu();
        disable_AllItems();
        check_EnableItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    // switch radio button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                disable_AllItems();
                enableItem1();
                ItemEnable = 1;
                break;
            case R.id.item_2:
                disable_AllItems();
                enableItem2();
                ItemEnable = 2;
                break;
            case R.id.item_3:
                disable_AllItems();
                enableItem3();
                ItemEnable = 3;
                break;
        }
        invalidateOptionsMenu();
        return super.onOptionsItemSelected(item);
    }


    // switch radio button
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item_1 = menu.findItem(R.id.item_1);
        MenuItem item_2 = menu.findItem(R.id.item_2);
        MenuItem item_3 = menu.findItem(R.id.item_3);
        switch (ItemEnable){
            case 1:
                item_1.setIcon(R.drawable.ic_checked);
                item_2.setIcon(R.drawable.ic_unchecked);
                item_3.setIcon(R.drawable.ic_unchecked);
                break;
            case 2:
                item_1.setIcon(R.drawable.ic_unchecked);
                item_2.setIcon(R.drawable.ic_checked);
                item_3.setIcon(R.drawable.ic_unchecked);
                break;
            case 3:
                item_1.setIcon(R.drawable.ic_unchecked);
                item_2.setIcon(R.drawable.ic_unchecked);
                item_3.setIcon(R.drawable.ic_checked);
                break;
        }

        return super.onPrepareOptionsMenu(menu);
    }

    // call and send tittle and text on second activity
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon1:
                tittle = tv_headTextView1.getText().toString();
                text = tv_TextView1.getText().toString();
                break;
            case R.id.icon2:
                tittle = tv_headTextView2.getText().toString();
                text = tv_TextView2.getText().toString();
                break;
            case R.id.icon3:
                tittle = tv_headTextView3.getText().toString();
                text = tv_TextView3.getText().toString();
                break;
            default:
                return;
        }
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.under_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.under_menu1:
                        openNewWindow();
                        return true;
                    case R.id.under_toast:
                        showToast();
                        return true;
                    case R.id.under_close:
                        finish();
                        return true;
                    default:
                        return false;
                }
            }
        }); popupMenu.show();

    }

    private void openNewWindow (){
        Intent intent = new Intent(this,Activity_2nd.class);
        intent.putExtra(Constant.HEADLINE_KEY, tittle);
        intent.putExtra(Constant.CONTENT_KEY, text);
        startActivity(intent);
    }

    private void showToast(){
        Toast.makeText(this, tittle + "\n" + text, Toast.LENGTH_SHORT).show();
    }

    private void check_EnableItem(){
        switch (ItemEnable){
            case 1:
                setAbleItem1(true);
                break;
            case 2:
                setAbleItem2 (true);
                break;
            case 3:
                setAbleItem3 (true);
                break;
        }
    }

    // set able item
    private void setAbleItem1(boolean a){
        relLay_item1.setEnabled(a);
        tv_headTextView1.setEnabled(a);
        img_und_menu_im1.setEnabled(a);
        tv_TextView1.setEnabled(a);
    }
    private void setAbleItem2(boolean a){
        relLay_item2.setEnabled(a);
        tv_headTextView2.setEnabled(a);
        img_und_menu_im2.setEnabled(a);
        tv_TextView2.setEnabled(a);
    }
    private void setAbleItem3(boolean a){
        relLay_item3.setEnabled(a);
        tv_headTextView3.setEnabled(a);
        img_und_menu_im3.setEnabled(a);
        tv_TextView3.setEnabled(a);
    }

    // disaable item
    private void disable_AllItems(){
        setAbleItem1(false);
        setAbleItem2(false);
        setAbleItem3(false);
    }

    //enable item
    private void enableItem1(){
        disable_AllItems();
        setAbleItem1(true);
    }
    private void enableItem2(){
        disable_AllItems();
        setAbleItem2(true);
    }
    private void enableItem3(){
        disable_AllItems();
        setAbleItem3(true);
    }

    // variable initialization
    private void initAllElements(){
        relLay_item1 = (RelativeLayout) findViewById(R.id.line_item1);
        relLay_item2 = (RelativeLayout) findViewById(R.id.line_item2);
        relLay_item3 = (RelativeLayout) findViewById(R.id.line_item3);

        tv_headTextView1 = (TextView) findViewById(R.id.textView1);
        tv_headTextView2 = (TextView) findViewById(R.id.textView2);
        tv_headTextView3 = (TextView) findViewById(R.id.textView3);

        img_und_menu_im1 = (ImageView) findViewById(R.id.icon1);
        img_und_menu_im2 = (ImageView) findViewById(R.id.icon2);
        img_und_menu_im3 = (ImageView) findViewById(R.id.icon3);

        tv_TextView1 = (TextView) findViewById(R.id.text1);
        tv_TextView2 = (TextView) findViewById(R.id.text2);
        tv_TextView3 = (TextView) findViewById(R.id.text3);

    }
    // connecting small menu
    private void setListenersSmallMenu(){
        img_und_menu_im1.setOnClickListener(this);
        img_und_menu_im2.setOnClickListener(this);
        img_und_menu_im3.setOnClickListener(this);
    }
}
