package it.volta.ts.smirnovartur.eser1.recurs;

public class Recurs {

    public String initRecurs (String str){
        if (str.length() == 1){
            return str;
        }else{
            return str.substring(1, str.length());
        }
    }

}
