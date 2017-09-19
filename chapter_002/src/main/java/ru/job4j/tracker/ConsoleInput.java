package ru.job4j.tracker;

import java.util.Scanner;
/**
 * Console input.
 * @author Aleksandr Shigin
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /*** Scanner.*/
    private Scanner scanner = new Scanner(System.in);
    /**
     * Ask.
     * @param question - question
     * @return scanner
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}

