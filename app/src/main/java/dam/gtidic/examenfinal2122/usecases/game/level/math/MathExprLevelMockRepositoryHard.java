package dam.gtidic.examenfinal2122.usecases.game.level.math;

import dam.gtidic.examenfinal2122.usecases.game.level.LevelRepository;
import dam.gtidic.examenfinal2122.usecases.models.Level;
import dam.gtidic.examenfinal2122.usecases.models.MathExpr;
import dam.gtidic.examenfinal2122.usecases.models.MathExprLevel;
import dam.gtidic.examenfinal2122.usecases.models.Operations;

public class MathExprLevelMockRepositoryHard implements LevelRepository {

    private final static MathExprLevel[] expressions = {
                new MathExprLevel( 3, new MathExpr("8", Operations.MULTIPLY, "?","12") ),
                new MathExprLevel( 25, new MathExpr("23", Operations.ADD, "2","?") ),
                new MathExprLevel( 75, new MathExpr("100", Operations.SUBTRACT, "?","25") ),
                new MathExprLevel( 56, new MathExpr("?", Operations.ADD, "33","89") ),
                new MathExprLevel( 9, new MathExpr("5", Operations.MULTIPLY, "?","45") ),
            };


    // Constructor
    public MathExprLevelMockRepositoryHard() {}


    /**
     * Returns the level that is found in the position id of expressions arrays
     * @param id Position of the level to be returned
     * @return Level or null if position not in the array.
     */
    @Override
    public Level getLevel(int id) {
        if (id < expressions.length){
            return expressions[id];
        }
        return null;
    }

    @Override
    public int getSize() {
        return expressions.length;
    }

}
