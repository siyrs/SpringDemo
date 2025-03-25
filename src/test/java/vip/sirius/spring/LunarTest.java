package vip.sirius.spring;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import org.junit.jupiter.api.Test;

public class LunarTest {

    @Test
    public void test() {
        Lunar lunar = Lunar.fromYmd(1989, 2, 18);

        System.out.println(lunar);
        System.out.println(lunar.toFullString());

        Lunar lunar2 = new Lunar();
        System.out.println(lunar2.toFullString());

        Solar solar = lunar2.getSolar();
        System.out.println(solar.toFullString());
    }
}
