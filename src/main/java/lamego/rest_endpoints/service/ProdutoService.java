package lamego.rest_endpoints.service;

import lamego.rest_endpoints.entity.Produto;
import lamego.rest_endpoints.exception.ProductNullException;
import lamego.rest_endpoints.exception.ProductPriceException;
import lamego.rest_endpoints.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) throws Exception {
        if(produto.getName() == null || produto.getPrice() == null)
            throw new ProductNullException();
        if(produto.getPrice() < 0)
            throw new ProductPriceException();

        return repository.save(produto);
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }
}
