package ru.job4j.automaton;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * AutomatonTest.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class AutomatonTest {
    /*** Add coins.*/
    @Test
    public void whenAddCoinsThenQuantityOfCoinsIncreased() {
        Automaton automaton = new Automaton();
        automaton.addCoins(1, 10);
        assertThat(automaton.getCoinsQuantity(), is(new int[] {20, 10, 10, 10}));
    }
    /*** If less money for buy return string "Not enough money for buy!!!".*/
    @Test
    public void whenLessMoneyForBuyThenNotEnoughMoneyForBuy() {
        Automaton automaton = new Automaton();
        String result = automaton.buy(10, 5);
        assertThat(result, is("Not enough money for buy!!!"));
    }
    /*** If less coins in automaton for change return string "Not enough coins for change!!!".*/
    @Test
    public void whenLessCoinsForChangeThenNotEnoughCoinsForChange() {
        Automaton automaton = new Automaton();
        String result = automaton.buy(10, 10000);
        assertThat(result, is("Not enough coins for change!!!"));
    }
    /*** When something is bought return quantity of change.*/
    @Test
    public void whenBuyThenQuantityOfChange() {
        Automaton automaton = new Automaton();
        String result = automaton.buy(10, 100);
        assertThat(result, is("Change: 90"));
    }
}
