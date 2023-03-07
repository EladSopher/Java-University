import java.util.*;
/**
 * This class represents a Rent object
 *
 * @author Elad Sopher
 * @version 12/12/22
 */
public class Rent
{
    private static final int MIN_DAY = 1;
    private static final int TYPE_A_PRICE = 100;
    private static final int TYPE_B_PRICE = 150;
    private static final int TYPE_C_PRICE = 180;
    private static final int TYPE_D_PRICE = 240;
    private static final double FULL_WEEK_DISCOUNT = 0.9;
    private static final int WEEK = 7;

    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;

    /**
     * Creates a new Rent object
     * @param name the name of the person that rented the car
     * @param car the car that was rented from class Car
     * @param pickDate the date the rent started - from class Date
     * @param returnDate the date the rent ends - from class Date
     */
    public Rent(String name,Car car,Date pick,Date ret)
    {
        _name = name;
        _car = new Car(car);
        _pickDate = new Date(pick);
        _returnDate = (pick.difference(ret) < MIN_DAY) ? pick.tomorrow() : new Date(ret);
    }

    /**
     * Copy constructor
     * @param other the rent to be copied
     */
    public Rent(Rent other)
    {
        _name = other._name;
        _car = new Car(other._car);
        _pickDate = new Date(other._pickDate);
        _returnDate = new Date(other._returnDate);
    }

    /**
     * Gets the name
     * @returns the name
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Gets the car
     * @returns the car
     */
    public Car getCar()
    {
        return new Car(_car);
    }

    /**
     * Gets the pick up date
     * @returns the pick up date
     */
    public Date getPickDate()
    {
        return new Date(_pickDate);
    }

    /**
     * Gets the return date
     * @returns the return date
     */
    public Date getReturnDate()
    {
        return new Date(_returnDate);
    }

    /**
     * Sets the client name
     * @param name the name to be set
     * You can assume that the name is a valid name
     */
    public void setName(String name)
    {
        _name = name;
    }

    /**
     * Sets the rented car
     * @param car the car to be set
     * You can assume that car is not null
     */
    public void setCar(Car car)
    {
        _car = new Car(car);
    }

    /**
     * Sets the pick up date
     * @param pickDate the date to be set
     * You can assume that pick up date is not null
     */
    public void setPickDate(Date pick)
    {
        _pickDate = new Date(pick);
    }

    /**
     * Sets the return date
     * @param returnDate the date to be set
     * You can assume that return date is not null
     */
    public void setReturnDate(Date ret)
    {
        _returnDate = new Date(ret);
    }

    /**
     * Check if 2 rents are the same
     * @param other the rent to compare this rent to
     * @returns true if the rents are the same,otherwise false
     */
    public boolean equals(Rent other)
    {
        return (_name.equals(other._name) && _car.equals(other._car) && _pickDate.equals(other._pickDate) && _returnDate.equals(other._returnDate));
    }

    /**
     * Returns the number of rent days
     * @returns the number of rent days
     */
    public int howManyDays()
    {
        return (_pickDate.difference(_returnDate));
    }

    /**
     * Returns the total price of the rent
     * @returns the rent total price
     */
    public int getPrice()
    {
        int price = 0;
        int wholeWeeks = _pickDate.difference(_returnDate) / WEEK;
        int singleDays = _pickDate.difference(_returnDate) % WEEK;
        switch(_car.getType())
        {
            case 'A':
                price = (int)((wholeWeeks * WEEK * TYPE_A_PRICE * FULL_WEEK_DISCOUNT) + (singleDays * TYPE_A_PRICE));
                return price;
            case 'B':
                price = (int)((wholeWeeks * WEEK * TYPE_B_PRICE * FULL_WEEK_DISCOUNT) + (singleDays * TYPE_B_PRICE));
                return price;
            case 'C':
                price = (int)((wholeWeeks * WEEK * TYPE_C_PRICE * FULL_WEEK_DISCOUNT) + (singleDays * TYPE_C_PRICE));
                return price;
            case 'D':
                price = (int)((wholeWeeks * WEEK * TYPE_D_PRICE * FULL_WEEK_DISCOUNT) + (singleDays * TYPE_D_PRICE));
                return price;
            default:
                return price;
        }
    }

    /**
     * Try to upgrade the car to a better car
     * If the given car is better than the current car of the rent, upgrade it and return the upgrade additional cost
     * otherwise - don't upgrade
     * @param car the car to upgrade to
     * @returns the upgrade cost
     */
    public int upgrade(Car newCar)
    {
        if(_car.better(newCar))
        {
            return 0;
        }
        int oldPrice = getPrice();
        _car = new Car(newCar);
        int newPrice = getPrice();
        return newPrice - oldPrice;
    }

    /**
     * Returns a String object that represents this rent
     *
     * @return String that represents this rent in the following format:
     * <BR>Name:Elad From:29/11/22 To:01/12/22 Type:A Days:2 Price:200
     */
    public String toString()
    {
        return ("Name:" + _name + " From:" + _pickDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice());
    }
}//end of Class Rent
