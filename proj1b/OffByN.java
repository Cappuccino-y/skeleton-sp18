public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int M) {
        N = M;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == N) {
            return true;
        }
        return false;
    }

}
