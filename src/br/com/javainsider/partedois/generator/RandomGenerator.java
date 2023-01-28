package br.com.javainsider.partedois.generator;

import java.util.Random;

public class RandomGenerator implements Generator{
    private Random random = new Random();

    @Override
    public int next() {
        return random.nextInt(1, 10);
    }
}
