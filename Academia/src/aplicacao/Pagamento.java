package aplicacao;

public class Pagamento {
    private int id_pagamento, id_aluno;
    private String data_vencimento, status, tipo_pagamento, metodo_pagamento;
    private float valor;

    public Pagamento(int id_pagamento, int id_aluno, String data_vencimento, float valor, String status, String tipo_pagamento,
            String metodo_pagamento) {
        this.id_pagamento = id_pagamento;
        this.id_aluno = id_aluno;
        this.data_vencimento = data_vencimento;
        this.valor = valor;
        this.status = status;
        this.tipo_pagamento = tipo_pagamento;
        this.metodo_pagamento = metodo_pagamento;
    }

    public Pagamento(int id_aluno, String data_vencimento, float valor, String status, String tipo_pagamento,
            String metodo_pagamento) {
        this.id_aluno = id_aluno;
        this.data_vencimento = data_vencimento;
        this.valor = valor;
        this.status = status;
        this.tipo_pagamento = tipo_pagamento;
        this.metodo_pagamento = metodo_pagamento;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public String getMetodo_pagamento() {
        return metodo_pagamento;
    }

    public void setMetodo_pagamento(String metodo_pagamento) {
        this.metodo_pagamento = metodo_pagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }
}
