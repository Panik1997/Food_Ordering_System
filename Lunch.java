public class Lunch extends Country{
    String lunch_name;
    double lunch_price;

    public Lunch(String country_name, String lunch_name, double lunch_price){
        super(country_name);
        this.lunch_name = lunch_name;
        this.lunch_price = lunch_price;
    }

    String getLunch_name(){
        return lunch_name;
    }

    double getLunch_price(){
        return lunch_price;
    }
}