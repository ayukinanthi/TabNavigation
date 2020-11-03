package android.example.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private ArrayList<ItemData> itemValues;
    private RecyclerView recycleView;
    private ItemAdapter itemAdapter;
    private FloatingActionButton addButton;

    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        recycleView=view.findViewById(R.id.recycleView);
        addButton=view.findViewById(R.id.addButton);
        itemValues=new ArrayList<>();
        for(int i=1; i<=10; i++){
            ItemData item=new ItemData();
            item.itemTitle="Title Data - "+i;
            item.itemSubTitle="Subtitle Data - "+i;
            itemValues.add(item);
        }
        itemAdapter=new ItemAdapter(getActivity(), itemValues);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(itemAdapter);
        GridLayoutManager layoutManager2 = new GridLayoutManager(getActivity(), 2);
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                addData();
            }
        });

        return view;

        }

    private void addData() {
        ItemData item=new ItemData();
        item.itemTitle="Title Data - Baru";
        item.itemSubTitle="Subtitle Data - Baru";
        itemValues.add(item);
        itemAdapter.notifyDataSetChanged();
    }

}
