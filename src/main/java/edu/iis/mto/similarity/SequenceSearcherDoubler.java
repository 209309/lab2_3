package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private int counter = 0;

    @Override
    public SearchResult search(int elem, int[] seq) {
        Builder builder = SearchResult.builder();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == elem) {
                counter = getCounter() + 1;
                return builder.withFound(true).withPosition(i).build();
            }
        }
        return builder.withFound(false).build();
    }

    public int getCounter() {
        return counter;
    }
}
