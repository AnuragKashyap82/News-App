package kashyap.anurag.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {

    private String api = "35a09884347c49d5b942eff15e09f3ba";
    private ArrayList<ModelClass> modelClassArrayList;
    private Adapter adapter;
    String country = "in";
    private RecyclerView technologyRv;
    private String category = "technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technology_fragment, null);

        technologyRv = view.findViewById(R.id.technologyRv);
        modelClassArrayList = new ArrayList<>();
        technologyRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        technologyRv.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {

        ApisUtilities.getApiInterface().getCategoryNews(country, category, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}
