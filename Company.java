/**
 * Creats a class that represents a Company that rents cars.
 *
 * @author Elad Sopher
 * @version 26/01/23
 */
public class Company
{
    private static final int MAX_RENTS = 1000;

    private Rent[] _rents;
    private int _noOfRents;

    /**
     * Creates a new array with default size and sets the counters of the rents in the array to 0
     */
    public Company()
    {
        _rents = new Rent[MAX_RENTS];
        _noOfRents = 0;
    }

    /**
     * Adds a Rent object to the array in the order of the pick date and leave no holes in the array
     * increase the number of the rents in the array by 1
     * @param name the name of the person that rented the car
     * @param car the car that was rented from class Car
     * @param pick the date the rent started - from class Date
     * @param ret the date the rent ends - from class Date
     * @param rent the rent to insert - created with name,car,pick,ret
     * @param temp to save a rent in case we need to move his place in the array
     * @returns true if the add of the rent was successful, otherwise false
     */
    public boolean addRent(String name,Car car,Date pick,Date ret)
    {
        if(_noOfRents == MAX_RENTS)
            return false;
        else if(_noOfRents == 0)
        {
            _rents[0] = new Rent(name,car,pick,ret);
            _noOfRents++;
            return true;
        }
        Rent rent = new Rent(name,car,pick,ret);
        Rent temp = null;
        for(int i = 0; i <= _noOfRents; i++)
        {
            if(_rents[i] == null)//this place is free and the new rent can be inserted here
            {
                _rents[i] = rent;
                break;
            }
            if(rent.getPickDate().before(_rents[i].getPickDate()) || rent == temp)//if rent == temp, it means a rent has been moved already had to move
            {
                temp = _rents[i];
                _rents[i] = rent;
                rent = temp;
            }
        }
        _noOfRents++;
        return true;
    }

    /**
     * Removes a Rent that has the same return date as param d
     * lower the number of rents in the array by one
     * @param d the return date to be removed
     * @returns true if the rent was removed,otherwise false
     */
    public boolean removeRent(Date d)
    {
        if(_noOfRents == 0)
            return false;
        for(int i = 0; i < _noOfRents; i++)
        {
            if(_rents[i].getReturnDate().equals(d))
            {
                for(int j = i; j < _noOfRents-1; j++)
                {
                    _rents[j] = _rents[j+1];
                }
                _rents[_noOfRents-1] = null;
                _noOfRents--;
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the total price of all the rents in the array
     * @param sum the sum of the prices
     * @returns sum
     */
    public int getSumOfPrices()
    {
        int sum = 0;
        for(int i = 0; i < _noOfRents; i++)
        {
            sum += _rents[i].getPrice();
        }
        return sum;
    }

    /**
     * Calculates the total amount of days from all the rents in the array
     * @param sum the sum of the days
     * @returns sum
     */
    public int getSumOfDays()
    {
        int sum = 0;
        for(int i = 0; i < _noOfRents; i++)
        {
            sum += _rents[i].howManyDays();
        }
        return sum;
    }

    /**
     * Calculates the average days each rent in the array last
     * @returns 0 if the are no rents,otherwise returns the average days
     */
    public double averageRent()
    {
        if(_noOfRents == 0)
            return 0;
        return ((double)getSumOfDays()/_noOfRents);
    }

    /**
     * Checks which rent in the array has the last return date
     * @param last the rent with the last return date
     * @retuns null if there are no rents in the array,otherwise return the car in last
     */
    public Car lastCarRent()
    {
        if(_noOfRents == 0)
            return null;
        Rent last = new Rent(_rents[0]);
        for(int i = 1; i < _noOfRents; i++)
        {
            if(_rents[i].getReturnDate().after(last.getReturnDate()))
            {
                last = new Rent(_rents[i]);
            }
        }
        return last.getCar();
    }

    /**
     * Checks which rent in the array has the longest period
     * @param max the rent with the longest period
     * @returns null if there are no rents in the array,otherwise return max
     */
    public Rent longestRent()
    {
        if(_noOfRents == 0)
            return null;
        Rent max = new Rent(_rents[0]);
        for(int i = 1; i < _noOfRents; i++)
        {
            if(max.howManyDays() < _rents[i].howManyDays())
            {
                max = new Rent(_rents[i]);
            }
        }
        return max;
    }

    /**
     * Checks with car is the most common among the rents in the array
     * @param types an array that saves the types of cars
     * @param counters an array that counts how many times each type of car appeared
     * @param mostCommon indicates the most common car
     * @param index indicates the index of the car counter in the counters array
     * @returns 'N' if the are no rents in the array,otherwise return the most common car type
     */
    public char mostCommonRate()
    {
        if(_noOfRents == 0)
            return 'N';
        else if(_noOfRents == 1)
            return _rents[0].getCar().getType();
        char[] types = {'A','B','C','D'};//creates a new array of types to check
        int[] counters = {0,0,0,0};//creates a new array of counters to count each type respectively
        for(int i = 0; i < _noOfRents; i++)
        {
            switch(_rents[i].getCar().getType())
            {
                case 'A':
                    counters[0]++;
                    break;
                case 'B':
                    counters[1]++;
                    break;
                case 'C':
                    counters[2]++;
                    break;
                case 'D':
                    counters[3]++;
                    break;
                default:
                    break;
            }
        }
        int mostCommon = counters[0];
        int index = counters[0];
        for(int j = 0; j < counters.length; j++)
        {
            if(mostCommon > counters[j])
            {
                continue;
            }
            else if(mostCommon <= counters[j])
            {
                mostCommon = counters[j];
                index = j;
            }
        }
        return types[index];
    }

    /**
     * Return a String object that shows the total rents in the array
     * @param s the String that shows the number of rents in the array and what are they
     * @returns s
     */
    public String toString()
    {
        if(_noOfRents == 0)
            return ("The company has 0 rents.");
        String s = ("The company has " + _noOfRents + " rents:");
        for(int i = 0; i < _noOfRents; i++)
        {
            s += "\n" + _rents[i].toString();
        }
        return s;
    }
}