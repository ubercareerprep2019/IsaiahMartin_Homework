import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

/*Towers of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective
        of the puzzle is to move the entire stack to another rod, obeying the following simple rules (from
        geeksforgeeks.com)
        1. Only one disk can be moved at a time.
        2. Each move consists of taking the upper disk from one of the stacks and placing it on top
        of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
        3. No disk may be placed on top of a smaller disk.
 */

public class Part5_HanoiGame {
    int disks;
    TreeMap rods;
    int start_place;

    public Part5_HanoiGame(int number_of_disks, int starting_location)
    {
        start_place = starting_location;
        HashSet<Integer> remaining_rods = new HashSet();
        remaining_rods.add(1);
        remaining_rods.add(2);
        remaining_rods.add(3);
        disks = number_of_disks;
        rods = new TreeMap();

        if(remaining_rods.contains(starting_location)){
            remaining_rods.remove(starting_location);
            rods.put(starting_location, new Part3_stack());
            //top disk is #1, bottom disk is n
            for (int i=disks; i >= 1; i--) {
                Part3_stack start_rod = (Part3_stack)rods.get(starting_location);
                start_rod.push(i);
                rods.put(starting_location,start_rod);
            }
        }
        else
        {
            System.out.print("Starting location must be between 1 and 3 as there are 3 rods!");
            return;
        }
        for(int i=1; i<=3;i++)
        {
            if(remaining_rods.contains(i))
            {
                rods.put(i,new Part3_stack());
                remaining_rods.remove(i);
            }
        }
        System.out.println("\nStarting game, your disks are starting at "+starting_location+" and they must get to another rod");
    }

    void moveDisk(int startingRod, int destinationRod)
    {
        System.out.println("Attempting to move disk from rod "+startingRod+ " to rod "+destinationRod+"...");
        if(startingRod < 1 || startingRod > numberOfRods())
        {
            System.out.println("\nrodIndex must be between 1 and 3");
            return;
        }
        if(destinationRod < 1 || destinationRod > numberOfRods())
        {
            System.out.println("\nrodIndex must be between 1 and 3");
            return;
        }

        Integer disk = 0;
        if(((Part3_stack)(rods.get(startingRod))).isEmpty())
        {
            System.out.println("\nRod "+startingRod+" currently has no disks");
            return;
        }
        disk = (Integer)((Part3_stack)rods.get(startingRod)).top();
        //if destination rod is empty or disk number is smaller (lower number) than disk at destination, disk can move
        if(((Part3_stack)(rods.get(destinationRod))).isEmpty() || disk < (Integer)((Part3_stack)(rods.get(destinationRod))).top())
        {
            Part3_stack start_rod = (Part3_stack)rods.get(startingRod);
            disk = (Integer)start_rod.pop();
            rods.put(startingRod,start_rod);

            System.out.println("\nMoving disk "+disk+" from rod "+startingRod+ " to rod "+destinationRod);
            Part3_stack dest_rod = (Part3_stack)rods.get(destinationRod);
            dest_rod.push(disk);
            rods.put(destinationRod,dest_rod);
        }
        else
        {
            System.out.println("\ndisk must be smaller (lower number) than disk at destination");
        }
        win();
    }

    ArrayList<Integer> disksAtRod(int rodIndex)
    {
        if(rodIndex < 1 || rodIndex > numberOfRods())
        {
            System.out.println("\nrodIndex must be between 1 and 3");
            return null;
        }
        ArrayList<Integer> rodDisks = new ArrayList();
        ArrayList<Integer> rtnArray = new ArrayList();
        while(! ((Part3_stack)(rods.get(rodIndex))).isEmpty())
        {
            Part3_stack new_rod = (Part3_stack)(rods.get(rodIndex));
            int disk = (Integer)new_rod.pop();
            rods.put(rodIndex,new_rod);
            rodDisks.add(disk);
            rtnArray.add(disk);
        }
        while(! rodDisks.isEmpty())
        {
            Part3_stack rod_update = (Part3_stack) rods.get(rodIndex);
            rod_update.push(rodDisks.remove(rodDisks.size()-1));
            rods.put(rodIndex,rod_update);
        }
        System.out.println("Row "+rodIndex+"\t");
        for(Integer disk: rtnArray)
        {
            System.out.println(disk+" ");
        }
        System.out.print("\n");
        return rtnArray;
    }

    int numberOfRods()
    {
        return 3;
    }

    boolean win()
    {
        for(int i=1;i<=3;i++)
        {
            if(disksAtRod(i).size() == disks && i != start_place)
            {
                System.out.println("rod "+i+ " has all disks!");
                System.out.println("You win!!!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Part5_HanoiGame game = new Part5_HanoiGame(3,1);
        System.out.println("Number of rods: "+game.numberOfRods());
        game.disksAtRod(1);
        game.moveDisk(1,3);
        game.moveDisk(1,2);
        game.moveDisk(3,2);
        game.moveDisk(1,3);
        game.moveDisk(2,1);
        game.moveDisk(2,3);
        game.moveDisk(3,1);
        game.moveDisk(1,3);
    }

}