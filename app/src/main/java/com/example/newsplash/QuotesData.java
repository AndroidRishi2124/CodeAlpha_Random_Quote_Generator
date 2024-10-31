package com.example.newsplash;

import java.util.ArrayList;
import java.util.List;

public class QuotesData {
    public static List<QuotesList> getLifeQuotes(){
        final List<QuotesList> lifeQuotesList = new ArrayList<>();

        QuotesList lifeQuote1 = new QuotesList("life is mountain","abc");
        lifeQuotesList.add(lifeQuote1);

        QuotesList lifeQuote2 = new QuotesList("health,wealth,love","efg");
        lifeQuotesList.add(lifeQuote2);

        QuotesList lifeQuote3 = new QuotesList("Life is from the inside out","zld");
        lifeQuotesList.add(lifeQuote3);

        QuotesList lifeQuote4 = new QuotesList("Life is a race","me");
        lifeQuotesList.add(lifeQuote4);

        /*
        can add more quotes
         */
        return lifeQuotesList;
    }
    public static List<QuotesList> getSuccessQuotes(){

        final List<QuotesList> SuccessQuotesList = new ArrayList<>();
        QuotesList SuccessQuote4 = new QuotesList("every day is a new opportunity","man");
        SuccessQuotesList.add(SuccessQuote4);

        return SuccessQuotesList;
    }

    public static List<QuotesList> getEnglishQuotes(){

        final List<QuotesList> EnglishQuotesList = new ArrayList<>();
        QuotesList EnglishQuote4 = new QuotesList("Every man deserves a day to rest sunday","boy");
        EnglishQuotesList.add(EnglishQuote4);

        return EnglishQuotesList;
    }

    public static List<QuotesList> getMotivationalQuotes(){

        final List<QuotesList> MotivationalQuotesList = new ArrayList<>();
        QuotesList MotivationalQuote4 = new QuotesList("Every man deserves a day to rest sunday","boy");
        MotivationalQuotesList.add(MotivationalQuote4);

        return MotivationalQuotesList;
    }

    public static List<QuotesList> getLoveQuotes(){

        final List<QuotesList> LoveQuotesList = new ArrayList<>();
        QuotesList LoveQuote4 = new QuotesList("143","nae");
        LoveQuotesList.add(LoveQuote4);

        return LoveQuotesList;
    }


}
