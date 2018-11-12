import java.util.Random;

class Algo {
    private int k;
    private int a[][]={{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}};

    public Algo(int ar[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                a[i][j]=ar[i][j];
            }
        }
         k=Solve(a);



    }
    int getk()
    {return k;}

    public Algo(){
        Random r=new Random();
        int coorx=r.nextInt(8)+0;
        int coory=r.nextInt(8)+0;

        a[coorx][coory]=r.nextInt(9)+1;

         Solve(a);


    }

    int Solve(int ar[][]){

        int i=0,j=0,row=0,col=0,num=0;
        int flag=0;
        for( i=0;i<9;i++)
        {
            for( j=0;j<9;j++)
            {
                if(ar[i][j]==0)
                {

                    flag=1;
                    break;
                }

            }
            if(flag==1)
                break;
        }

        if(flag==0)
            return 1;

        row=i;
        col=j;

        for(int k=1;k<=9;k++)
        {num=k;
            int res=assigned(num,ar,row,col);
            if(res!=0)
            {

                ar[row][col]=num;
                if(Solve(ar)==1)
                    return 1;

                ar[row][col]=0;

            }

        }
        return 0;


    }
    int assigned(int num,int ar[][],int row,int col){

        for(int i=0;i<9;i++)
        {
            if(ar[row][i]==num)

                return 0;
        }
        for(int i=0;i<9;i++)
        {
            if(ar[i][col]==num)
                return 0;
        }
        if(row>=0&&row<3){
            row=0;
        }
        else if(row>=3&&row<6){
            row=3;
        }
        else if(row>=6&&row<9){
            row=6;
        }

        if(col>=0&&col<3){
            col=0;
        }
        else if(col>=3&&col<6){
            col=3;
        }
        else if(col>=6&&col<9){
            col=6;
        }

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {

                if(ar[row+i][col+j]==num)
                    return 0;
            }
        }
        return 1;
    }

    public int[][] getGrid(){
        return a;
    }
}

//public class SudokuAlgo{
//    public static void main(String args[]){
//        int a[][];
//
//       Algo obj=new Algo();
//
//        a=obj.getGrid();
//
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//
//    }
//}