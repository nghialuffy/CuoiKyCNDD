package com.e.myapplication.ui.logout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.e.myapplication.ui.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý đăng xuất tài khoản không?");
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
                mFirebaseAuth.signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        b.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog al = b.create();
        al.show();
        return null;
    }
}