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
    int dest_rod;

    public Part5_HanoiGame(int number_of_disks, int starting_location, int destination_location)
            {
                dest_rod = destination_location;
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
            for (int i=disk; i > 0; i--) {
                rods.get(starting_location).push(i);
            }
        }
        else
        {
            System.out.print("Starting location must be between 1 and 3 as there are 3 rods!");
            return;
        }
        if(remaining_rods.contains(destination_location)){
            remaining_rods.remove(destination_location);
            rods.put(destination_location, new Part3_stack());
        }
        else
        {
            System.out.print("Remaining location must be between 1 and 3, and not the same as starting location!");
            return;
        }
        for(Integer last_spot: remaining_rods)
        {
            rods.put(last_spot,new Part3_stack());
        }
    }

    void moveDisk(int startingRod, int destinationRod)
    {
        if(startingRod < 1 || startingRod > numberOfRods())
        {
            System.out.println("rodIndex must be between 1 and 3");
            return;
        }
        if(destinationRod < 1 || destinationRod > numberOfRods())
        {
            System.out.println("rodIndex must be between 1 and 3");
            return;
        }

        Integer disk = 0;
        if(rods.get(startingRodRod).isEmpty())
        {
            System.out.println("Rod"+startingRod+"currently has no disks");
            return;
        }
        else {
            disk = rods.get(startingRod).pop();
        }
        //if destination rod is empty disk can move
        if(rods.get(destinationRod).isEmpty()) //
        {
            rods.get(destinationRod).push(disk);
        }
        //disk number must be larger (lower number) than disk at destination
        else if(disk > rods.get(destinationRod).top())
        {
            rods.get(destinationRod).push(disk);
        }
        else
        {
            System.out.println("disk must be larger (lower number) than disk at destination");
        }

    }

    ArrayList<Integer> disksAtRod(int rodIndex)
    {
        if(rodIndex < 1 || rodIndex > numberOfRods())
        {
            System.out.println("rodIndex must be between 1 and 3");
            return null;
        }
        ArrayList<Integer> rodDisks = new ArrayList();
        ArrayList<Integer> rtnArray = new ArrayList();
        while(! rods.get(rodIndex).isEmpty())
        {
            rtnArray.add(rods.get(rodIndex).top());
            rodDisks.add(rods.get(rodIndex).pop());
        }
        while(! rodDisks.isEmpty())
        {
            rods.get(rodIndex).push(rodDisks.remove(0));
        }
        return rtnArray;
    }

    int numberOfRods()
    {
        return numberOfRods();
    }

    boolean win()
    {
        if(rods.get(dest_rod).size() == numberOfRods())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}