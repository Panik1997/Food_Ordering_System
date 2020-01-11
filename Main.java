import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void addItalianMeal(Lunch obj, Lunch[] obj1, int n){
        obj1[n] = obj;
    }

    public static void addPolishMeal(Lunch obj, Lunch[] obj1, int n){
        obj1[n] = obj;
    }

    public static void addMexicanMeal(Lunch obj, Lunch[] obj1, int n){
        obj1[n] = obj;
    }

    public static void addToOrder(Lunch obj, Lunch[] obj1, int n){
        obj1[n] = obj;
    }

    public static void addDrinkToOrder(Drinks obj, Drinks[] obj1, int n){
        obj1[n] = obj;
    }

    public static void addInfo(String str, String[] str1, int n){
        str1[n] = str;
    }
    
    //I know few methods above work the same, but I've created them to let the code be cleaner

    public static void addToFile(Lunch obj, int n){
        try {
            File file = new File("order.txt");
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write(n + ". " + obj.lunch_name + " " + obj.lunch_price + " PLN\n");
            filewriter.close();
        }
            catch (IOException e){
            System.out.println(e);
        }
    }

    public static void addDrinksToFile(Drinks obj, int n){
        try {
            File file = new File("order.txt");
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write(n + ". " + obj.name_of_drink + " " + obj.price_of_drink + " PLN\n");
            filewriter.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static void addPriceToFile(double k){
        try {
            File file = new File("order.txt");
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write("------------------------------------\n" + "Sum: " + k + " PLN" + "\n------------------------------------");
            filewriter.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static void addInfoToFile(String str){
        try {
            File file = new File("order.txt");
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write( "\n" + str);
            filewriter.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static void addInfNote(){
        try {
            File file = new File("order.txt");
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write( "\nAdditional Informations");
            filewriter.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Restaurant!");
        int number;
        int number1;
        int n, l;
        int k = 1;
        int j = 0;
        int m = 0;
        int o = 0;
        boolean check = true;
        Scanner num = new Scanner(System.in);
        double bill1 = 0;

        // If you want add new meal to menu, just create another object 
        // of type Lunch in array "meals" and add +1 to index.
        
        Lunch[] meals = new Lunch[9];
        Lunch[] italianFoodArray = new Lunch[100];
        Lunch[] polishFoodArray = new Lunch[100];
        Lunch[] mexicanFoodArray = new Lunch[100];
        Lunch[] orderArray = new Lunch[100];
        Drinks[] drinks = new Drinks[5];
        Drinks[] drinksOrder = new Drinks[100];

        meals[0] = new Lunch("Italian",  "Pizza Margheritta", 25);
        meals[1] = new Lunch("Italian", "Spaghettii Bolognese", 30);
        meals[2] = new Lunch("Polish", "Bigos", 21.5);
        meals[3] = new Lunch("Polish", "Pierogi ruskie", 15);
        meals[4] = new Lunch("Mexican", "Chile Relleno", 23);
        meals[5] = new Lunch("Mexican", "Burrito", 27);
        meals[6] = new Lunch("Polish", "Schabowy z ziemniakami", 20);
        meals[7] = new Lunch("Italian", "Pasta", 15);
        meals[8] = new Lunch("Mexican", "Guacamole", 18);

        drinks[0] = new Drinks("Pepsi 1l", 10.5);
        drinks[1] = new Drinks("Beer 0.5 l", 8.3);
        drinks[2] = new Drinks("Mineral water 1l", 7.8);
        drinks[3] = new Drinks("Sprite 1l", 11);
        drinks[4] = new Drinks("Coca-cola 0.5l", 8.1);
        String[] info = new String[100];


        while (check) {

            System.out.println("Choose cuisine:\n  1. Italian\n  2. Polish\n  3. Mexican\n  4. Check order\n  5. Clean order\n  6. Cancel order (ignores what has already been ordered and " +
                    "closes the order)\n  7. Finish order (writes data to .txt file, so it can be printed as a receipt)\n");
            number = num.nextInt();
            if(number <= 7 && number>0){
                switch(number){

                    case 1:
                        l=0;
                        n = 0;
                        System.out.println("Which meal do you want to buy?\n");
                        for(int i = 0 ; i < meals.length ; i++){
                            if(meals[i].getCountry_name().equals("Italian") ){
                                System.out.println(n+1 + ". " + meals[i].lunch_name + ", Price: " + meals[i].lunch_price + " PLN");
                                addItalianMeal(meals[i], italianFoodArray, n);
                                n++;
                            }
                        }

                        number1 = num.nextInt();
                        if(number1 > n || number1 <= 0){
                            System.out.println("Wrong meal!");
                            break;
                        } else {
                            System.out.println("You have chosen: \n" + italianFoodArray[number1 - 1].lunch_name + ", Price: " + italianFoodArray[number1 - 1].lunch_price + " PLN");
                            addToOrder(italianFoodArray[number1 - 1], orderArray, j);
                            j++;
                            System.out.println("-------------------------------------------------------------------------");
                        }
                        System.out.println("Something to drink? (1. yes/2. no)");

                        int number2 = num.nextInt();
                        if(number2 == 1){
                            System.out.println("Choose drink: ");
                            for(int i = 0; i < drinks.length ; i++){
                                System.out.println(i+1 + ". " + drinks[i].name_of_drink + ", Price: " + drinks[i].price_of_drink + " PLN");
                            }
                            int number3 = num.nextInt();
                            if(number3 > drinks.length || number3 <= 0){
                                System.out.println("Wrong drink!!!");
                                break;
                            } else {
                                System.out.println("You have chosen: \n" + drinks[number3 - 1].name_of_drink + ", Price: " + drinks[number3 - 1].price_of_drink + " PLN\n");
                                addDrinkToOrder(drinks[number3-1], drinksOrder, m);
                                m++;

                                System.out.println("Do you want ice cubes or lemon?\n 1. Lemon\n 2. Ice cubes\n 3. Both\n 4. Nothing, thank you");
                                int number7 = num.nextInt();
                                if(number7 == 1){
                                    System.out.println(drinks[number3 - 1].name_of_drink + " with Lemon");
                                    addInfo(drinks[number3 - 1].name_of_drink + " with Lemon", info, o);
                                    o++;
                                } else if(number7 == 2){
                                    System.out.println(drinks[number3 - 1].name_of_drink + " with Ice Cubes");
                                    addInfo(drinks[number3 - 1].name_of_drink + " with Ice Cubes", info, o);
                                    o++;
                                } else if(number7 == 3){
                                    System.out.println(drinks[number3 - 1].name_of_drink + " with Lemon and Ice Cubes");
                                    addInfo(drinks[number3 - 1].name_of_drink + " with Lemon and Ice Cubes", info, o);
                                    o++;
                                }
                                System.out.println("-------------------------------------------------------------------------");
                            }
                        }
                        break;


                    case 2:
                        l=0;
                        n=0;
                        for(int i = 0 ; i < meals.length ; i++){
                            if(meals[i].getCountry_name().equals("Polish") ){
                                System.out.println(n+1 + ". " + meals[i].lunch_name + " Price: " + meals[i].lunch_price + " PLN");
                                addPolishMeal(meals[i], polishFoodArray, n);
                                n++;
                            }
                        }

                        number1 = num.nextInt();
                        if(number1 > n || number1 <= 0){
                            System.out.println("Wrong meal!");
                            break;
                        } else {
                            System.out.println("You have chosen: \n" + polishFoodArray[number1 - 1].lunch_name + ", Price: " + polishFoodArray[number1 - 1].lunch_price + " PLN");
                            addToOrder(polishFoodArray[number1 - 1], orderArray, j);
                            j++;
                            System.out.println("-------------------------------------------------------------------------");
                        }
                        System.out.println("Something to drink? (1. yes/2. no)");

                        int number4 = num.nextInt();
                        if(number4 == 1){
                            System.out.println("Choose drink: ");
                            for(int i = 0; i < drinks.length ; i++){
                                System.out.println(i+1 + ". " + drinks[i].name_of_drink + ", Price: " + drinks[i].price_of_drink + " PLN");
                            }
                            int number3 = num.nextInt();
                            if(number3 <= drinks.length && number3 > 0){
                                System.out.println("You have chosen: \n" + drinks[number3 - 1].name_of_drink + ", Price: " + drinks[number3 - 1].price_of_drink + " PLN\n");
                                addDrinkToOrder(drinks[number3 - 1], drinksOrder, m);
                                m++;

                                System.out.println("Do you want ice cubes or lemon?\n 1. Lemon\n 2. Ice cubes\n 3. Both\n 4. Nothing, thank you");
                                int number7 = num.nextInt();
                                if(number7 == 1){
                                    System.out.println(drinks[number3 - 1].name_of_drink + " with Lemon");
                                    addInfo(drinks[number3 - 1].name_of_drink + " with Lemon", info, o);
                                    o++;
                                } else if(number7 == 2){
                                    System.out.println(drinks[number3 - 1].name_of_drink + " with Ice Cubes");
                                    addInfo(drinks[number3 - 1].name_of_drink + " with Ice Cubes", info, o);
                                    o++;
                                } else if(number7 == 3){
                                    System.out.println(drinks[number3 - 1].name_of_drink + " with Lemon and Ice Cubes");
                                    addInfo(drinks[number3 - 1].name_of_drink + " with Lemon and Ice Cubes", info, o);
                                    o++;
                                }
                                System.out.println("-------------------------------------------------------------------------");
                            } else {
                                System.out.println("Wrong drink!!!");
                            }
                        }
                        break;

                    case 3:
                        l=0;
                        n=0;
                        for(int i = 0 ; i < meals.length ; i++){
                            if(meals[i].getCountry_name().equals("Mexican") ){
                                System.out.println(n+1 + ". " + meals[i].lunch_name + " Price: " + meals[i].lunch_price + " PLN");
                                addMexicanMeal(meals[i], mexicanFoodArray, n);
                                n++;
                            }
                        }

                        number1 = num.nextInt();
                        if(number1 > n || number1 <= 0){
                            System.out.println("Wrong meal!");
                            break;
                        } else {
                            System.out.println("You have chosen: \n" + mexicanFoodArray[number1 - 1].lunch_name + ", Price: " + mexicanFoodArray[number1 - 1].lunch_price);
                            addToOrder(mexicanFoodArray[number1 - 1], orderArray, j);
                            j++;
                            System.out.println("-------------------------------------------------------------------------");
                        }
                        System.out.println("Something to drink? (1. yes/2. no)");

                        int number5 = num.nextInt();
                        if(number5 == 1){
                            System.out.println("Choose drink: ");
                            for(int i = 0; i < drinks.length ; i++){
                                System.out.println(i+1 + ". " + drinks[i].name_of_drink + ", Price: " + drinks[i].price_of_drink + " PLN");
                            }
                            int number6 = num.nextInt();
                            if(number6 <= drinks.length && number6 > 0){
                                System.out.println("You have chosen: \n" + drinks[number6 - 1].name_of_drink + ", Price: " + drinks[number6 - 1].price_of_drink + " PLN\n");
                                addDrinkToOrder(drinks[number6 - 1], drinksOrder, m);
                                m++;

                                System.out.println("Do you want ice cubes or lemon?\n 1. Lemon\n 2. Ice cubes\n 3. Both\n 4. Nothing, thank you");
                                int number7 = num.nextInt();
                                if(number7 == 1){
                                    System.out.println(drinks[number6 - 1].name_of_drink + " with Lemon");
                                    addInfo(drinks[number6 - 1].name_of_drink + " with Lemon", info, o);
                                    o++;
                                } else if(number7 == 2){
                                    System.out.println(drinks[number6 - 1].name_of_drink + " with Ice Cubes");
                                    addInfo(drinks[number6 - 1].name_of_drink + " with Ice Cubes", info, o);
                                    o++;
                                } else if(number7 == 3){
                                    System.out.println(drinks[number6 - 1].name_of_drink + " with Lemon and Ice Cubes");
                                    addInfo(drinks[number6 - 1].name_of_drink + " with Lemon and Ice Cubes", info, o);
                                    o++;
                                }
                                System.out.println("-------------------------------------------------------------------------");
                            } else {
                                System.out.println("Wrong drink!!!");
                            }
                        }
                        break;

                    case 4:
                        int tmp = 1;
                        double bill = 0;
                        if(orderArray[0] == null){
                            System.out.println("Your order is empty!!!");
                            break;
                        } else {
                            for (int i = 0; i < j; i++) {
                                System.out.println(tmp + ". " + orderArray[i].lunch_name + " " + orderArray[i].lunch_price + " PLN");
                                bill = bill + orderArray[i].lunch_price;
                                tmp++;
                            }
                            for (int i = 0; i < m ; i++) {
                                System.out.println(tmp + ". " + drinksOrder[i].name_of_drink + " " + drinksOrder[i].price_of_drink + " PLN");
                                bill = bill + drinksOrder[i].price_of_drink;
                                tmp++;
                            }

                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("To pay: " + bill + " PLN");
                            System.out.println("-------------------------------------------------------------------------\n");

                            System.out.println("\nAdditional informations:\n");
                            for(int i = 0; i < o; i++){
                                System.out.println(info[i]);
                            }
                            System.out.println("-------------------------------------------------------------------------\n");
                        }
                        break;

                    case 5:
                        Arrays.fill(orderArray, null);
                        Arrays.fill(drinks, null);
                        Arrays.fill(info, null);
                        break;

                    case 6:
                        check = false;
                        break;

                    case 7:
                        try{
                            PrintWriter pw = new PrintWriter("order.txt");
                        } catch (FileNotFoundException e){
                            System.out.println(e);
                        }

                        try {
                            for(int i = 0 ; i < j ; i++){
                                addToFile(orderArray[i], k++);
                            }
                            for(int i = 0 ; i < m ; i++){
                                addDrinksToFile(drinksOrder[i], k++);
                            }
                        } catch (InputMismatchException e){
                            System.out.println(e);
                        }

                        try{
                            double price = 0;
                            for(int i = 0; i < j ; i++){
                                price = price + orderArray[i].lunch_price;
                            }
                            for(int i = 0; i < m ; i++){
                                price = price + drinksOrder[i].price_of_drink;
                            }
                            addPriceToFile(price);
                        } catch (InputMismatchException e){
                            System.out.println(e);
                        }

                        try{
                                addInfNote();
                        } catch (InputMismatchException e){
                            System.out.println(e);
                        }

                        try{
                            for(int i = 0; i < o; i++){
                                addInfoToFile(info[i]);
                            }
                        } catch (InputMismatchException e){
                            System.out.println(e);
                        }

                        check = false;
                        break;
                }
            } else {
                System.out.println("Wrong option!");
            }
        }
    }
}
