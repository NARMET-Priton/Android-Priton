package it.volta.ts.smirnovartur.recursionApp.recurs;

public class Recurs {

    public String initRecurs (String str){
        if (str.length() == 1)
            return str;

        return initRecurs(str.substring(1)) + str.charAt(0);
    }

}