package com.ecommerce.produtos.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.produtos.api.model.Categoria;
import com.ecommerce.produtos.api.repository.CategoriaRepository;



@Service
public class CategoriaService {
    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRespository.save(categoria);
    }

    public List<Categoria> obterListaCategoria() {
        return categoriaRespository.findAll();
    }

    public Page<Categoria> obterPaginasCategoria(Pageable page) {
        return categoriaRespository.findAll(page);
    }

    public Optional<List<Categoria>> obterCategoriaPeloNome(String nome) {

        Optional<List<Categoria>> categorias = categoriaRespository.findByNome(nome);

        if (categorias.isEmpty()) {
            return categoriaRespository.findByNomeLike("%" + nome + "%");

        }
        return null;
    }

    @Autowired
    private CategoriaRepository categoriaRespository;

}
