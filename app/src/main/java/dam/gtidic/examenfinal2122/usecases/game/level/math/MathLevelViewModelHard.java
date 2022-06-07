package dam.gtidic.examenfinal2122.usecases.game.level.math;


import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.Objects;

import dam.gtidic.examenfinal2122.usecases.game.GameViewModel;
import dam.gtidic.examenfinal2122.usecases.models.MathExprLevel;


public class MathLevelViewModelHard extends GameViewModel {

    private final static String TAG = "MathLevelViewModel";

    @Override
    protected void setRepo() {
        this.repository = new MathExprLevelMockRepositoryHard();
    }

    @Override
    public LiveData<Boolean> isLevelValid(){
        if (this.userSolution.getValue() != null) {
            String solution_str = this.userSolution.getValue();
            double solution = Double.parseDouble(solution_str);

            MathLevelViewModelHard l = (MathLevelViewModelHard) this.level.getValue();

            if (Objects.requireNonNull(l).getSolution() == solution) {
                Log.d(TAG, "Level passed...");
                this.increaseLevel();
                isValid.postValue(true);

            } else {
                Log.d(TAG, "Level not passed...");
                isValid.postValue(false);
            }
        }
        return isValid;
    }

    @Override
    protected double getSolution() {
        return 0;
    }


}
