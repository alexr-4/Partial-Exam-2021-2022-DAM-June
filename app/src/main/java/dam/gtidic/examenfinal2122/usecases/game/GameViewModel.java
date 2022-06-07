package dam.gtidic.examenfinal2122.usecases.game;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dam.gtidic.examenfinal2122.usecases.game.level.LevelRepository;
import dam.gtidic.examenfinal2122.usecases.models.Level;
import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public abstract class GameViewModel extends ViewModel {

    private final static String TAG = "GameViewModel";

    // Game Logic Attributes
    protected MutableLiveData<Level> level;
    protected LevelRepository repository;
    protected MutableLiveData<Boolean> isValid;

    // UI and UX interaction Attributes
    private MutableLiveData<String> progress;
    protected MutableLiveData<String> userSolution;

    // Constructors
    public GameViewModel() {
        this.userSolution = new MutableLiveData<>();
        this.level = new MutableLiveData<>();
        this.progress = new MutableLiveData<>();
        this.isValid = new MutableLiveData<>();
        this.setRepo();
        loadLevel();
        setProgress();
    }

    // Protected methods
    protected abstract void  setRepo();

    protected void increaseLevel(){
        int currentLevel = getCurrentLevel();
        PreferencesProvider.providePreferences().edit().putInt("current_level", currentLevel + 1 ).apply();
        Log.d(TAG, "Stored the progress in the Shared Prfrerences...");
        Log.d(TAG, "Level: " + (currentLevel + 1));
    }


    // Public methods
    public abstract LiveData<Boolean> isLevelValid();
    public boolean moreLevels(){
        int currentLevel = getCurrentLevel();
        return currentLevel < this.repository.getSize();
    }

    public void loadLevel(){
        int currentLevel = getCurrentLevel();
        Level l = this.repository.getLevel(currentLevel);
        this.level.setValue(l);
    }

    // Private methods
    private int getCurrentLevel(){
        return PreferencesProvider.providePreferences().getInt("current_level", 0);
    }

    private void setProgress(){
        int l = getCurrentLevel();
        int L = this.repository.getSize();
        String progres_str = l + "/" + L;
        this.progress.setValue(progres_str);
    }

    // Getters and Setters
    public LiveData<Level> getLevel(){
        return this.level;
    }

    public void setLevel(MutableLiveData<Level> level) {
        this.level = level;
    }

    public MutableLiveData<String> getUserSolution() {
        return userSolution;
    }

    public void setUserSolution(MutableLiveData<String> userSolution) {
        this.userSolution = userSolution;
    }

    public MutableLiveData<String> getProgress() {
        return progress;
    }

    public void setProgress(MutableLiveData<String> progress) {
        this.progress = progress;
    }

    protected abstract double getSolution();
}
