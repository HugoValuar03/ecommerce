package br.unitins.topicos1.model;

public enum BandeiraCartao {
    MASTERCARD(1, "MasterCard"),
    VISA(2, "Visa"),
    ELO(3, "Elo");

    private int id;
    private String bandeira;

    private BandeiraCartao(int id, String bandeira) {
        this.id = id;
        this.bandeira = bandeira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

}
