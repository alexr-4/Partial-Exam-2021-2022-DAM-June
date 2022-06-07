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
    public MutableLiveData<Boolean> esPotJugar;
    public MutableLiveData<Integer> nivellElegit;



    public AdventureViewModel(){

        this.esPotJugar = new MutableLiveData<>();

        this.nivellElegit = new MutableLiveData<>();

        this.videsTv = new MutableLiveData<>();

        int videsActuals = PreferencesProvider.providePreferences().getInt("lives", 0);

        Log.d("vides",String.valueOf(videsActuals));

        comprovacioJugar(videsActuals);

        Log.d("videsactuals", String.valueOf(videsActuals));

        this.videsTv.setValue(String.valueOf(videsActuals));

    }

    public void sumarVides(){

        PreferencesProvider.providePreferences().edit().putInt("lives", PreferencesProvider.providePreferences().getInt("lives", 0)+1).commit();

        this.videsTv.setValue(String.valueOf(PreferencesProvider.providePreferences().getInt("lives",0)));

        int videsActuals = PreferencesProvider.providePreferences().getInt("lives", 0);

        comprovacioJugar(videsActuals);

    }

    public void comprovacioJugar(int videsActuals){
        if(videsActuals == 0) this.esPotJugar.setValue(false);
        else this.esPotJugar.setValue(true);
    }


    public void elegitEasy(){
     this.nivellElegit.setValue(1);
    }

    public void elegitMedium(){
        this.nivellElegit.setValue(2);

    }

    public void elegitHard(){
        this.nivellElegit.setValue(3);

    }


}
