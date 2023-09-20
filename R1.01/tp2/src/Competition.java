import java.util.Scanner;

public class Competition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("how many judge?");
        final int nbJudge = in.nextInt();
        float maxTime = 0f;
        float minTime = Float.MAX_VALUE;
        float accruedTime = 0f;
        in.nextLine();
        for (int i = 1; i <= nbJudge; i++) {
            System.out.print("judge "+ i + " how many time for this candidate?");
            final float temp = in.nextInt();
            in.nextLine();
            if(temp>20 || temp<0){
                i--;
                System.out.println("time must be between 0 and 20");
            }else{
                if(maxTime < temp) { maxTime = temp; }
                else if(minTime > temp) { minTime = temp;}
                accruedTime+=temp;
            }
        }
    }
}
