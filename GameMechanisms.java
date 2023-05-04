import java.util.*;
import java.lang.*;




public class GameMechanisms{
    Main main = new Main();
    Display dispilav = new Display();
    Scanner scan = new Scanner(System.in);

    public static boolean gameloop = true;

    public static int rowQuestion;
    public static int columnQuestion;
    
    



    public void askingUserRowColumn(){
        System.out.println("Which row do you want to choose ?");
        this.rowQuestion = scan.nextInt();
        System.out.println("Which column do you want to choose ?");
        this.columnQuestion = scan.nextInt();
    }


    public void iDontKnowHowItsDoin(){
        if(dispilav.area[this.rowQuestion-1][this.columnQuestion-1]=='M'){
            
            dispilav.playerArea[this.rowQuestion-1][this.columnQuestion-1] = dispilav.area[this.rowQuestion-1][this.columnQuestion-1];
            dispilav.displayArray(dispilav.playerArea);
            System.out.println("You hit the mine.Game Over.");
            this.gameloop = false;

        }else if(dispilav.area[this.rowQuestion-1][this.columnQuestion-1]=='0'){

            protocol(rowQuestion-1, columnQuestion-1);
            dispilav.displayArray(dispilav.playerArea);

        }else{
            dispilav.playerArea[this.rowQuestion-1][this.columnQuestion-1] = dispilav.area[this.rowQuestion-1][this.columnQuestion-1];
            dispilav.displayArray(dispilav.playerArea);
        }

    }



    public void protocol(int row ,int column){
        dispilav.playerArea[row][column]=dispilav.area[row][column];
        for(int i = row-1 ; i<=row+1 ; i++ ){
            if(i<0 | i>=dispilav.area.length){
                continue;
            }
            for(int j = column-1 ; j<=column+1 ; j++){
                if(j<0 | j>=dispilav.area[0].length){
                    continue;
                }
                if(dispilav.area[i][j]=='0' & dispilav.playerArea[i][j]!='0'){
                    protocol(i,j);
                    
                }else{
                    dispilav.playerArea[i][j]=dispilav.area[i][j];
                }
            }
        }

    }


    public void isMinesEqualNumberOfX(int mines){
        int numberOfX =0 ;
        for(int i = 0 ; i<dispilav.playerArea.length ; i++){
            for(int j = 0 ; j<dispilav.playerArea[i].length ; j++){
                if(dispilav.playerArea[i][j]=='X'){
                    numberOfX++;
                }
            }
        }
        if(numberOfX==mines){
            dispilav.displayArray(dispilav.area);
            System.out.println("CONGRATULATIONS,YOU WİN !!!");
            this.gameloop = false;

        }
    }





}