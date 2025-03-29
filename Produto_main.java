public class Produto_main {
    public static void main(String[] args) {
        // Criando um produto
        Produto produto = new Produto("Camiseta", "C001", 10, "Azul", 1.5f, 0.2f, 50.0f);

        // Exibindo informações do produto
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade em estoque: " + produto.getQuantidade());

        // Realizando um pagamento
        System.out.println("\nRealizando um pagamento para 2 itens...");
        System.out.println("Escolha a forma de pagamento (Especie, Debito, Transferencia, Pix, Credito):");
        String formaPagamento = new java.util.Scanner(System.in).nextLine();
        System.out.println("Informe o valor pago:");
        float valorPago = new java.util.Scanner(System.in).nextFloat();
        produto.pagamento(formaPagamento, valorPago, 2);

        // Exibindo quantidade final em estoque
        System.out.println("\nQuantidade final em estoque: " + produto.getQuantidade());
    }
}
