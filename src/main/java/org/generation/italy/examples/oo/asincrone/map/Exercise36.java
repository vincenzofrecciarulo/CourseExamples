package org.generation.italy.examples.oo.asincrone.map;

import java.util.HashMap;
import java.util.Map;

public class Exercise36 {

    static void main() {
        Map<String,Integer> nomi = new HashMap<>();
        String prompt;

        do{
            prompt = IO.readln("Inserisci un nome ");
            if(nomi.get(prompt)==null){
                nomi.put(prompt,1);
            }else {
                Integer oldValue = nomi.get(prompt);
                Integer newValue = oldValue +1;
                nomi.put(prompt,newValue);
            }



        }while(!(prompt.equals("")));

        for(Map.Entry<String,Integer> kv :nomi.entrySet() ){
            if(!(kv.getKey().equals(""))){
                IO.println(kv.getKey()+" "+kv.getValue());
            }
        }

    }


}
