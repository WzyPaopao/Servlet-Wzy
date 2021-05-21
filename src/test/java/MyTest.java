import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wzy.wzy_shop.util.R;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    public void testJson01() {
        R r = R.build();
        r.setCode(200);
        r.setMsg("go");
        System.out.println("===========");
        System.out.println(r);
        System.out.println(JSON.toJSONString(r));
    }

    @Test
    public void testThis() {
        TestClass t1 = new TestClass();
        TestClass t2 = new TestClass();
        t1.go();
        t2.go();
    }
}
