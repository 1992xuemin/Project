import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by xuemin on 15-2-4.
 */
public class Game {

    private final PrintStream out;
    private final BufferedReader reader;
    private final NumberGenerator numberGenerator;
    private final CompareNumber compareNumber;

    public Game(PrintStream out, BufferedReader reader,
                NumberGenerator numberGenerator, CompareNumber compareNumber){
        this.out=out;
        this.reader = reader;
        this.numberGenerator = numberGenerator;
        this.compareNumber = compareNumber;
    }
    public void start() throws IOException {
        int chance=6;
        out.println( "welcome!");
        while (chance>0){
            out.println("please input your answer("+chance+"):");
            String input = numberGenerator.generate();
            String answer =reader.readLine();
            String result = compareNumber.compare(input, answer);
            if("4A0B".equals(result)){
                out.println("Congratulation!");
                return;
            }
            chance--;
            out.println(result);
            }
        out.println("Game over!");
        }
}
