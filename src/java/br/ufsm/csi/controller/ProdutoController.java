package br.ufsm.csi.controller;

import br.ufsm.csi.DAO.ProdutoDAO;
import br.ufsm.csi.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ProdutoController {

    @RequestMapping("cadastrarProduto")
    public ResponseEntity<Integer> cadastrarProduto(@RequestBody Produto produto) {

        return new ResponseEntity<Integer>(
            new ProdutoDAO().cadastrarProduto(produto), HttpStatus.OK
        );
    }

    @RequestMapping("removerProduto")
    public ResponseEntity<Boolean> removerProduto(@RequestBody Produto produto) {

        return new ResponseEntity<Boolean>(
            new ProdutoDAO().removerProduto(produto.getIdProduto()), HttpStatus.OK
        );
    }

    @RequestMapping("getProdutos")
    public ResponseEntity<ArrayList<Produto>> getProdutos() {

        return new ResponseEntity<ArrayList<Produto>>(
            new ProdutoDAO().getProdutos(), HttpStatus.OK
        );
    }
}
