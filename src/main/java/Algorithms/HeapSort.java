package Algorithms;

import HelperClasses.ReadFile;

import java.util.ArrayList;

public class HeapSort implements Algorithm {

    static int heap[];
    static int size;

    public HeapSort() {
    }

    public ArrayList<Integer> sort(ArrayList<Integer> values) {
        heap = new int[values.size()];
        int r = 0;
        for (Integer i : values) {
            size++;
            heap[r++] = i;
            bubbleUp();

        }
        ArrayList<Integer> out = new ArrayList<>(heap.length);
        for (int i : heap) {
            out.add(removeMin());
        }
        return out;
    }

    static void insert(int value) {
        heap[size++] = value;
        bubbleUp();
    }

    static void bubbleUp() {

        for (int i = size - 1; i > -1; i--) {
            if (heap[i] < heap[i / 2]) {
                int tmp = heap[i / 2];
                heap[i / 2] = heap[i];
                heap[i] = tmp;
            }
        }
    }

    static int removeMin() {

        int out = heap[0];
        heap[0] = heap[size - 1];
        size--;

        bubbleDown(0);

        return out;
    }

    static void bubbleDown(int idx) {
        int leftIdx = idx * 2 + 1;
        int rightIdx = idx * 2 + 2;
        int minIdx;

        if (rightIdx >= size) {
            if (leftIdx >= size) {
                return;
            } else {
                minIdx = leftIdx;
            }
        } else {
            if (heap[leftIdx] <= heap[rightIdx]) {
                minIdx = leftIdx;
            } else {
                minIdx = rightIdx;
            }
        }

        if (heap[idx] > heap[minIdx]) {
            int tmp = heap[idx];
            heap[idx] = heap[minIdx];
            heap[minIdx] = tmp;
            bubbleDown(minIdx);
        }
    }

    public static void main(String[] args) {

        ReadFile fr = new ReadFile();
        String file = fr.readTestFile(args[0]);
        ArrayList<Integer> values = fr.tokenizeList(file);
        new HeapSort().sort(values);

        while (size > 0) {
            System.out.println(removeMin());
        }

    }
}