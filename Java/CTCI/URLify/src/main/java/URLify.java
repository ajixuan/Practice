public class URLify {
    private int len = 0;
    private char[] space = {'%', '2', '0'};
    class Word {
        public Word next;
        public char[] arr;
    }

    public String convert(String url) {
        Word curr = buildWords(url);
        char[] result = new char[this.len];
        int i = 0;
        while (curr.next != null) {
            System.arraycopy(curr.arr, 0, result, i, curr.arr.length);
            i += curr.arr.length ;
            System.arraycopy(space, 0, result, i, space.length);
            i += space.length;
            curr = curr.next;
        }

        System.arraycopy(curr.arr, 0, result, i, curr.arr.length);
        return new String(result);
    }

    public Word buildWords(String url) {
        Word words = new Word();
        Word curr = words;

        char[] arr = url.trim().toCharArray();
        int blank = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                curr.arr = this.subArr(blank, i - 1, arr);
                this.len += space.length + curr.arr.length;
                curr.next = new Word();
                curr = curr.next;
                blank = i + 1;
            }
        }
        curr.arr = this.subArr(blank, arr.length - 1, arr);
        this.len += curr.arr.length;
        return words;
    }


    public char[] subArr(int start, int end, char[] arr) {
        char[] result = new char[end - start + 1];
        for (int i = 0; i < result.length; i++, start++) {
            result[i] = arr[start];
        }

        return result;
    }

}
