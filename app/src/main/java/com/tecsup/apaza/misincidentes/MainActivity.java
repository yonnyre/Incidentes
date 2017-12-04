package com.tecsup.apaza.misincidentes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Trigger;
import com.tecsup.apaza.misincidentes.service.MyJobService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

   // private RecyclerView incidenciasList;
    private ListView mainListView ;
 //   private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Incidente> incidente = new ArrayList<Incidente>();

        mainListView = (ListView) findViewById(R.id.mainListView);

        IncidentesAdapter adapter = new IncidentesAdapter(this, incidente);

        mainListView.setAdapter(adapter);



        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //mainListView.setAdapter(adapter);


        // FirebaseJobDispatcher configuration
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(MainActivity.this));
        dispatcher.mustSchedule(
                dispatcher.newJobBuilder()
                        .setService(MyJobService.class)
                        .setTag("MyJobService")
                        .setRecurring(true)
                        .setTrigger(Trigger.executionWindow(5, 30)) // Cada 5 a 30 segundos
                        .build()

        );


      //  productosList = (RecyclerView) findViewById(R.id.recyclerview);
      //  productosList.setLayoutManager(new LinearLayoutManager(this));

      //  productosList.setAdapter(new ProductosAdapter());

        initialize();


    }





    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Incidente>> call = service.getIncidentes();

        call.enqueue(new Callback<List<Incidente>>() {
            @Override
            public void onResponse(Call<List<Incidente>> call, Response<List<Incidente>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {
                        //mainListView = (ListView) findViewById(R.id.mainListView);

                        List<Incidente> incidentes = response.body();
                        Log.d(TAG, "productos: " + incidentes);

                        IncidentesAdapter adapter = (IncidentesAdapter) mainListView.getAdapter();
                        adapter.setIncidentes((ArrayList<Incidente>) incidentes);
                        adapter.notifyDataSetChanged();


                        // ArrayList<Incidente> category = new ArrayList<Incidente>();

                       // ArrayList<Incidente> planetList = new ArrayList<Incidente>();
                      //  planetList.addAll( Arrays.asList(planets) );
                      //   listAdapter = new ArrayAdapter<Incidente>(this, R.layout.item_incidencia,planetList);
                      //  IncidentesAdapter adapter = (IncidentesAdapter) incidentesList.getAdapter();
                      //  adapter.setProductos(productos);
                      //  adapter.notifyDataSetChanged();

                       /// mainListView.setAdapter(listAdapter);

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Incidente>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }



}
