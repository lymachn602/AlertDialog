package com.example.linyuming.alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog  dialog;
    private AlertDialog.Builder builder;
    private TextView textView;
    @Override
    public   void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) this.findViewById(R.id.textView);
        Button but1=(Button) this.findViewById(R.id.button1);
        Button but2=(Button) this.findViewById(R.id.button2);
        Button but3=(Button) this.findViewById(R.id.button3);
        Button but4=(Button) this.findViewById(R.id.button4);
        Button but5=(Button) this.findViewById(R.id.button5);
        Button but6=(Button) this.findViewById(R.id.button6);
        Button but7=(Button) this.findViewById(R.id.button6);
        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }

        };
        but1.setOnClickListener(listener);
        but2.setOnClickListener(listener);
        but3.setOnClickListener(listener);
        but4.setOnClickListener(listener);
        but5.setOnClickListener(listener);
        but6.setOnClickListener(listener);
        but7.setOnClickListener(listener);
    }

    public  void dialog1() {
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗？");
        //设置图标
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        //创建按键监听
        DialogInterface.OnClickListener listenter=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE) {//按下确定
                dialog.dismiss();
                    MainActivity.this.finish();
                } else if(which==DialogInterface.BUTTON_NEGATIVE) {
                    dialog.dismiss();
                }
                }


        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listenter);
        dialog.show();
    }
    public void dialog2() {
     dialog =new AlertDialog.Builder(this).create();
     dialog.setTitle("调查");
    dialog.setMessage("你平时忙吗？");
     dialog.setIcon(android.R.drawable.ic_dialog_info);

     DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
             String str="";
             switch (which){
                 case DialogInterface.BUTTON_POSITIVE:
                     str="平时很忙";
                     break;
                 case DialogInterface.BUTTON_NEUTRAL:
                     str="平时一般";
                     break;
                 case DialogInterface.BUTTON_NEGATIVE:
                     str="平时轻松";
                     break;
             }
             textView.setText(str);
         }
     };
     dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listenter);
     dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listenter);
     dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listenter);
     dialog.show();
 }
    public void dialog3() {
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit= new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4() {
        final String item[]= new String[]{"北京","上海","广州"};
        final boolean bSelect[] =new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter =new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListenter);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                textView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog5(){
     final String item[] =new String[]{"北京","上海","广州"};
     final boolean bSelect[] =new boolean[item.length];
     DialogInterface.OnClickListener sListenter =new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
             bSelect[which]=true;
         }
     };
     builder =new AlertDialog.Builder(this);
     builder.setSingleChoiceItems(item,-1,sListenter);
     dialog.setTitle("单选框");
     DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
             String str="你选择了:";
             for (int i=0;i<bSelect.length;i++){
                 if (bSelect[i]){
                     str=str+"\n"+item[i];
                 }

             }
             textView.setText(str);
         }
     };
     dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
     dialog.show();
 }
    public void dialog6(){
        final String item[] =new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener slistener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:"+item[which];
                textView.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,slistener);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"取消",listener);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout =inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit =(EditText)layout.findViewById(R.id.editText1);
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
}
