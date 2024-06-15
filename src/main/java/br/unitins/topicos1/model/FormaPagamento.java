package br.unitins.topicos1.model;

public enum FormaPagamento {
    PIX(1, "Pix"),
    DEBITO(2, "Débito"),
    CREDITO(3, "Crédito"),
    BOLETO(4, "Boleto");

    private int id;
    private String pagamento;
    
    private FormaPagamento(int id, String pagamento) {
        this.id = id;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

}
