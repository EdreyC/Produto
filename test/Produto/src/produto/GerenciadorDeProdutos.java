/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.util.*;

/**
 *
 * @author ALUNO
 */
public class GerenciadorDeProdutos {
    
    private List <Produto> produtos = new ArrayList <Produto>();
    
    public String addProduto(Produto p){
        produtos.add(p);
        return "Produto adicionado";
    }
    
    public Produto consultaProduto(String desc, String marca){
        Produto atual;
        for(int i = 0; i < produtos.size(); i++){
            atual = produtos.get(i);
            if(atual.getDescricao().equals(desc) && atual.getMarca().equals(marca)){
                return atual;
            }
        }
        return null;
    }
    
    public String removeProduto(String desc, String marca){
        Produto saindo = consultaProduto(desc, marca);
        if(saindo == null){
            return "Produto não encontrado";
        } else {
            produtos.remove(saindo);
            return "Produto removido com sucesso";
        }
    }
    
    public String atualizaProduto(String desc, String marca, String nDesc, String nMarca, Double nPreco){
        Produto att = consultaProduto(desc, marca);
        if(att == null){
            return "Produto não encontrado";
        } else {
            int index = produtos.indexOf(att);
            produtos.get(index).setDescricao(nDesc);
            produtos.get(index).setMarca(nMarca);
            produtos.get(index).setPreco(nPreco);
            return "Produto atualizado com sucesso";
        }
    }
    
}
