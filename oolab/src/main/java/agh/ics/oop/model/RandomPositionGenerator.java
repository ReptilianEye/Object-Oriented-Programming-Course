package agh.ics.oop.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    List<Vector2d> list;

    @Override
    public Iterator iterator() {
        return new CustomIterator();
    }

    public RandomPositionGenerator(int n) {
        int maxWidth = (int) sqrt(n * 10);
        int maxHeight = (int) sqrt(n * 10);
        long limit = (long) maxWidth * maxHeight;
        this.list = new ArrayList<>(n);
        Random rand = new Random();
        long step = limit / n;
        for (long i = 0; i < n; i++) {
            long next = step * i + rand.nextLong(step);
            this.list.add(new Vector2d((int) (next / maxWidth), (int) (next % maxHeight)));
        }
    }

    private class CustomIterator implements Iterator<Vector2d> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public Vector2d next() {
            return list.get(currentIndex++);
        }
    }
}

