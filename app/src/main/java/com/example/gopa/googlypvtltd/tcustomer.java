package com.example.gopa.googlypvtltd;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class tcustomer extends Fragment {

    List<String> userSelection=null;
    ListView lv;
    String tablename;
    View row;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.tcustomer,container,false);
        return row;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Customer");
        fetch();
        lv=view.findViewById(R.id.profile);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        lv.setMultiChoiceModeListener(modeListener);
    }

    public void fetch(){
        tablename = (String) getActivity().getTitle();
        String type = "select";
        constants.progressDialog = new ProgressDialog(getContext());
        constants.progressDialog.setTitle("loading");
        constants.progressDialog.setMessage("please wait....");
        constants.progressDialog.show();
        constants.progressDialog.setCancelable(false);
        BackgroundWorker backgroundWorker = new BackgroundWorker(getContext(),row);
        backgroundWorker.execute(type, tablename);
    }

    AbsListView.MultiChoiceModeListener modeListener=new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            if(userSelection.contains(constants.customerId.get(position))){
                userSelection.remove(constants.customerId.get(position));
            }else{
                userSelection.add(constants.customerId.get(position));
            }
            View v=lv.getChildAt(position);
            ImageView tx=v.findViewById(R.id.chck);
            if(tx.getVisibility()==View.VISIBLE){
                tx.setVisibility(View.INVISIBLE);
            }
            else{
                tx.setVisibility(View.VISIBLE);
            }
            mode.setTitle(userSelection.size()+" selected");
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            constants.menuInflater.inflate(R.menu.main,menu);
            userSelection=new ArrayList<>();
            constants.actionBar.hide();
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int count=userSelection.size();
            switch (item.getItemId()){
                case R.id.delete:
                    for (int i=0;i<count;i++) {
                        String cust=userSelection.get(i);
                        BackgroundWorker backgroundWorker = new BackgroundWorker(getContext(), row);
                        backgroundWorker.execute("delete", tablename, cust);
                    }
                    mode.finish();
                    fetch();
                    return true;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            constants.actionBar.show();
            int count=constants.customerId.size();
            for(int i=0;i<count;i++){
                View v=lv.getChildAt(i);
                ImageView ix=v.findViewById(R.id.chck);
                if(ix.getVisibility()==View.VISIBLE){
                    ix.setVisibility(View.INVISIBLE);
                }
            }
            userSelection=null;
        }
    };


}
