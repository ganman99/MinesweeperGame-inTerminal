import java.util.Scanner;

public class Display{
    Main main = new Main();
    
    Scanner scan = new Scanner(System.in);

    
    // Real area which is cannot seen by user and it is game`s guide.
    public static char[][] area;

    // Player`s area and all actions are happened in this array,board or area whatever you want to call it.
    public static char[][] playerArea;
    
    // Note: Arrays are declared as char because there aren`t enough number in integer.





    public void designPlayerArea(int row , int column){
        this.playerArea = new char[row][column];

        for(int i = 0 ; i<this.playerArea.length ;i++){
            for(int j = 0 ; j<this.playerArea[i].length ; j++){
                this.playerArea[i][j] = 'X';
            }
        }
    }





    //Taking input from user for array`s row and column.
    public void makingArea(int row , int column){
        this.area = new char[row][column];

        for(int i = 0; i<row ;i++){
            for(int j = 0; j<column ;j++){
                //All of array`s elements are declared zero as char.
                this.area[i][j] ='0';
            }
        }
    }


    //Basiclly this method randomly puts a char of 'M' whose amount is called from player.
    public void puttingMines(int mines , int row , int column){

        int tempRow , tempColumn;

        //First how many mines must be there ? Then it is codded in loop
        for(int i = 0 ; i<mines ; i++){
            
            //Mines would be placed randomly in order not to be above of row or column
            tempRow = (int)(Math.random()*row);
            tempColumn = (int)(Math.random()*column);

            //If random row and column (array`s element) is not 'M',
            if(this.area[tempRow][tempColumn]!='M'){
                //Declare as 'M'.
                this.area[tempRow][tempColumn]='M';

            }else{
                //Wrong row and column.Go to begining of the loop
                i--;
                continue;

            }

        }
    }


    /* In minesweeper game, player must see each how many mines are there 
       so addingNumbers() method makes mines` next or cross elements increasing 1.
       Also it increases each elements.
    */
    public void addingNumbers(){
        // Need a temporary integer value
        int tempNum ;

        // Controlling each elements
        for(int i = 0 ; i<this.area.length ; i++){
            for(int j = 0 ; j<this.area[i].length ; j++){

                //If a element is 'M'
                if(this.area[i][j]=='M'){

                    //To select mines` up and down side.(Row)
                    for(int a = i-1 ; a<=i+1 ; a++){

                        /*If it is out of area,Then continue next one.(Below or above row`s length).
                          Also this if block finds wanted row.
                        */
                        if(a<0 | a>=this.area.length){
                            continue;
                        }

                        // To select mines` left and right side.(Column)
                        for(int b = j-1 ; b<=j+1 ; b++){

                            /*To find out of area.It is like protocol to selected numbers are wanted elements.
                              Also this if block finds wanted column.
                            */
                            if(b<0 | b>=this.area[0].length){
                                continue;
                            }

                            /*Selected row and column can be in mines` himself so if block fixes this.
                              Also it increases one mines` surround.
                            */
                            if(this.area[a][b]!='M'){
                                tempNum = (int)this.area[a][b];
                                tempNum++;
                                this.area[a][b] = (char)tempNum;

                            }

                        }
                    }
                }
            }
        }
    }





    public void displayArray(char[][] arr){
        System.out.print("   ");
        for(int i = 0 ; i<arr[0].length ; i++){
            if(i>8){
                System.out.print(i+1);
                continue;
            }
            System.out.print(i+1+" ");
        }

        for(int i = 0 ; i<arr.length ; i++){
            System.out.println("");
            if(i+1>9){   
                System.out.print((i+1));
            }else{
                System.out.print(" "+(i+1));
            }
            for(int j = 0 ; j<arr[i].length ;j++ ){
                System.out.print(" "+arr[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    
    



}