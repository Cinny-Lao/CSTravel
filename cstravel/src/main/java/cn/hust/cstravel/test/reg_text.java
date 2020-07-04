package cn.hust.cstravel.test;

public class reg_text {
    public static void main(String[] args) {
        String reg = "1\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";
        String tel = "sunny";
        boolean b = tel.matches(reg);
        System.out.println(b);
    }


}
