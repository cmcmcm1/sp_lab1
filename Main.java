import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Word> sorter_words=get();
        printQueue(sorter_words);
    }
    public static Queue<Word> get() {
        File file = new File("input.txt");
        Scanner s = null;
        try {
            s = new Scanner(file).useDelimiter("[^A-Za-z]");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            throw new RuntimeException(e);
        }
        Queue<Word> queue=new PriorityQueue<Word>(lengthComparator);
        while (s.hasNext()) {

            String text=s.next();
            if(!text.isEmpty()){
                Word word=new Word(text);
                queue.add(word);
            }
        }
        return queue;
    }
    public static void printQueue (Queue<Word> queue){
        while(!queue.isEmpty()){
            System.out.println(queue.poll().getWord());
        }
    }
    public static Comparator<Word> lengthComparator = new Comparator<Word>(){

        @Override
        public int compare(Word w1, Word w2) {
            int l1=w1.getLength();
            int l2=w2.getLength();
            if(l1==l2) return 0;
            else if (l1>l2) return 1;
            else return -1;
        }
    };

}

