import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Display dispilav = new Display();
        GameMechanisms hell = new GameMechanisms();


        

        System.out.println("How many row there are in minesweeper ?");
        int row = scan.nextInt();

        System.out.println("How many column there are in minesweeper ?");
        int column = scan.nextInt();

        System.out.println("How many mine there would be ?");
        int mines = scan.nextInt();

        while(row*column<mines){
            System.out.println("You entered more mines for board`s capacity,please enter diffrent number.");
            mines = scan.nextInt();
        }





        dispilav.designPlayerArea(row, column);
        dispilav.makingArea(row, column);
        dispilav.puttingMines(mines , row ,column);
        dispilav.addingNumbers();

        
        dispilav.displayArray(dispilav.area);
        dispilav.displayArray(dispilav.playerArea);


        while(hell.gameloop){
            hell.askingUserRowColumn();
            hell.iDontKnowHowItsDoin();
            hell.isMinesEqualNumberOfX(mines);
        }




        

    }vvadfadfafa
}