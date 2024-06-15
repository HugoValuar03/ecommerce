package br.unitins.topicos1.model;

public enum StatusPedido {
    CONCLUIDO(1, "Concluido"),
    CANCELADO(2, "Cancelado"),
    ENVIADO(3, "Enviado"),
    PAGAMENTO_PENDENTE(4, "Pagamento pendente"),
    PAGO(5, "Pago");

    private int id;
    private String status;

    private StatusPedido(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public static StatusPedido valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(StatusPedido statuspedido : StatusPedido.values()) {
            if (id.equals(statuspedido.getId()))
                return statuspedido;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
