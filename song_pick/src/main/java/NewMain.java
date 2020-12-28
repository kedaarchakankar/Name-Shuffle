/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kedaarchakankar
 */
import java.util.ArrayList;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> males = new ArrayList<String>();
        ArrayList<String> females = new ArrayList<String>();
        
        
        males.add("Abhijit");
        females.add("Manisha");
        
        males.add ("Parag");
        females.add("Roopam");
        
        males.add ("Gagan");
        females.add("Varna");
        
        males.add ("Kuldeep");
        females.add("Shailu");
        
        males.add ("Santosh");
        females.add("Namita");
        
        pickSong(males, females);
        singSong(males, females);
    }
    
    public static boolean checkMarried (ArrayList<String> males, ArrayList<String> females, 
            String male, String female)
    {
        return (males.indexOf(male) == females.indexOf(female) && males.indexOf(female) == females.indexOf(male));
    }
    
    public static void pickSong (ArrayList<String> males, ArrayList<String> females)
    {
        ArrayList<String> pickers = new ArrayList<String>();
        ArrayList<String> participants = new ArrayList<String>();
        
        for (int i = 0; i < males.size(); i++)
        {
            pickers.add(males.get(i));
            pickers.add(females.get(i));
            
            participants.add(males.get(i));
            participants.add(females.get(i));
        }
        
        ArrayList<String> sing = new ArrayList<String>();
        int size = pickers.size() + participants.size() - 1;
        
        while(sing.size() < size)
        {
            int random = (int) (Math.random() * (pickers.size()));
            int j = -1;
            for (int i = 0; i < participants.size(); i++)
            {
                if (!checkMarried(males, females, pickers.get(random), participants.get(i)) 
                        && !pickers.get(random).equals(participants.get(i)))
                {
                    j = i;
                    break;
                }
            }
            
            if (j >= 0)
            {
                sing.add(pickers.get(random));
                sing.add(participants.get(j));
                    
                pickers.remove(random);
                participants.remove(j);
            }
            else
            {
                participants.add(sing.get(sing.size() - 1));
                pickers.add(sing.get(sing.size() - 2));
                
                sing.remove (sing.size() - 1);
                sing.remove (sing.size() - 1);
            }
        }
        
        for (int i = 0; i < sing.size(); i+= 2)
        {
            System.out.println (sing.get(i) + ", " + sing.get(i+1));
        }
    }
    
    public static void singSong(ArrayList<String> males, ArrayList<String> females)
    {
        String temp;
        // TODO: Try to find a java function which does full array copy.
        
        ArrayList<String> males2 = new ArrayList<String>();
        ArrayList<String> males3 = new ArrayList<String>();
         ArrayList<String> females2 = new ArrayList<String>();
        ArrayList<String> females3 = new ArrayList<String>();
        
        for (int i = 0; i < males.size(); i++)
        {
            males2.add(males.get(i));
            females2.add(females.get(i));
        }
        // TODO: Make 100 a constant.
        while(males3.size() < males.size())
        {
            int random = (int) (Math.random() * (males2.size()));
            int j = -1;
            
            for (int i = 0; i < females2.size(); i++)
            {
                if (!checkMarried(males, females, males2.get(random), females2.get(i)))
                {
                    j = i;
                    break;
                }
            }
            
            if (j >= 0)
            {
                males3.add(males2.get(random));
                females3.add(females2.get(j));
                
                males2.remove(random);
                females2.remove(j);
            }
            else
            {
                males2.add(males3.get(males3.size()-1));
                females2.add(females3.get(females3.size()-1));
                
                males3.remove(males3.size()-1);
                females3.remove(females3.size()-1);
            }
        }
        System.out.println("");
        
        for (int i = 0; i < males.size(); i++)
        {
            System.out.println(males3.get(i) + ", " + females3.get(i));
        }
    }
    
}
