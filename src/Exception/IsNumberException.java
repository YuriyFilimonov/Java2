package Exception;

public class IsNumberException extends Exception {
    private int num;

    public IsNumberException(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "IsNumberException{" +
                "num=" + num +
                '}';
    }
}
