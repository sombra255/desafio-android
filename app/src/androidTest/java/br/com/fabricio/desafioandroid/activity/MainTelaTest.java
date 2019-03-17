package br.com.fabricio.desafioandroid.activity;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Fabricio on 16/03/2019.
 */
public class MainTelaTest {

    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void carregarListaVoos(){
        onView(withText("841.11"))
                .check(matches(isDisplayed()));
    }

    @Test
    public void verificaTituloIda(){
        onView(withText("VOO DE IDA"))
                .check(matches(isDisplayed()));
    }

    @Test
    public void verificaTituloVolta(){
        onView(withText("VOO DE VOLTA"))
                .check(matches(isDisplayed()));
    }

}