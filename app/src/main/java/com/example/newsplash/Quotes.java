package com.example.newsplash;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Quotes extends AppCompatActivity {

    private TextView quoteTxt,writername;
    private final List<QuotesList> quotesLists = new ArrayList<>();
    /*quote position in quote list
    * increment when user click the next button
    * decrement when user click prev button
    * */
    private int currentQuotePosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quotes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView categoryName = findViewById(R.id.categoryName);
        quoteTxt = findViewById(R.id.quotetext);
        writername = findViewById(R.id.writername);

        final Button prevBtn = findViewById(R.id.prevBtn);
        final Button nextBtn = findViewById(R.id.nextBtn);
        final ImageView copyBtn = findViewById(R.id.copybtn);

        //get category name  from  categoriesAdapter class

        final String getName = getIntent().getStringExtra("name");

        //set category name  to TextView
        categoryName.setText(getName);

        // check category name(getName) and  get  quotes corresponds  to the category  name
        if(getName.equals("Life")){
            //get life quotes from quotesdata class
            quotesLists.addAll(QuotesData.getLifeQuotes());
        } else if (getName.equals("Success")) {
            //get success quotes   from quotesdata class
            quotesLists.addAll(QuotesData.getSuccessQuotes());
        }
        else if (getName.equals("Motivation")) {
            //get motivation quotes   from quotesdata class
            quotesLists.addAll(QuotesData.getMotivationalQuotes());
        }
        else if (getName.equals("English")) {
            //get english quotes   from quotesdata class
            quotesLists.addAll(QuotesData.getEnglishQuotes());
        }
        else if (getName.equals("Love")) {
            //get
            // love quotes   from quotesdata class
            quotesLists.addAll(QuotesData.getLoveQuotes());
        }

        //check your own quotes here
        /*get first quote from quotelist and set to text view
        * currentquoteposition is zero by default so first quote will be  set to Textview
        * */
        setQuoteToTextView();



        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //decrement currentquoteposition to get  previous quote from quotelists
                currentQuotePosition--;
                //if currentquoteposition is smallerthan 0 then get last quote from quotelists
                if(currentQuotePosition < 0 ){
                    currentQuotePosition = quotesLists.size()-1;
                }
                setQuoteToTextView();
            }
        });

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //copy to clip board
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("quote", quotesLists.get(currentQuotePosition).getQuote()+"\nby "+quotesLists.get(currentQuotePosition).getWriter());
                clipboardManager.setPrimaryClip(clipData);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //increment current position to get nxet quote from the list
                currentQuotePosition++;
                //check if more quotes are available if the quotelist .
                if(currentQuotePosition>=quotesLists.size()){
                    currentQuotePosition=0;
                }
            }
        });
    }

    private void setQuoteToTextView() {
        //get quote from the list from current quote position
        quoteTxt.setText(quotesLists.get(currentQuotePosition).getQuote());

        //get writer from the list from current quote position
        writername.setText(quotesLists.get(currentQuotePosition).getQuote());
    }
}