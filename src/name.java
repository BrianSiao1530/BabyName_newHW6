import java.io.*;
import java.awt.*;
import java.util.*;

public class name {
    public static void main(String[] args)  throws FileNotFoundException{
        String numbers;
        Scanner input = new Scanner(System.in);
        Begin();
        System.out.print("name? ");
        String theName = input.next();
        System.out.print("sex (M or F)? ");
        char sex = input.next().charAt(0);
        numbers = search(theName,sex);
        if(numbers.equals(" ") == false) {
            drawchart(theName, sex, numbers);
        }
        else
            System.out.print("name/sex combination not found");
    }
        public static void Begin(){
            System.out.println("This program allows you to search through the");
            System.out.println("data from the Social Security Administration");
            System.out.println("to see how popular a particular name has been");
            System.out.println("since 1920.\n");
        }
        public static String search(String name , char sex)throws FileNotFoundException{
            Scanner output = new Scanner(new File("names.txt"));
            Scanner output1 = new Scanner(new File("names2.txt"));
            String namee  , end=" ";
            char sexx   ;
            while (output.hasNextLine() && end.equals(" ") ){
                Scanner temppp = new Scanner(output.nextLine());
                namee = temppp.next();
                sexx = temppp.next().charAt(0);
                if (namee.equals(name) && sexx == sex ) {
                    end = temppp.nextLine();
                }else
                    end= " ";
            }
            return end;
        }
        public static void drawchart( String name, char sex ,String numbers) {
            DrawingPanel panel = new DrawingPanel(980  , 550);
            Graphics g = panel.getGraphics();
            panel.setBackground(Color.WHITE);
            Scanner count = new Scanner(numbers);
            Scanner count2 = new Scanner(numbers);
            Scanner count3 = new Scanner(numbers);
            int numcount = 0;
            int width;
            int year = 0,gap =0;
            int exX = 0,exY = count3.nextInt();
            int caculate;
            g.setColor(Color.black);
            g.drawLine(0, 525, 980, 525);
            g.drawLine(0, 25, 980, 25);


            while (count.hasNextInt()) {
                count.nextInt();
                numcount++;
            }
            width = 980 / numcount;
            if(numcount == 14){
                year = 1880;
                gap = width;
            } else if (numcount==10) {
                year = 1920;
                gap = width;
            }

            for (int i = 0; i < numcount; i++) {
                g.setColor(Color.black);
                int x = 0+gap*i;
                String yearss = String.valueOf(year+10*i);
                g.drawString(yearss, x, 550);
                int middle = count2.nextInt();

                g.drawLine(gap*i,0,gap*i,550);
                String display =name + " " +sex + " " + String.valueOf(middle);
                if( middle == 0 ){
                    middle=1000;
                }
                caculate =middle/2+25;
                g.setColor(Color.red);
                g.drawString(display,x, caculate);
                g.drawLine(exX,exY,x,caculate);
                exX= x;
                exY = middle/2+25;
            }
        }
    }

