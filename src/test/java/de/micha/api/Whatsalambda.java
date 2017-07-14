package de.micha.api;

import org.junit.Test;


/**
 * Created by micha on 04.02.17.
 */
public class Whatsalambda {


    @Test
    public void playwithLambda() {


        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.print("my name is Lola an I am running");
            }
        };

        Runnable sugarRunnable = () -> System.out.print("I can run with sugar");

        Thread thread = new Thread(sugarRunnable);
        thread.start();
    }
























}

