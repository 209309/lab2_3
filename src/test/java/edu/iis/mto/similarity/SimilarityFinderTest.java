package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {
    SimilarityFinder similarityFinder;
    SequenceSearcherDoubler sequenceSearcherDoubler;
    int[] seq1;
    int[] seq2;

    @Before
    public void setUp() throws Exception {
        similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());
    }

    @Test
    public void shouldReturnZeroIfThereAreNoSimilarities() {
        seq1 = new int[]{1, 2, 3 ,4, 5};
        seq2 = new int[]{6, 7 , 8, 9, 10};

        assertThat(0.0, is(similarityFinder.calculateJackardSimilarity(seq1, seq2)));
    }

    @Test
    public void shouldReturnOneIfArraysAreTheSame() {
        seq1 = new int[]{1, 2, 3 ,4, 5};
        seq2 = new int[]{1, 2, 3 ,4, 5};

        assertThat(1.0, is(similarityFinder.calculateJackardSimilarity(seq1, seq2)));
    }

    @Test
    public void shouldReturnOneIfArraysAreEmpty() {
        seq1 = new int[]{};
        seq2 = new int[]{};

        assertThat(1.0, is(similarityFinder.calculateJackardSimilarity(seq1, seq2)));
    }

    @Test
    public void shouldReturnThreeIfThereAreThreeElementsEqual() {
        seq1 = new int[]{1, 2, 3, 6};
        seq2 = new int[]{1, 2, 3, 4};

        sequenceSearcherDoubler = new SequenceSearcherDoubler();
        similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);
        similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(3, is(sequenceSearcherDoubler.getCounter()));
    }
}