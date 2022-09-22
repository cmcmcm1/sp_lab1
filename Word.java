import java.io.File;

public class Word {
    public String word;
    int length;
    public Word(String word){
        this.word=word;
        this.length=word.length();
        this.cut();
    }

    public int getLength() {
        return this.length;
    }

    public String getWord() {
        return this.word;
    }
    public void cut() {
        this.word = this.word.replace("\n", "").replace("\r", "").trim();
        if (this.word.length() > 30) {
            this.word=this.word.substring(0, 30);
            this.length=30;
        }
    }
}
