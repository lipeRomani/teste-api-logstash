package com.example;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private Logger logger;

    public ProductController() {
        this.logger = LogManager.getLogger(ProductController.class.getName());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> products(){
        logger.info("Productos listados com sucesso");
        return ProductMock.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        logger.warn("Produto " + product.getName() + " salvo com sucesso.");
        return ProductMock.save(product);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Product update(@RequestBody Product product){

        if(product.getId() == null){
            logger.error("Erro ao atualizar");
            throw new RuntimeException("Erro ao Atualizar");
        }

        logger.warn("Produto ATUALIZADO com sucesso");
        return product;
    }

}
