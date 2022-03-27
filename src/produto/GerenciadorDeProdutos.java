/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.util.*;

/**
 *
 * @author EdreyC
 */
public class GerenciadorDeProdutos {

    private static List<Produto> produtos = new ArrayList<Produto>();

    public static String addProduto(Produto p) {

        produtos.add(p);
        System.out.println("Produto Adicionado");
        return "Produto adicionado";
    }

    public static Produto consultaProduto(String desc, String marca) {
        Produto atual;
        for (int i = 0; i < produtos.size(); i++) {
            atual = produtos.get(i);
            if (atual.getNome().equals(desc) && atual.getMarca().equals(marca)) {
                System.out.println(atual);

                return atual;
            }

        }
        return null;
    }

    public static String removeProduto(String desc, String marca) {
        Produto saindo = consultaProduto(desc, marca);
        if (saindo == null) {
            System.out.println("Produto não encontrado");
            return "Produto não encontrado";
        } else {
            produtos.remove(saindo);
            System.out.println("Produto removido com sucesso");
            System.out.println(produtos);
            return "Produto removido com sucesso";
        }
    }

    public static String atualizaProduto(String desc, String marca, String nDesc, String nMarca, Double nPreco) {
        Produto att = consultaProduto(desc, marca);
        if (att == null) {
            return "Produto não encontrado";
        } else {
            int index = produtos.indexOf(att);
            produtos.get(index).setNome(nDesc);
            produtos.get(index).setMarca(nMarca);
            produtos.get(index).setPreco(nPreco);
            System.out.println("Produto atualizado com sucesso");
            System.out.println(att);
            System.out.println(produtos);
            return "Produto atualizado com sucesso";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adicione 3 produtos");

        for (int i = 0; i <= 2; i++) {

            System.out.println("Digite a marca do produto");
            String marca = scanner.next();

            System.out.println("Digite a nome do produto");
            String nome = scanner.next();

            System.out.println("Digite a preço do produto");
            Double preco = scanner.nextDouble();
            Produto produto = new Produto(marca, nome, preco);

            addProduto(produto);
            if (i == 2) {
                System.out.println(produtos);
            }

        }
        System.out.println("Consulte um produto");
        System.out.println("Digite a descrição do produto:");
        String nome = scanner.next();
        System.out.println("Digite a marca do produto:");
        String marca = scanner.next();
        consultaProduto(nome, marca);

        System.out.println("Atualize um produto");
        System.out.println("Digite a descrição do produto que quer atualizar:");
        nome = scanner.next();
        System.out.println("Digite a marca do produto que quer atualizar:");
        marca = scanner.next();
        System.out.println("Digite o novo nome do produto que quer atualizar:");
        String nNome = scanner.next();

        System.out.println("Digite a nova marca do produto que quer atualizar:");
        String nMarca = scanner.next();
        System.out.println("Digite o novo preço do produto que quer atualizar:");
        Double nPreco = scanner.nextDouble();

        atualizaProduto(nome, marca, nNome, nMarca, nPreco);

        System.out.println("Delete um produto");
        System.out.println("Digite a descrição do produto:");
        nome = scanner.next();
        System.out.println("Digite a marca do produto:");
        marca = scanner.next();
        removeProduto(nome, marca);

    }

}
