/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;

class DrivableTrader extends Trader implements Drivable{

    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    public DrivableTrader(int money) {
        super(money);
    }

    public int getSellingPrice(Drivable d) {
        if (d instanceof Tradable) {
            return ((Tradable) d).getPrice() + d.getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }

    @Override
    public void upgradeSpeed() {
        for (Object d : getInventory()) {
            ((Drivable) d).upgradeSpeed();
        }
    }

    @Override
    public void downgradeSpeed() {
        for (Object d : getInventory()) {
            ((Drivable) d).downgradeSpeed();
        }
    }

    @Override
    public int getMaxSpeed() {
        int max = 0;
        for (Object d : getInventory()) {
            if (((Drivable) d).getMaxSpeed() > max) {
                max = ((Drivable) d).getMaxSpeed();
            }
        }
        return max;
    }

}
