package com.sqlite.sab.movies.activities;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sqlite.sab.movies.R;
import com.sqlite.sab.movies.adapter.CustomArrayAdapter;
import com.sqlite.sab.movies.models.ModelMovie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<ModelMovie> movieArrayList;
    CustomArrayAdapter customArrayAdapter;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridView = findViewById(R.id.gridmovie);
      /*  progressBar = findViewById(R.id.progress_bar);
        progressBar.setProgress(0);
        progressBar.setMax(100);*/
        movieArrayList = new ArrayList<>();

      /*  ModelMovie modelMovie = new ModelMovie();
      //  modelMovie.setImgfilm(R.drawable.ic_android_black_24dp);
        modelMovie.setTxtfilm("GodFather");

        ModelMovie modelMovie2 = new ModelMovie();
     //   modelMovie2.setImgfilm(R.drawable.ic_av_timer_black_24dp);
        modelMovie2.setTxtfilm("need for speed");

        ModelMovie modelMovie3 = new ModelMovie();
     //   modelMovie3.setImgfilm(R.drawable.ic_flight_land_black_24dp);
        modelMovie3.setTxtfilm("legend");

        movieArrayList.add(modelMovie);
        movieArrayList.add(modelMovie2);
        movieArrayList.add(modelMovie3);
*/
        customArrayAdapter = new CustomArrayAdapter(HomeActivity.this, movieArrayList);
        gridView.setAdapter(customArrayAdapter);

        new fetchmovies().execute();


    }

    private void  getMovieDataFromJson(String movieJsonStr)
        throws JSONException{

        final String OWN_RESULTS = "results";
        final String OWN_ORIGINAL_TITLE = "original_title";
        final  String OWN_POSTER_PATH = "poster_path";


        JSONObject movieJson = new JSONObject(movieJsonStr);
        JSONArray resultsArray = movieJson.getJSONArray(OWN_RESULTS);

        ModelMovie item;

        for (int i = 0; i < resultsArray.length(); i++){
            String original_title;
            String poster_path;
            item = new ModelMovie();

            JSONObject movies = resultsArray.getJSONObject(i);

            original_title = movies.getString(OWN_ORIGINAL_TITLE);
            item.setTxtfilm(original_title);

            poster_path = "http://image.tmdb.org/t/p/w185/"+ movies.getString(OWN_POSTER_PATH);
            item.setImgfilm(poster_path);

            // to add new row
            movieArrayList.add(item);
        }

    }



    class fetchmovies extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            Integer result = 0;
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String moviesJsonstr;
            try {
                final String Base_URL = "https://api.themoviedb.org/3/movie/popular?api_key=29f10dbc214c3f5e3c291e1f0d4598db&language=en-US&page=1";
                Uri builduri = Uri.parse(Base_URL).buildUpon().build();
                URL url = new URL(builduri.toString());


                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return result;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return result;
                }
                moviesJsonstr = buffer.toString();


            } catch (Exception e) {
                Log.i("result" , e.getMessage());
                return result;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException io) {
                        Log.i("close" , io.getMessage());

                    }
                }
            }

                try {
                    getMovieDataFromJson(moviesJsonstr);
                    result=1;
                }catch (JSONException j){
                    j.getStackTrace();
                    Log.i("json" , j.getMessage());

                }

                return result;
               /* try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(100);
                        publishProgress(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/




            }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(HomeActivity.this, "Start", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Integer result) {
            /*super.onPostExecute(integer);
            Toast.makeText(HomeActivity.this, "End", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);*/

            if (result == 1){
                customArrayAdapter.notifyDataSetChanged();

            }else{
                Toast.makeText(HomeActivity.this, "FAILED TO FETCH DATA!", Toast.LENGTH_LONG).show();
            }

        }

      /*  @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }*/
    }
}
