package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {
    SimilarityFinder similarityFinder;
    SequenceSearcherDoubler sequenceSearcherDoublerSearcher;

    @Before
    public void setUp() throws Exception {
        sequenceSearcherDoublerSearcher = new SequenceSearcherDoubler();
        similarityFinder = new SimilarityFinder(sequenceSearcherDoublerSearcher);
    }

    @Test
    public void shouldReturnZeroIfThereAreNoSimilarities() {
        int[] seq1 = {1, 2, 3 ,4, 5};
        int[] seq2 = {6, 7 , 8, 9, 10};

        assertThat(0.0, is(similarityFinder.calculateJackardSimilarity(seq1, seq2)));
    }
}