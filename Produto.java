public class Produto {
   
    private String nome;
    private String codigo;
    private int quantidade;
    private String cor;
    private float tamanho;
    private float peso;
    private float preco;

    public Produto(String nome, String codigo, int quantidade, String cor, float tamanho, float peso, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade < 0 ? 0 : quantidade;
        this.cor = cor;
        this.tamanho = tamanho;
        this.peso = peso;
        this.preco = preco;
    }

    public void venda(int numero_itens) {
        if (numero_itens > quantidade) {
            System.out.println("Quantidade insuficiente em estoque.");
            return;
        }
        quantidade -= numero_itens;
    }

    public void pagamento(String forma_pagamento, float valor_pago, int numero_itens) {
        if (numero_itens > quantidade) {
            System.out.println("Quantidade insuficiente em estoque.");
            return;
        }

        if (forma_pagamento.equals("Especie") || forma_pagamento.equals("Debito") || forma_pagamento.equals("Transferencia") || forma_pagamento.equals("Pix")) {
            float desconto = 0.05f * preco;
            float valor_acumulado = (preco - desconto) * numero_itens;

            if (forma_pagamento.equals("Especie")) {
                float troco = valor_pago - valor_acumulado;
                if (valor_pago < valor_acumulado) {
                    System.out.println("Valor insuficiente para o pagamento.");
                    return;
                } else {
                    System.out.println("Troco: " + troco);
                }
            }

            System.out.println("Deseja prosseguir com o pagamento? (sim/nao)");
            String resposta = new java.util.Scanner(System.in).nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                venda(numero_itens);
                return;
            }
        } else {
            System.out.println("Para pagamento em credito, pode parcelar em 5 vezes, ficando cada parcela com o valor de " + (preco * numero_itens) / 5);
            System.out.println("Deseja realizar o pagamento? (sim/nao)");
            String resposta = new java.util.Scanner(System.in).nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                venda(numero_itens);
                return;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade < 0 ? 0 : quantidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
