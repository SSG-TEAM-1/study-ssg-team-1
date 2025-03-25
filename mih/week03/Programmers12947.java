package week03;

public class Programmers12947 {
    public boolean solution(int x) {
        int div = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x % div == 0;
    }
}
