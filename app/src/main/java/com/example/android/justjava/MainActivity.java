package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incrementOrder(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
       boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
       // Log.v("MainActivity", "Has wipped cream:" + hasWhippedCream);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText getEditableText = (EditText) findViewById(R.id.nameTextView);
        String getName = getEditableText.getText().toString();
        //Log.v("MainActivity", "Name: " + getName);

        int price = calculatePrice();
        //String priceMessage = createOrderSummary(price);
        //String priceMessage = "Total= $" + price + "\n" + drinkOfTheDay;
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate,getName));



    }



    /**
     *@return total price
     */
    private int calculatePrice(){
        return quantity * 5;
    }

    /**
     *
     * @param price of the order
     * @param addWhippedCream is wheter or not the user wants whipped cream topping
     * @param hasChocolate is wheter or not the user wants chocolate topping
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean hasChocolate, String getName){

        String priceMessage = "Name: " + getName ;
        priceMessage += "\nAdd Whipped cream? = " + addWhippedCream;
        priceMessage += "\nAdd chocolate? = " + hasChocolate;
        priceMessage += "\nQuantity: " + quantity ;
        priceMessage += "\nTotal= $" + price ;
        priceMessage += "\nThank You!";


        return priceMessage;

    }

    /*
     * This method decrement the quantity order
     */


    public void decrement(View view) {

        quantity = quantity -1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffes) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffes);
    }

    /**

    /*
    * This method displays the given text on the screen.
     */
    private void displayMessage(String message ){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
