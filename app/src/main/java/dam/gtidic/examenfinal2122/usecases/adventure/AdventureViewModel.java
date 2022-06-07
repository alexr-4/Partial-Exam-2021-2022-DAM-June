package dam.gtidic.examenfinal2122.usecases.adventure;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class AdventureViewModel extends ViewModel {

    public MutableLiveData<String> videsTv;


    public AdventureViewModel(){

        this.videsTv = new MutableLiveData<>();

        int videsActuals = PreferencesProvider.providePreferences().getInt("lives", 0);

        Log.d("videsactuals", String.valueOf(videsActuals));

        this.videsTv.setValue(String.valueOf(videsActuals));

    }

    public void sumarVides(){

        PreferencesProvider.providePreferences().edit().putInt("lives", PreferencesProvider.providePreferences().getInt("lives", 0)+1).commit();

        this.videsTv.setValue(String.valueOf(PreferencesProvider.providePreferences().getInt("lives",0)));

    }


}
