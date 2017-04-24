import java.lang.Math;

public class test_functions {

    // Parameters
    public double Budweiser_Price = 3.0;
    public double Vodka_Cranberry_Price = 4.0;
    public double Sweet_Water_Price = 5.0;

    // Variables in the Model
    public double Budweiser_COGS = 1.0;
    public double Vodka_Cranberry_COGS = 1.5;
    public double Sweet_Water_COGS = 2.0;

    public double Budweiser_Base_Price = 3.0;
    public double Vodka_Cranberry_Base_Price = 4.0;
    public double Sweet_Water_Base_Price = 5.0;

    public double Budweiser_Probability = .33;
    public double Vodka_Cranberry_Probability = .33;
    public double Sweet_Water_Probability = .33;

    public int Budweiser_Sold = 0;
    public int Vodka_Cranberry_Sold = 0;
    public int Sweet_Water_Sold = 0;

    public double total_profit = 0;
    public double vDrinksSold = 0;

    // call this everytime a drink is sold
    public static void add_drink() {

        double randnum = Math.random();
        int quantity = triangular(1,2,3);

        vDrinksSold += quantity;

        if (randnum < Budweiser_Probability){
            Budweiser_Sold += quantity;
            add_to_profit(0, quantity)
        } else if (randnum > (1 - Vodka_Cranberry_Probability)) {
            Vodka_Cranberry_Sold += quantity;
            add_to_profit(1, quantity)
        } else {
            Sweet_Water_Sold += quantity;
            add_to_profit(2, quantity)
        }

    }

    // helper function to add drink
    public static void add_to_profit(int type_of_drink, int quatitiy){
        double dollars_to_add = 0;

        switch(type_of_drink){
            case 0:
                dollars_to_add = (Budweiser_Price - Budweiser_COGS) * quatitiy;
                break;
            case 1;
                dollars_to_add = (Vodka_Cranberry_Price - Vodka_Cranberry_COGS) * quatitiy;
                break;
            case 2;
                dollars_to_add = (Sweet_Water_Price - Sweet_Water_COGS) * quatitiy;
                break;
        }
        total_profit += dollars_to_add;
    }


    // Called at Beginning of Run
    public static void set_probabilites_based_on_prices() {

        double base_prob = .33333333

        double bw_price_diff_percent = Budweiser_Price / Budweiser_Base_Price;
        double vc_price_diff_percent = Vodka_Cranberry_Price / Vodka_Cranberry_Base_Price;
        double sw_price_diff_percent = Sweet_Water_Price / Sweet_Water_Base_Price;

        if (bw_price_diff_percent > 2) {bw_price_diff_percent = 2}
        if (vc_price_diff_percent > 2) {vc_price_diff_percent = 2}
        if (sw_price_diff_percent > 2) {sw_price_diff_percent = 2}

        Budweiser_Probability = (2 - bw_price_diff_percent) * base_prob;
        Vodka_Cranberry_Probability = (2 - vc_price_diff_percent) * base_prob;
        Sweet_Water_Probability = (2 - sw_price_diff_percent) * base_prob;

        double new_total = Budweiser_Probability + Vodka_Cranberry_Probability + Sweet_Water_Probability;

        Budweiser_Probability /= new_total;
        Vodka_Cranberry_Probability /= new_total;
        Sweet_Water_Probability /= new_total;
    }

    // Called on the schedule modifier
    public static double get_customer_arrival_rate_modifier() {

        double base_total = Budweiser_Base_Price + Sweet_Water_Base_Price + Vodka_Cranberry_Base_Price;
        double new_total = Budweiser_Price + Sweet_Water_Price + Vodka_Cranberry_Price;
        double percent_change = new_total / base_total;

        if (percent_change > 2) {percent_change = 2}

        return 2 - percent_change

    }

    // No-op just to make the compiler happy
    public static double triangular(a,b,c)

}