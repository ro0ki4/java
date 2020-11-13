package pan.xu;

import java.util.ArrayList;
import java.util.List;

public class Heap_out_of_memory {
    static class OOMObject{

    }
    public static void main(String[]args){
        List<OOMObject> list=new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
