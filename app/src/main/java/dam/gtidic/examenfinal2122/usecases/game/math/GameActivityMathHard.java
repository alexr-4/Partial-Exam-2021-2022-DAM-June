package dam.gtidic.examenfinal2122.usecases.game.math;

import android.content.Intent;
import android.util.Log;
import android.view.ViewStub;

import androidx.lifecycle.ViewModelProvider;

import dam.gtidic.examenfinal2122.R;
import dam.gtidic.examenfinal2122.usecases.game.GameActivity;
import dam.gtidic.examenfinal2122.usecases.game.level.math.MathLevelViewModel;
import dam.gtidic.examenfinal2122.usecases.game.level.math.MathLevelViewModelHard;
import dam.gtidic.examenfinal2122.usecases.game.level.math.MathLevelViewModelMedium;


public class GameActivityMathHard extends GameActivity {

    private static final String TAG = "GameActivityMath";

    @Override
    public void setViewModel() {
        viewModel = new ViewModelProvider(this).get(MathLevelViewModelHard.class);
    }

    @Override
    public void inflateGameModeLayout() {
        Log.d(TAG, "...inflating @layout_math");
        ViewStub vs = binding.VSlevelLayout.getViewStub();
        vs.setLayoutResource(R.layout.math_layout_hard);
        binding.VSlevelLayout.getViewStub().inflate();
    }

    @Override
    public void reload() {
        startActivity(new Intent(this, GameActivityMathHard.class));
    }

}