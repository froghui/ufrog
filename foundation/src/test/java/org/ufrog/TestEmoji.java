package org.ufrog;

/**
 * @author froghui
 * @version $Id: TestEmoji.java, v 0.1 16/5/26 10:34 froghui Exp $
 */
public class TestEmoji {

    public static void main(String[] args) {
        System.out.println("aaa Here is a boy: \uD83D\uDC66\uD83C\uDFFF!");

        StringBuffer sb = new StringBuffer();
        sb.append(Character.toChars(127467));
        sb.append(Character.toChars(127479));
        System.out.println(sb);
    }
}