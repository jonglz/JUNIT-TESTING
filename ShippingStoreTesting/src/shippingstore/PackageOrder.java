package shippingstore;

/**
 * 
 * @author Jonathan Gonzalez
 * Package Class - Super class for sub class Postcard, Letter,
 * Envelope, Packet, Box, Crate,Drum, Roll, Tube.
 *
 */
public class PackageOrder {

    private final String trackingnumber;
    private final String type;
    private final String specification;
    private final String mailingclass;
    private final float weight;
    private final int volume;

	/**
	 * Constructor Fields
	 * @param trackingNumber A string of length 5
	 * @param type A Postcard, Letter, Envelope, Packet, Box, Crate,
	 * Drum, Roll, or Tube. 
	 * @param specification Fragile, Books, Catalogs, Do-not-Bend or N/A
	 * @param mailingClass  First-Class, Priority, Retail, Ground, Metro.
	 * @param weight In oz
	 * @param volume L*W*H
	 */
    public PackageOrder(String trackingnumber, String type, String specification, String mailingclass, float weight, int volume) {
        this.trackingnumber = trackingnumber;
        this.type = type;
        this.specification = specification;
        this.mailingclass = mailingclass;
        this.weight = weight;
        this.volume = volume;
    }

    /**
     * This method returns the package order's tracking number.
     *
     * @return tracking number of the package order.
     */
    public String getTrackingNumber() {
        return trackingnumber;
    }

    /**
     * This method returns the package order's type.
     *
     * @return package order's type.
     */
    public String getType() {
        return type;
    }

    /**
     * This method returns the package order's specification.
     *
     * @return package order's specification.
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * This method returns the package order's mailing class.
     *
     * @return package order's mailing class
     */
    public String getMailingClass() {
        return mailingclass;
    }

    /**
     * This method returns the package's weight.
     *
     * @return the package's weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * This method returns the package's volume.
     *
     * @return  package's volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * This method returns the package order's fields as a string representation.
     *
     * @return fields of the package order
     */
    @Override
    public String toString() {
        return trackingnumber + " " + type + " " + specification + " " + mailingclass + " "
        		+ String.format("%.2f", weight) + " " + volume + "\n";
    }

    /**
     * This method provides a way to compare two package order objects.
     *
     * @param c an object that is used to compare to
     * this package order. Two orders are equal if their TrackingNumber is the
     * same.
     * @return value of the comparison.
     */
    public boolean equals(PackageOrder c) {
        return c.getTrackingNumber().equals(this.trackingnumber);
    }

}
