package br.unitins.topicos1.model;

public class Cameras {
    

    public enum Marcas{

        CANON("Canon"),
        NIKON("Nikon"),
        SONY("Sony"),
        FUJFILM("Fujfilm"),
        PANASONIC("Panasonic");
    
        private String marca;
    
        Marcas(String marca){
            this.marca = marca;
        }
    }

    public enum Sensor{
        FULL_FRAME("Full Frame"),
        ASP_H("ASP-H"),
        ASP_C("ASP-C"),
        MICRO_FOUR_THIRDS("Micro Four Thirds"),
        MEDIUM_FORMAT("Medium Format"),
        CX("CX"),
        CCD( "CCD" ),
        CMOS("CMOS");

        private String sensor;

        Sensor(String  sensor) {
            this.sensor = sensor;
    }

    public enum Processador{
        DIGIC("Digic"),
        
    }
}
