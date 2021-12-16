public class Palindrome {

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> splits = wordToDeque(word);
        return helperIsPalindrome(splits, cc);
    }


    public Deque<Character> wordToDeque(String word) {
        Deque<Character> splits = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            splits.addLast(word.charAt(i));
        }
        return splits;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> splits = wordToDeque(word);
        return helperIsPalindrome(splits);
    }

    private boolean helperIsPalindrome(Deque<Character> H) {
        if (H.isEmpty() || H.size() == 1) {
            return true;
        } else if (H.removeLast() == H.removeFirst()) {
            return helperIsPalindrome(H);
        }
        return false;
    }

    private boolean helperIsPalindrome(Deque<Character> H, CharacterComparator cc) {
        if (H.isEmpty() || H.size() == 1) {
            return true;
        } else if (cc.equalChars(H.removeLast(), H.removeFirst())) {
            return helperIsPalindrome(H, cc);
        }
        return false;
    }

}
